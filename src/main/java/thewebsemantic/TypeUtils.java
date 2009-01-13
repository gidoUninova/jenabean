package thewebsemantic;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TypeUtils {
	public static Field[] getDeclaredFields(Class c) {
		ArrayList<Field> fields = new ArrayList<Field>();
		for (Field field : c.getDeclaredFields())
			add(fields, field);
		Class<?> cls = c;
		while (cls.getSuperclass() != Object.class && cls.getSuperclass() != null) {
			cls = cls.getSuperclass();
			for (Field field : cls.getDeclaredFields())
				add(fields,field);
		}
		return fields.toArray(new Field[0]);
	}

	private static void add(ArrayList<Field> fields, Field field) {
		fields.add(field);
	}
}
