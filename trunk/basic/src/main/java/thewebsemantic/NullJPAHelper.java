package thewebsemantic;

public class NullJPAHelper implements AnnotationHelper {

	public boolean isGenerated(ValuesContext ctx) {
		return false;
	}

	public boolean isEmbedded(Object bean) {
		return false;
	}

}
