package example;

import java.util.Collection;
import thewebsemantic.RdfProperty;
import thewebsemantic.Uri;
import static example.GeonamesVocabulary.NS;

public class City {

	private Collection<String> alternateNames;
	private String name;
	private String id;
	
	public City(String uri) {
		id = uri;
	}
	
	@Uri
	public String getUri() {
		return id;
	}
	
	@RdfProperty(NS + "name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@RdfProperty(NS + "alternateName")
	public Collection<String> getAlternateNames() {
		return alternateNames;
	}

	public void setAlternateNames(Collection<String> alternateNames) {
		this.alternateNames = alternateNames;
	}
	
}
