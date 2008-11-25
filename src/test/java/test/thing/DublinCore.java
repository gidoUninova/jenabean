package test.thing;

import java.util.Collection;
import java.util.Date;

import thewebsemantic.As;
import thewebsemantic.Functional;
import thewebsemantic.Namespace;
import thewebsemantic.Thing;

@Namespace("http://purl.org/dc/elements/1.1/")
public interface DublinCore extends As {

	public DublinCore subject(String s);
	public DublinCore subject(Thing t);
	public DublinCore contributor(String s);
	public DublinCore coverage(String s);
	public DublinCore creator(String s);

	@Functional
	public DublinCore date(Date d);
	public DublinCore description(String s);
	public DublinCore format(String s);
	public DublinCore identifier(String s);
	public DublinCore language(String s);
	public DublinCore publisher(String s);
	public DublinCore relation(String s);
	public DublinCore rights(String s);
	public DublinCore source(String s);

	@Functional
	public DublinCore title(String s);
	public Collection<String> contributor();
	public String coverage();
	public Collection<String> creator();
	public Date date();
	public String description();
	public String format();
	public String identifier();
	public String language();
	public String publisher();
	public String relation();
	public String rights();
	public String source();
	public Collection<String> subject();
	public String title();
	public String type();
	

	
}
