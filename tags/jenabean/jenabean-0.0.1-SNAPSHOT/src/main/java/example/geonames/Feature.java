package example.geonames;

import java.net.URI;
import java.util.Collection;

import thewebsemantic.Id;
import thewebsemantic.LocalizedString;
import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;

/**
 * This class represents a Feature in the geonames ontology.  
 * It's class name is important and not arbitrary.  
 * It maps directly to the similarly named 
 * "Feature" class, given that the namespace is defined using
 * the {@link Namespace} annotation.
 * 
 */
@Namespace("http://www.geonames.org/ontology#")
public class Feature {
	
	@Id
	private URI uri;	
	
	@RdfProperty("http://www.w3.org/2003/01/geo/wgs84_pos#lat")
	public double lat;

	/**
	 * Add a field for longitude and provide the appropriate 
	 * annotation. Inspect the example rdf in london.rdf to 
	 * see how the longitude is encoded in the resource.
	 */
	
	/**
	 * Add a field for "name".  Inspect the example rdf in london.rdf
	 * to see how the feature name is encoded
	 */
	
	/**
	 * this property maps to the namespace defined at the class level (geonames).
	 * It's literal name is appended to the namespace to construct
	 * the property URI.
	 */
	public Collection<LocalizedString> alternateName;

	public Feature(URI uri) {
		this.uri = uri;
	}
	
	public Feature() {}

	public URI getUri() {
		return uri;
	}

}
