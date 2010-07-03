package examples.ontmodel;

import static examples.goodrelations.Goodrelations.PriceSpecification;

import java.util.List;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class OntModel4 {

	public static void main(String[] args) {
		
		OntModel ontModel = ModelFactory.createOntologyModel();
		ontModel.read("file:bestbuy/goodrelations.owl");
		ontModel.read("file:bestbuy/semanticweb.rdf");
		
		OntClass bizentityClass = ontModel.getOntClass(PriceSpecification.getURI());
		List<OntClass> classes =  bizentityClass.listSubClasses().toList();
		for (OntClass ontClass : classes)
			System.out.println(ontClass.getURI());
	
	}
}
