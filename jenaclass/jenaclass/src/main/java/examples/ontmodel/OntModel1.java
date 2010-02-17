package examples.ontmodel;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class OntModel1 {

	public static void main(String[] args) {
		
		OntModel ontModel = ModelFactory.createOntologyModel();
		ontModel.read("http://www.heppnetz.de/ontologies/goodrelations/v1.owl");
		
	}
}
