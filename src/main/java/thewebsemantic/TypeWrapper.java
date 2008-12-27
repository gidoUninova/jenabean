package thewebsemantic;

import static thewebsemantic.Util.last;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Retrieves annotation information as well as other type related operations on
 * Classes. Keeps cached versions to minimize introspection work.
 * 
 */
public abstract class TypeWrapper {
	public static final String JENABEAN_PREFIX = "jenabean.prefix";
	public static final String JENABEAN_FIELDACCESS = "jenabean.fieldaccess";
	private String NS;
	protected Class<?> c;
	private BeanInfo info;
	protected Constructor<?> constructor;
	private static HashMap<Class<?>, TypeWrapper> cache = new HashMap<Class<?>, TypeWrapper>();
	private String prefix = null;
	
	protected <T> TypeWrapper(Class<T> c) {
		prefix = System.getProperty(JENABEAN_PREFIX);
		this.c = c;
		info = beanInfo(c);
		Namespace nsa = c.getAnnotation(Namespace.class);
		NS = (nsa != null) ? nsa.value():getNamespaceFromPackage(c);
		try {
			constructor = c.getConstructor(String.class);
		} catch (Exception e) {}
		cache.put(c, this);
	}

	private String getNamespaceFromPackage(Class<?> c) {
		return (c.getPackage() == null) ?
			"http://default.package/":
			"http://" + c.getPackage().getName() + '/';
	}

	public static synchronized TypeWrapper type(Object o) {
		return wrap(o.getClass());
	}

	public static String getId(Object o) {
		return type(o).id(o);
	}

	public static ValuesContext[] valueContexts(Object o) {
		return (isFieldLevelAccess()) ? viaFields(o) : viaBeanProperties(o);
	}
	
	public ValuesContext getProperty(String name) {
		if (isFieldLevelAccess()) {
			try {
				Field f = c.getDeclaredField(name);
				return new FieldContext(null, f);
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		} else {
			for (PropertyDescriptor p : descriptors()) {
				if (p.getName().equals(name))
					return new NullPropertyContext(this, p);
			}
		}
		return null;
	}

	private static boolean isFieldLevelAccess() {
		String sFieldLevelAccess =  System.getProperty(JENABEAN_FIELDACCESS, "false");
		return Boolean.valueOf(sFieldLevelAccess);
	}

	//TODO: needs to be cached in TypeWrapper
	private static ValuesContext[] viaBeanProperties(Object o) {
		PropertyDescriptor[] props = type(o).descriptors();
		ValuesContext[] values = new ValuesContext[props.length];
		for (int i = 0; i < props.length; i++)
			values[i] = new PropertyContext(o, props[i]);
		return values;
	}


	private Field[] getDeclaredFields() {
		Field[] chunk = c.getDeclaredFields();
		ArrayList<Field> fields = new ArrayList<Field>();

		for (Field field : chunk)
			fields.add(field);
		Class<?> cls = c;
		while ( cls.getSuperclass() != Object.class) {
			cls = cls.getSuperclass();
			chunk = cls.getDeclaredFields();
			for (Field field : chunk)
				fields.add(field);
		}
		return fields.toArray(new Field[0]);
	}
	
	private static ValuesContext[] viaFields(Object o) {
		Class<?> c = o.getClass();
		TypeWrapper t = TypeWrapper.wrap(c);
		Field[] fields = t.getDeclaredFields();
		ArrayList<FieldContext> values = new ArrayList<FieldContext>();
		for (Field field : fields)
			if ( !Modifier.isTransient(field.getModifiers()) )
				values.add(new FieldContext(o, field));
		return values.toArray(new ValuesContext[0]);
	}
	
	public static synchronized TypeWrapper wrap(Class<?> c) {
		return (cache.containsKey(c)) ? cache.get(c) : newwrapper(c);
	}
	
	private static TypeWrapper newwrapper(Class<?> c) {
		BeanInfo info = beanInfo(c);
		if (c.isEnum())
			return new EnumTypeWrapper(c);
		for (MethodDescriptor md : info.getMethodDescriptors())
			if (isId(md))
				return new IdTypeWrapper(c,md.getMethod());
			else if (isUri(md))
				return new UriTypeWrapper(c,md.getMethod());
		return new DefaultTypeWrapper(c);
	}

	public String typeUri() {
        return NS + Util.getRdfType(c);
	}

    public static String typeUri(Class<?> c) {
		return wrap(c).typeUri();
	}
	
	private PropertyDescriptor[] descriptors() {
		Collection<PropertyDescriptor> results = new LinkedList<PropertyDescriptor>();
		for (PropertyDescriptor p : info.getPropertyDescriptors())
			if (p.getWriteMethod() != null && p.getReadMethod() != null)
				results.add(p);
		return results.toArray(new PropertyDescriptor[0]);
	}

	public String[] collections() {
		Collection<String> results = new LinkedList<String>();		
		if (isFieldLevelAccess()) {
			Field[] fields = getDeclaredFields();
			for (Field field : fields)
				if (field.getType().equals(Collection.class))
					results.add(field.getName());			
		} else {
			for (PropertyDescriptor p : info.getPropertyDescriptors())
				if (p.getWriteMethod() != null
						&& p.getPropertyType().equals(Collection.class))
					results.add(p.getName());			
		}
		return results.toArray(new String[0]);
	}

	public String namespace() {
		return NS;
	}

	public abstract String uri(String id);


	public String uri(Object bean) {
		return typeUri() + '/' + id(bean);
	}
	
	public String uri(AccessibleObject m, String name) {
		RdfProperty rdf = getRDFAnnotation(m);
		return ("".equals(rdf.value())) ? namingPatternUri(name) : rdf.value();
	}
	
	protected static RdfProperty getRDFAnnotation(AccessibleObject m) {
		return (m.isAnnotationPresent(RdfProperty.class)) ? m
				.getAnnotation(RdfProperty.class) : new NullRdfProperty();
	}

	private String namingPatternUri(String name) {
		return namespace() + prefix(name);
	}
	
	private String prefix(String p) {
		return (prefix != null) ? prefix + Util.toProperCase(p):p;
	}

	public static String instanceURI(Object bean) {
		return type(bean).uri(bean);
	}

	/**
	 * Reterns the ID 
	 * @param bean
	 * @return
	 */
	public abstract String id(Object bean);

	private static BeanInfo beanInfo(Class<?> c) {
		try {
			return Introspector.getBeanInfo(c);
		} catch (IntrospectionException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	protected String invokeMethod(Object bean, Method me) {
		try {
			return me.invoke(bean).toString();
		} catch (Exception e) {
		}
		return null;
	}

	private static boolean isId(Method m) {
		return m.isAnnotationPresent(Id.class) || m.isAnnotationPresent(javax.persistence.Id.class);
	}

	private static boolean isId(MethodDescriptor md) {
		return isId(md.getMethod());
	}

	private static boolean isUri(Method m) {
		return m.isAnnotationPresent(Uri.class);
	}

	private static boolean isUri(MethodDescriptor md) {
		return isUri(md.getMethod());
	}

	/**
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public Object toBean(Resource source) {
		return toBean(source.getURI());
	}
	
	public Object toBean(String uri) {
		try {
			// last gets the id off the end of the URI
			return (constructor != null) ?
				constructor.newInstance(last(uri)):
				c.newInstance();
		} catch (Exception e) {e.printStackTrace();
		}
		return null;
	}


	

}
