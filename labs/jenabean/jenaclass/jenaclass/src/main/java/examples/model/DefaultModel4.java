package examples.model;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDFS;
import com.hp.hpl.jena.vocabulary.XSD;

public class DefaultModel4 {
	
	public static void main(String[] args) {
		
		Model m = ModelFactory.createDefaultModel();	
		m.setNsPrefix("xsd", XSD.getURI());

		Property rating = m.createProperty("http://opentravel.org/star_rating");
		rating.addLiteral(RDFS.comment, "indicates the rating of a property");
		Resource hotel = m.createResource("http://hilton.com/1");
		hotel.addLiteral(rating, 5);
		hotel.addLiteral(rating, 2.333);
		m.write(System.out, "N3");
		
	}

}
