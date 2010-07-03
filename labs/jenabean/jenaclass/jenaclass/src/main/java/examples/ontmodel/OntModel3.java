package examples.ontmodel;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

import static examples.goodrelations.Goodrelations.*;

public class OntModel3 {

	public static void main(String[] args) {
		
		OntModel ontModel = ModelFactory.createOntologyModel();
		ontModel.read("file:bestbuy/goodrelations.owl");
		ontModel.read("file:bestbuy/semanticweb.rdf");
		
		OntClass bizentityClass = ontModel.getOntClass(BusinessEntity.getURI());
	
		ExtendedIterator<? extends OntResource> bizInstances = bizentityClass.listInstances();
		while(bizInstances.hasNext()) {
			Individual i = (Individual)bizInstances.next();
			Literal name = i.getPropertyValue(legalName).as(Literal.class);
			System.out.println(name.getString());
		}
	}
}
