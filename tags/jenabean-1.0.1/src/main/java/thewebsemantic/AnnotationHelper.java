package thewebsemantic;

public interface AnnotationHelper {

	boolean isGenerated(ValuesContext ctx);

	boolean isEmbedded(Object bean);

	boolean proxyRequired();

	Class getProxy(Class<?> c) throws InstantiationException, IllegalAccessException;

}
