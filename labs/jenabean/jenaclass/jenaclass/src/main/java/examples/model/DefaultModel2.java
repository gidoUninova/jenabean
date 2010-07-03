package examples.model;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDFS;
import com.hp.hpl.jena.vocabulary.XSD;

public class DefaultModel2 {
	
	public static void main(String[] args) {
		
		Model m = ModelFactory.createDefaultModel();	
		m.setNsPrefix("rdfs", RDFS.getURI());
		m.setNsPrefix("xsd", XSD.getURI());
		Resource r = m.createResource("http://meetup/nyc");
		r.addLiteral(RDFS.label, "New York Semantic Web Meetup");
		m.write(System.out, "N3");
		
	}

}
