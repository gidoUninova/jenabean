package example.foaf;

import java.util.Collection;

import thewebsemantic.Resource;
import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;
import thewebsemantic.Uri;

@Namespace(FoafUri.NS)
public class Person {
	String name;
	Resource homepage;
	String uri;
	Collection<Person> knows;
	Collection<Document> publications;
	Document openid; 
	Collection<Document> seealso;
	
	public Person(String uri) {
		this.uri = uri;
	}
	
	@Uri
	public String uri() {
		return uri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@RdfProperty("http://www.w3.org/2000/01/rdf-schema#seeAlso")
	public Collection<Document> getSeeAlso() {
		return seealso;
	}

	
	public void setSeeAlso(Collection<Document> seealso) {
		this.seealso = seealso;
	}

	public Resource getHomepage() {
		return homepage;
	}

	public void setHomepage(Resource homepage) {
		this.homepage = homepage;
	}
}
