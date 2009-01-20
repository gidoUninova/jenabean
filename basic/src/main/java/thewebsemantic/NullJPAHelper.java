package thewebsemantic;

public class NullJPAHelper implements JPAHelper {

	@Override
	public boolean isGenerated(ValuesContext ctx) {
		return false;
	}

	@Override
	public boolean isEmbedded(Object bean) {
		return false;
	}

}
