package examples.model;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;


import com.hp.hpl.jena.vocabulary.DC;
import com.hp.hpl.jena.vocabulary.RDFS;
import com.hp.hpl.jena.vocabulary.XSD;

public class DefaultModel3 {
	
	public static void main(String[] args) {
		
		Model m = ModelFactory.createDefaultModel();	
		m.setNsPrefix("rdfs", RDFS.getURI());
		m.setNsPrefix("xsd", XSD.getURI());
		m.setNsPrefix("foaf", FOAF.getURI());
		m.setNsPrefix("dc", DC.getURI());
		
		Resource marco = m.createResource("http://www.meetup.com/members/2316446/");
		marco.addLiteral(FOAF.name, "Marco Neumann");
		m.createResource("http://meetup/nyc").
		   addLiteral(RDFS.label, "New York Semantic Web Meetup").
			addProperty(FOAF.member, marco).
		   addProperty(DC.description, "semweb group in New York City", "en");
		m.write(System.out, "N3");
		
	}

}
