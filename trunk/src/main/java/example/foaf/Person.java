package example.foaf;

import java.util.Collection;



import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;
import thewebsemantic.Uri;

@Namespace(FoafUri.NS)
public class Person {
	String name;
	Document homepage;
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

	public Document getHomepage() {
		return homepage;
	}

	public void setHomepage(Document homepage) {
		this.homepage = homepage;
	}
}
