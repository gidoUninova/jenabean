package thewebsemantic;

public interface AnnotationHelper {

	boolean isGenerated(ValuesContext ctx);

	boolean isEmbedded(Object bean);

	Object proxy(Object o);

}
