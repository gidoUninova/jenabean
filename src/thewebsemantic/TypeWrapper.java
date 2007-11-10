package thewebsemantic;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Retrieves annotation information as well as other type related operations on
 * Classes. Keeps cached versions to minimize introspection work.
 * 
 * @author Taylor Cowan
 */
public class TypeWrapper {

	private Class<?> c;
	private BeanInfo info;
	private static HashMap<Class<?>, TypeWrapper> cache = new HashMap<Class<?>, TypeWrapper>();

	private <T> TypeWrapper(Class<T> c) {
		this.c = c;
		info = beanInfo(c);
		cache.put(c, this);
	}

	public static String ns(Object o) {
		return get(o).namespace();
	}
	
	public static String ns(Class<?> c) {
		return get(c).namespace();
	}
	
	public static synchronized TypeWrapper get(Object o) {
		return get(o.getClass());
	}

	public static synchronized TypeWrapper get(Class<?> c) {
		return (cache.containsKey(c)) ? cache.get(c) : new TypeWrapper(c);
	}

	public String rdfTypeName() {
		return namespace() + Util.className(c);
	}

	public PropertyDescriptor[] descriptors() {
		return info.getPropertyDescriptors();
	}

	private Namespace getNamespaceAnnotation() {
		return (Namespace) c.getAnnotation(Namespace.class);
	}

	public String namespace() {
		return getNamespaceAnnotation().value();
	}

	public String uri(Object bean) {
		return namespace() + id(bean);
	}

	private String id(Object bean) {
		for (MethodDescriptor md : info.getMethodDescriptors())
			if (isId(md))
				return invokeIdMethod(bean, md.getMethod());
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
}
