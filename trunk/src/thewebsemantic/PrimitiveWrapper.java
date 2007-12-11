package thewebsemantic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PrimitiveWrapper {
	private static final Map<Class<?>, Class<?>> WRAPPERS = new HashMap<Class<?>, Class<?>>();

	static {
		WRAPPERS.put(Byte.class, Byte.class);
		WRAPPERS.put(Short.class, Short.class);
		WRAPPERS.put(Character.class, Character.class);
		WRAPPERS.put(Integer.class, Integer.class);
		WRAPPERS.put(Long.class, Long.class);
		WRAPPERS.put(Float.class, Float.class);
		WRAPPERS.put(Double.class, Double.class);
		WRAPPERS.put(Boolean.class, Boolean.class);
		WRAPPERS.put(String.class, String.class);
		WRAPPERS.put(Date.class, Date.class);
		
	}

	public static boolean isPrimitive(Class<?> c) {
		return WRAPPERS.containsKey(c) || c.isPrimitive();
	}

	public static boolean isPrimitive(Object o) {
		return isPrimitive(o.getClass());
	}
}
