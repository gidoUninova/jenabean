package example.foaf;

import java.util.Collection;

import thewebsemantic.Namespace;
import thewebsemantic.Uri;

@Namespace(FoafUri.NS)
public class Person {
	String name;
	String uri;
	Collection<Person> knows;
	Collection<Document> publications;
	Document openid; 
	
	public Person(String uri) {
		this.uri = uri;
	}
	
	@Uri
	public String uri() {
		return uri;
	}
}
