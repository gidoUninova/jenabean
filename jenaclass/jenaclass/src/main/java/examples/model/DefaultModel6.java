package examples.model;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDFS;
import com.hp.hpl.jena.vocabulary.XSD;

public class DefaultModel6 {
	
	public static void main(String[] args) {
		
		Model m = ModelFactory.createDefaultModel();	
		m.setNsPrefix("xsd", XSD.getURI());

		Resource hotel = m.createResource("http://hilton.com/1");
		hotel.addProperty(RDFS.comment, "comment one");
		hotel.addProperty(RDFS.comment, "comment two");
		
		StmtIterator statements =  hotel.listProperties(RDFS.comment);
		while(statements.hasNext()) {
			// work with statement here
		}
		statements.close();
	}

}
