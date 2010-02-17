package examples.ontmodel;

import static examples.goodrelations.Goodrelations.PriceSpecification;

import java.util.List;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.ModelFactory;

/**
 * A "frames" based look at the PriceSpefication type of the goodrelations
 * vocabulary.
 */
public class OntModel5 {

	public static void main(String[] args) {
		
		OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF);
		ontModel.read("file:bestbuy/goodrelations.owl");	

		OntClass pricespecClass = ontModel.getOntClass(PriceSpecification.getURI());
		List<OntProperty> properties =  pricespecClass.listDeclaredProperties(true).toList();
		for (OntProperty ontProperty : properties) {
			if (ontProperty.getLabel(null) != null)
				System.out.println(ontProperty.getLabel(null));
			else
				System.out.println(ontProperty.getURI());
		}
	}
}
