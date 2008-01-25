package test.thing;

import java.util.Date;

import thewebsemantic.As;
import thewebsemantic.Namespace;

@Namespace("http://purl.org/dc/elements/1.1/")
public interface DublinCore extends As {
	public DublinCore setSubject(String s);
	public DublinCore setContributor(String s);
	public DublinCore setCoverage(String s);
	public DublinCore setCreator(String s);
	public DublinCore setDate(Date d);
	public DublinCore setDescription(String s);
	public DublinCore setFormat(String s);
	public DublinCore setIdentifier(String s);
	public DublinCore setLanguage(String s);
	public DublinCore setPublisher(String s);
	public DublinCore setRelation(String s);
	public DublinCore setRights(String s);
	public DublinCore setSource(String s);
	

	public String getContributor();
	public String getCoverage();
	public String getCreator();
	public String getDate();
	public String getDescription();
	public String getFormat();
	public String getIdentifier();
	public String getLanguage();
	public String getPublisher();
	public String getRelation();
	public String getRights();
	public String getSource();
	public String getSubject();
	public String getTitle();
	public String getType();
	

	
}
