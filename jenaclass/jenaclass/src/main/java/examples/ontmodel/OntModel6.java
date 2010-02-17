package examples.ontmodel;

import java.util.List;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.OWL;

import static java.lang.System.out;

/**
 * Asking an Individual for it's properties
 */
public class OntModel6 {

	public static void main(String[] args) {

	
		
		Model ontology = FileManager.get().loadModel("file:bestbuy/goodrelations.owl");
		OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF, ontology);
		ontModel.read("file:bestbuy/semanticweb.rdf");
		ontModel.setNsPrefix("bb", "http://stores.bestbuy.com/semanticweb#");

		String fullURI = ontModel.expandPrefix("bb:BusinessEntity");
		Individual businessEntity = ontModel.getIndividual(fullURI);
		
		// lets take a look at all of its data properties
		List<Statement> stmts = businessEntity.listProperties().toList();
		for (Statement statement : stmts) {
			String s = statement.getPredicate() + "->" + " " + statement.getObject();
			out.println(s);
		}
		
		//ask if it's an instance of OWL:Thing
		System.out.println(businessEntity.hasOntClass(OWL.Thing));
		
	}
}
