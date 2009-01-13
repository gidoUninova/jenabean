package thewebsemantic;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;

public class IdMethodTypeWrapper extends TypeWrapper {

	private Method idReadMethod;
	private Method idWriteMethod;

	/*
	 * if true this type wrapper services a class with id of type java.lang.URI
	 */
	private boolean uriid = false;
	private Constructor uriConstructor;

	public IdMethodTypeWrapper(Class<?> c, Method m) {
		super(c);
		idReadMethod = m;
		uriid = URI.class.equals(idReadMethod.getReturnType());

		if (uriid) {
			// get the URI constructor if it exists
			try {
				uriConstructor = c.getConstructor(URI.class);
			} catch (NoSuchMethodException e) {
				// now get the id write method property
				PropertyDescriptor[] props = descriptors();
				for (PropertyDescriptor propertyDescriptor : props)
					if (idReadMethod.equals(propertyDescriptor.getReadMethod()))
						idWriteMethod = propertyDescriptor.getWriteMethod();
			}
		}

	}
	
	@Override
	public String uri(String id) {
		if (uriid)
			return id;
		else
			return typeUri() + '/' + id;
	}

	public String id(Object bean) {
		return invokeMethod(bean, idReadMethod);
	}

	public ValuesContext[] getValueContexts(Object o) {
		ArrayList<ValuesContext> values = new ArrayList<ValuesContext>();		
		for (PropertyDescriptor property : descriptors()) {
			if (uriid && idReadMethod.equals(property.getReadMethod()))
				continue;
			values.add( new PropertyContext(o, property) );			
		}
		return values.toArray(new ValuesContext[0]);
	}

	public Object toBean(String uri) {
		try {
			if (uriid && uriConstructor != null)
				return uriConstructor.newInstance(URI.create(uri));
			else if (idWriteMethod != null) {
				Object obj = c.newInstance();
				idWriteMethod.invoke(obj,URI.create(uri));
				return obj;
			} else
				return super.toBean(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
