package thewebsemantic;

public class NullJPAHelper implements AnnotationHelper {

	public boolean isGenerated(ValuesContext ctx) {
		return false;
	}

	public boolean isEmbedded(Object bean) {
		return false;
	}

	public boolean proxyRequired() {
		return false;
	}

	@Override
	public Class getProxy(Class<?> c) throws InstantiationException,
			IllegalAccessException {
		throw new UnsupportedOperationException();
	}

}
