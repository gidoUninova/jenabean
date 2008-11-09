package thewebsemantic;

import java.lang.reflect.Method;

public class IdTypeWrapper extends TypeWrapper {
	
	private Method idMethod;
	public IdTypeWrapper(Class<?> c, Method m) {
		super(c);
		idMethod = m;
	}

	@Override
	public String uri(String id) {
		return typeUri() + '/' + id;
	}

	public String id(Object bean) {
		return invokeMethod(bean, idMethod);
	}

}
