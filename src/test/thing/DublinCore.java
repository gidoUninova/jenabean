package test.thing;

import java.util.Date;

import thewebsemantic.Namespace;

@Namespace("http://purl.org/dc/elements/1.1/")
public interface DublinCore {
	public void contributor(String s);
	public void coverage(String s);
	public void creator(String s);
	public void date(Date d);
	public void description(String s);
	public void format(String s);
	public void identifier(String s);
	public void language(String s);
	public void publisher(String s);
	public void relation(String s);
	public void rights(String s);
	public void source(String s);
	public void subject(String s);
	public void title(String s);
	public void type(String s);
}
