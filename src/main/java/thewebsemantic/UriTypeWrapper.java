package thewebsemantic;

import java.lang.reflect.Method;

public class UriTypeWrapper extends TypeWrapper {

	private Method uriMethod;
	
	public UriTypeWrapper(Class<?> c, Method m) {
		super(c);
		uriMethod = m;
	}

	@Override
	public String uri(Object bean) {
		return invokeMethod(bean, uriMethod);
	}

	@Override
	public String uri(String id) {
		return id;
	}

	public String id(Object bean) {
		return invokeMethod(bean, uriMethod);
	}
	
	public Object toBean(String uri) {
		try {
			return (constructor != null) ?
				constructor.newInstance(uri):c.newInstance();
		} catch (Exception e) {e.printStackTrace();
		}
		return null;
	}

}
