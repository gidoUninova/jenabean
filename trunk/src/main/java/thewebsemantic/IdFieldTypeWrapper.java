package thewebsemantic;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class IdFieldTypeWrapper extends TypeWrapper {

	private Field idfield;
	private Field[] fields;
	
	public IdFieldTypeWrapper(Class<?> c, Field f, Field[] fields) {
		super(c);
		idfield = f;
		this.fields = fields;
	}

	@Override
	public String id(Object bean) {
		Object result=null;
		try {
			if (! idfield.isAccessible() )
				idfield.setAccessible(true);
			result = idfield.get(bean);
		} catch (Exception e) {e.printStackTrace();}
		return result.toString();
	}

	@Override
	public String uri(String id) {
		return typeUri() + '/' + id;
	}

	public String[] collections() {
		Collection<String> results = new LinkedList<String>();
		for (Field field : fields)
			if (field.getType().equals(Collection.class))
				results.add(field.getName());
		return results.toArray(new String[0]);
	}

	public ValuesContext getProperty(String name) {
		try {
			Field f = c.getDeclaredField(name);
			return new FieldContext(null, f);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ValuesContext[] getValueContexts(Object o) {
		ArrayList<FieldContext> values = new ArrayList<FieldContext>();
		for (Field field : fields)
			if (!Modifier.isTransient(field.getModifiers()))
				values.add(new FieldContext(o, field));
		return values.toArray(new ValuesContext[0]);
	}


}
