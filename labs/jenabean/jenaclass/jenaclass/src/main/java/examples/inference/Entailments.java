package examples.inference;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Entailments {

	public static String domain = "http://examples.com/inference#";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
		//OntModel model = ModelFactory.createOntologyModel();
		//OntModel model = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC); 

		OntProperty myProperty = model.createOntProperty(domain + "hasMember");
		OntProperty otherProperty = model.createOntProperty(domain + "other");

		myProperty.convertToFunctionalProperty();
		myProperty.isFunctionalProperty();
		
		myProperty.convertToInverseFunctionalProperty();
		myProperty.isIndividual();
		
		myProperty.convertToSymmetricProperty();
		myProperty.isSymmetricProperty();
		
		myProperty.convertToTransitiveProperty();
		myProperty.isTransitiveProperty();
		
		myProperty.setInverseOf(otherProperty);
		
		model.write(System.out, "N3");
	}
}