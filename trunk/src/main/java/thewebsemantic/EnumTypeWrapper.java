package thewebsemantic;

import static thewebsemantic.Util.last;


public class EnumTypeWrapper extends TypeWrapper {
	
	public EnumTypeWrapper(Class<?> c) {
		super(c);
	}

	@Override
	public String uri(String id) {
		return typeUri() + '/' + id;
	}

	public String id(Object bean) {
		return ((Enum)bean).name();
	}
	
	public Object toBean(String uri) {
		try {
			Class<? extends Enum> d =  (Class<? extends Enum>)c;
			return Enum.valueOf(d, last(uri));
		} catch (Exception e) {e.printStackTrace();
		}
		return null;
	}

}
