package thewebsemantic;

import java.beans.BeanInfo;
import java.beans.MethodDescriptor;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TypeWrapperFactory {
	public static TypeWrapper newwrapper(Class<?> c) {
		BeanInfo info = TypeWrapper.beanInfo(c);
		if (c.isEnum())
			return new EnumTypeWrapper(c);
		for (MethodDescriptor md : info.getMethodDescriptors())
			if (isId(md))
				return new IdMethodTypeWrapper(c, md.getMethod());
			else if (isUri(md))
				return new UriMethodTypeWrapper(c, md.getMethod());
		Field[] fields = TypeUtils.getDeclaredFields(c);
		for (Field f : fields) {
			if (isId(f))
				return new IdFieldTypeWrapper(c, f, fields);
		}
		return new DefaultTypeWrapper(c);
	}
	private static boolean isId(AccessibleObject m) {
		return m.isAnnotationPresent(Id.class)
				|| m.isAnnotationPresent(javax.persistence.Id.class);
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
}
