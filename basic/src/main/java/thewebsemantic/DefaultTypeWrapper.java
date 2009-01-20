package thewebsemantic;

public class DefaultTypeWrapper extends TypeWrapper {

	public DefaultTypeWrapper(Class<?> c) {
		super(c);
	}
	
	@Override
	public String uri(String id) {
		return typeUri() + '/' + id;
	}

	public String id(Object bean) {
		return String.valueOf(bean.hashCode());
	}



}
