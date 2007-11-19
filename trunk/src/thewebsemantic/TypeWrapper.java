package thewebsemantic;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
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
	private Method idMethod;
	private static HashMap<Class<?>, TypeWrapper> cache = new HashMap<Class<?>, TypeWrapper>();

	private <T> TypeWrapper(Class<T> c) {
		this.c = c;
		info = beanInfo(c);
		for (MethodDescriptor md : info.getMethodDescriptors())
			if (isId(md))
				idMethod = md.getMethod();
		cache.put(c, this);
	}

	public static String ns(Object o) {
		return type(o).namespace();
	}
	
	public static boolean isMarked(Object o) {
		return o.getClass().isAnnotationPresent(Namespace.class);
	}
	
	public static synchronized TypeWrapper type(Object o) {
		return get(o.getClass());
	}

	public static synchronized TypeWrapper get(Class<?> c) {
		return (cache.containsKey(c)) ? cache.get(c) : new TypeWrapper(c);
	}

	public String typeUri() {
		return namespace() + Util.className(c);
	}

	public PropertyDescriptor[] descriptors() {
		return info.getPropertyDescriptors();
	}
	
	public Field[] fields() {
		return c.getFields();
	}

	private Namespace getNamespaceAnnotation() {
		return (Namespace) c.getAnnotation(Namespace.class);
	}

	private String namespace() {
		return getNamespaceAnnotation().value();
	}

	public String uri(String id) {
		return typeUri() + '/' + id;
	}
	
	public String uri(Object bean) {
		return typeUri() + '/' + id(bean);
	}

	private String id(Object bean) {
		return ( idMethod != null) ? invokeIdMethod(bean, idMethod) : String.valueOf(bean.hashCode());
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
