package thewebsemantic;

import static thewebsemantic.Bean2RDF.logger;
import static thewebsemantic.Util.last;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;

public class IdFieldTypeWrapper extends TypeWrapper {

	private Field idfield;
	private Field[] fields;
	private boolean uriid = false;
	
	public IdFieldTypeWrapper(Class<?> c, Field f, Field[] fields) {
		super(c);
		idfield = f;
		uriid = idfield.getType().equals(URI.class);
		this.fields = fields;
	}

	@Override
	public String id(Object bean) {
		Object result=null;
		try {
			if (! idfield.isAccessible() )
				idfield.setAccessible(true);
			result = idfield.get(bean);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Error retrieving id field value.", e);

		}
		return result.toString();
	}

	
	@Override
	public String uri(String id) {
		if (idfield.getType().equals(URI.class))
			return id;
		else
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
		for (Field field : fields) {
			if (field.equals(idfield) && uriid)
				continue;
			if (!Modifier.isTransient(field.getModifiers()))
				values.add(new FieldContext(o, field));
		}
		return values.toArray(new ValuesContext[0]);
	}

	public Object toBean(String uri) {
		try {
			// last gets the id off the end of the URI
			return (constructor != null) ? constructor.newInstance(last(uri))
					: newinstance(uri);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Could not instantiate bean.", e);

		}
		return null;
	}
	
	private Object newinstance(String uri) throws Exception {
		Object o = c.newInstance();
		if (uriid)
			idfield.set(o, URI.create(uri));
		return o;
	}


}
