package example.fluentconsumer;

import thewebsemantic.As;
import thewebsemantic.Namespace;
import thewebsemantic.Thing;

@Namespace("http://purl.org/dc/terms/")
public interface DCTerms extends As {
	DCTerms isReplacedBy(Object t);
	Thing isReplacedBy();

}
