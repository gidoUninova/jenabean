package test.thing;

import java.util.Date;
import thewebsemantic.Namespace;

@Namespace("http://purl.org/dc/elements/1.1/")
public interface DublinCore {
	public DublinCore subject(String s);
	public DublinCore contributor(String s);
	public DublinCore coverage(String s);
	public DublinCore creator(String s);
	public DublinCore date(Date d);
	public DublinCore description(String s);
	public DublinCore format(String s);
	public DublinCore identifier(String s);
	public DublinCore language(String s);
	public DublinCore publisher(String s);
	public DublinCore relation(String s);
	public DublinCore rights(String s);
	public DublinCore source(String s);
	

	public String contributor();
	public String coverage();
	public String creator();
	public String date();
	public String description();
	public String format();
	public String identifier();
	public String language();
	public String publisher();
	public String relation();
	public String rights();
	public String source();
	public String subject();
	public String title();
	public String type();
	

	
}
