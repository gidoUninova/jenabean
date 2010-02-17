package examples.model;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.vocabulary.XSD;

public class DefaultModel5 {
	
	public static void main(String[] args) {
		
		Model m = ModelFactory.createDefaultModel();	
		m.setNsPrefix("xsd", XSD.getURI());

		Property rating = m.createProperty("http://opentravel.org/star_rating");
		Resource hotel = m.createResource("http://hilton.com/1");
		hotel.addLiteral(rating, 5);
		
		Statement stmt =  hotel.getProperty(rating);
		Literal value = stmt.getLiteral();
		int stars = value.getInt();
		System.out.println(stars);
		
		//OR...
		
		stars = stmt.getInt();
		System.out.println(stars);
		
	}

}
