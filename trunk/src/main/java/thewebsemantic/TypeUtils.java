package thewebsemantic;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TypeUtils {
	public static Field[] getDeclaredFields(Class c) {
		Field[] chunk = c.getDeclaredFields();
		ArrayList<Field> fields = new ArrayList<Field>();

		for (Field field : chunk)
			fields.add(field);
		Class<?> cls = c;
		while (cls.getSuperclass() != Object.class && cls.getSuperclass() != null) {
			cls = cls.getSuperclass();
			chunk = cls.getDeclaredFields();
			for (Field field : chunk)
				fields.add(field);
		}
		return fields.toArray(new Field[0]);
	}
}
