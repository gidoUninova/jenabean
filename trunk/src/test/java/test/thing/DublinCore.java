package test.thing;

import java.util.Collection;
import java.util.Date;

import thewebsemantic.As;
import thewebsemantic.Namespace;
import thewebsemantic.Thing;

@Namespace("http://purl.org/dc/elements/1.1/")
public interface DublinCore extends As {
	public DublinCore setsubject(String s);
	public DublinCore addsubject(String s);
	public DublinCore addsubject(Thing t);
	public DublinCore setcontributor(String s);
	public DublinCore setcoverage(String s);
	public DublinCore setcreator(String s);
	public DublinCore setdate(Date d);
	public DublinCore setdescription(String s);
	public DublinCore setformat(String s);
	public DublinCore setidentifier(String s);
	public DublinCore setlanguage(String s);
	public DublinCore setpublisher(String s);
	public DublinCore setrelation(String s);
	public DublinCore setrights(String s);
	public DublinCore setsource(String s);
	public DublinCore settitle(String s);
	

	public Collection<String> getcontributor();
	public String getcoverage();
	public Collection<String> getcreator();
	public Date getdate();
	public String getdescription();
	public String getformat();
	public String getidentifier();
	public String getlanguage();
	public String getpublisher();
	public String getrelation();
	public String getrights();
	public String getsource();
	public Collection<String> getsubject();

	public String gettitle();
	public String gettype();
	

	
}
