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
public class TypeWrapper {
	public static final String JENABEAN_PREFIX = "jenabean.prefix";
	public static final String JENABEAN_FIELDACCESS = "jenabean.fieldaccess";
	private String NS;
	private Class<?> c;
	private BeanInfo info;
	private Method idMethod;
	private Method uriMethod;
	private Constructor<?> constructor;
	private static HashMap<Class<?>, TypeWrapper> cache = new HashMap<Class<?>, TypeWrapper>();
	private String prefix = null;
	
	private <T> TypeWrapper(Class<T> c) {
		prefix = System.getProperty(JENABEAN_PREFIX);
		this.c = c;
		info = beanInfo(c);
		for (MethodDescriptor md : info.getMethodDescriptors())
			if (isId(md))
				idMethod = md.getMethod();
			else if (isUri(md))
				uriMethod = md.getMethod();
		
		Namespace nsa = c.getAnnotation(Namespace.class);
		NS = (nsa != null) ? nsa.value() : "http://"
				+ c.getPackage().getName() + '/';
		try {
			constructor = c.getConstructor(String.class);
		} catch (Exception e) {}
		cache.put(c, this);
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

	private static boolean isFieldLevelAccess() {
		String sFieldLevelAccess =  System.getProperty(JENABEAN_FIELDACCESS, "false");
		boolean fieldLevelAccess = Boolean.valueOf(sFieldLevelAccess);
		return fieldLevelAccess;
	}

	//TODO: needs to be cached in TypeWrapper
	private static ValuesContext[] viaBeanProperties(Object o) {
		PropertyDescriptor[] props = type(o).descriptors();
		PropertyContext[] values = new PropertyContext[props.length];
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
		return (cache.containsKey(c)) ? cache.get(c) : new TypeWrapper(c);
	}

	public String typeUri() {
		return NS + c.getSimpleName();
	}

	public PropertyDescriptor[] descriptors() {
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

	public Field[] fields() {
		return c.getFields();
	}

	public String namespace() {
		return NS;
	}

	public String uri(String id) {
		return (uriSupport()) ? id:typeUri() + '/' + id;
	}

	public String uri(Object bean) {
		return (uriSupport()) ?  invokeMethod(bean, uriMethod): typeUri() + '/' + id(bean);
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
	public String id(Object bean) {
		if ( uriSupport() )
			return invokeMethod(bean, uriMethod);
		else if (idMethod != null)
			return invokeMethod(bean, idMethod);
		else 
			return String.valueOf(bean.hashCode());
	}

	private BeanInfo beanInfo(Class<?> c) {
		try {
			return Introspector.getBeanInfo(c);
		} catch (IntrospectionException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private String invokeMethod(Object bean, Method me) {
		try {
			return me.invoke(bean).toString();
		} catch (Exception e) {
		}
		return null;
	}

	private boolean isId(Method m) {
		return m.isAnnotationPresent(Id.class);
	}

	private boolean isId(MethodDescriptor md) {
		return isId(md.getMethod());
	}

	private boolean isUri(Method m) {
		return m.isAnnotationPresent(Uri.class);
	}

	private boolean isUri(MethodDescriptor md) {
		return isUri(md.getMethod());
	}

	public boolean uriSupport() {
		return uriMethod != null;
	}

	/**
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public Object toBean(Resource source) {
		try {
			Constructor<?> m = constructor;
			if (m != null) {
				return (uriSupport()) ? m.newInstance(source.getURI()) : m
						.newInstance(last(source.getURI()));
			}
			return c.newInstance();
		} catch (Exception e) {e.printStackTrace();
		}
		return null;
	}


	

}
