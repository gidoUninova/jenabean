package thewebsemantic;

import static thewebsemantic.Util.last;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
	private String NS;
	private Class<?> c;
	private BeanInfo info;
	private Method idMethod;
	private Method uriMethod;
	private Constructor<?> constructor;
	private static HashMap<Class<?>, TypeWrapper> cache = new HashMap<Class<?>, TypeWrapper>();
	private String prefix = null;
	
	private <T> TypeWrapper(Class<T> c) {
		prefix = System.getProperty("jenabean.prefix");
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
		} catch (Exception e) {
		}
		cache.put(c, this);
	}

	public static synchronized TypeWrapper type(Object o) {
		return wrap(o.getClass());
	}

	public static String getId(Object o) {
		return type(o).id(o);
	}
	
	public static PropertyDescriptor[] descriptors(Object o) {
		return type(o).descriptors();
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

	public PropertyDescriptor[] collections() {
		Collection<PropertyDescriptor> results = new LinkedList<PropertyDescriptor>();
		for (PropertyDescriptor p : info.getPropertyDescriptors())
			if (p.getWriteMethod() != null
					&& p.getPropertyType().equals(Collection.class))
				results.add(p);
		return results.toArray(new PropertyDescriptor[0]);
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

	/**
	 * returns a URI pointing to the rdf property resource. If the property
	 * descriptor is annotated with an explicit uri, then we'll use the URI
	 * specified in the annotation, otherwise a URI is created using the
	 * following naming pattern. <br/><br/> If the property name is "age" and
	 * the namespace for this type is http://example.org/, the resulting URI
	 * will be <code>http://example.org/hasAge</code>.
	 * 
	 * @param pd
	 * @return
	 */
	public String uri(PropertyDescriptor pd) {
		RdfProperty rdf = getAnnotation(pd.getReadMethod());
		return ("".equals(rdf.value())) ? namingPatternUri(pd) : rdf.value();
	}

	public RdfProperty getAnnotation(Method m) {
		return (m.isAnnotationPresent(RdfProperty.class)) ? m
				.getAnnotation(RdfProperty.class) : new NullRdfProperty();
	}

	private String namingPatternUri(PropertyDescriptor pd) {
		return namespace() + prefix(pd.getName());
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

	public boolean isSymmetric(PropertyDescriptor p) {
		return (p.getReadMethod().isAnnotationPresent(Symmetric.class)) ? true
				: getAnnotation(p.getReadMethod()).symmetric();
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

	class NullRdfProperty implements RdfProperty {
		public boolean symmetric() {
			return false;
		}

		public boolean transitive() {
			return false;
		}

		public String value() {
			return "";
		}

		public Class<? extends Annotation> annotationType() {
			return null;
		}
	}
	
	public String inspect() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(typeUri() + "\n");
		for (PropertyDescriptor d : this.descriptors()) {
			buffer.append("\t" + uri(d) + "\n");
		}
		return buffer.toString();
	}
}
