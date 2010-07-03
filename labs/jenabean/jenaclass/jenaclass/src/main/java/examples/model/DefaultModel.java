package examples.model;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDFS;

public class DefaultModel {
	
	public static void main(String[] args) {
		
		Model m = ModelFactory.createDefaultModel();		
		Resource r = m.createResource("http://meetup/nyc");
		r.addLiteral(RDFS.label, "New York Semantic Web Meetup");
		m.write(System.out, "N3");
		
	}

}
