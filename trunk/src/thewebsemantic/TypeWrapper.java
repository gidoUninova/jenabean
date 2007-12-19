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

import com.hp.hpl.jena.ontology.Individual;

/**
 * Retrieves annotation information as well as other type related operations on
 * Classes. Keeps cached versions to minimize introspection work.
 * 
 */
public class TypeWrapper {
	private static final String HAS = "has";

	private String NS;
	private Class<?> c;
	private BeanInfo info;
	private Method idMethod;
	private Method uriMethod;
	private static HashMap<Class<?>, TypeWrapper> cache = new HashMap<Class<?>, TypeWrapper>();

	private <T> TypeWrapper(Class<T> c) {
		this.c = c;
		info = beanInfo(c);
		for (MethodDescriptor md : info.getMethodDescriptors())
			if (isId(md))
				idMethod = md.getMethod();
			else if (isUri(md))
				uriMethod = md.getMethod();
		Namespace nsa = getNamespaceAnnotation();
		NS = (nsa != null) ? getNamespaceAnnotation().value() : "http://"
				+ c.getPackage().getName() + '/';
		cache.put(c, this);
	}

	public static synchronized TypeWrapper type(Object o) {
		return wrap(o.getClass());
	}

	public static synchronized TypeWrapper wrap(Class<?> c) {
		return (cache.containsKey(c)) ? cache.get(c) : new TypeWrapper(c);
	}

	public String typeUri() {
		return namespace() + Util.className(c);
	}

	public PropertyDescriptor[] descriptors() {
		Collection<PropertyDescriptor> results = new LinkedList<PropertyDescriptor>();
		for (PropertyDescriptor p : info.getPropertyDescriptors())
			if (p.getWriteMethod() != null)
				results.add(p);
		return results.toArray(new PropertyDescriptor[0]);
	}

	public PropertyDescriptor[] collections() {
		Collection<PropertyDescriptor> results = new LinkedList<PropertyDescriptor>();
		for (PropertyDescriptor p : info.getPropertyDescriptors())
			if (p.getWriteMethod() != null && p.getPropertyType().equals(Collection.class))
				results.add(p);
		return results.toArray(new PropertyDescriptor[0]);
	}
	
	public Field[] fields() {
		return c.getFields();
	}

	private Namespace getNamespaceAnnotation() {
		return (Namespace) c.getAnnotation(Namespace.class);
	}

	public String namespace() {
		return NS;
	}

	public String uri(String id) {
		return typeUri() + '/' + id;
	}

	public String uri(Object bean) {
		return typeUri() + '/' + id(bean);
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
		return (m.isAnnotationPresent(RdfProperty.class)) ?
			m.getAnnotation(RdfProperty.class):
			new NullRdfProperty();
	}

	private String namingPatternUri(PropertyDescriptor pd) {
		return namespace() + HAS + Util.toProperCase(pd.getName());
	}

	public static String instanceURI(Object bean) {
		TypeWrapper t = type(bean);
		return (t.uriSupport()) ? t.getUri(bean) : t.uri(bean);
	}

	private String id(Object bean) {
		return (idMethod != null) ? invokeIdMethod(bean, idMethod) : String
				.valueOf(bean.hashCode());
	}

	private String getUri(Object bean) {
		return (uriMethod != null) ? invokeIdMethod(bean, uriMethod) : String
				.valueOf(bean.hashCode());
	}

	private BeanInfo beanInfo(Class<?> c) {
		try {
			return Introspector.getBeanInfo(c);
		} catch (IntrospectionException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private String invokeIdMethod(Object bean, Method me) {
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
	 * shin means new in Japanese
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public Object toBean(Individual source) {
		try {
		try {
			Constructor<?> m = c.getConstructor(String.class);
			return (uriSupport()) ? m.newInstance(source.getURI()):
				m.newInstance(last(source.getURI()));
		} catch (NoSuchMethodException e) {
			// this is expected, we'll use default constructor
		}
		return c.newInstance();
		} catch (Exception e) {}
		return null;
	}

	class NullRdfProperty implements RdfProperty {
		@Override
		public boolean symmetric() {
			return false;
		}
		@Override
		public boolean transitive() {
			return false;
		}
		@Override
		public String value() {
			return "";
		}
		@Override
		public Class<? extends Annotation> annotationType() {
			return null;
		}
	}
}
