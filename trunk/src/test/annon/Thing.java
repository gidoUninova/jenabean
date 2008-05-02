package test.annon;

import thewebsemantic.Namespace;
import thewebsemantic.Uri;

@Namespace("http://thewebsemantic.com/")
public class Thing {
	String name;
	Thing knows;
	String uri;
	
	public Thing(String uri) {		
		this.uri=uri;
	}
	
	@Uri
	public String uri() {return uri;}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Thing getKnows() {
		return knows;
	}

	public void setKnows(Thing knows) {
		this.knows = knows;
	}
}
