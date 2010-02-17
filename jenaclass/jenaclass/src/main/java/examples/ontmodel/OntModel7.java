package examples.ontmodel;

import java.util.List;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.OWL;

import examples.goodrelations.Goodrelations;

import static java.lang.System.out;

/**
 * Asking an Individual for it's properties
 */
public class OntModel7 {

	public static void main(String[] args) {
		
		Model ontology = FileManager.get().loadModel("file:bestbuy/goodrelations.owl");
		OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM, ontology);
		ontModel.setNsPrefix("gr", "http://purl.org/goodrelations/v1#");

		String uri = Goodrelations.durationOfWarrantyInMonths.getURI();		
		OntProperty p = ontModel.getOntProperty(uri);
		List<? extends OntResource> domain = p.listDomain().toList();
		for (OntResource ontResource : domain) {
			System.out.println("domain: " + ontResource);
		}

		List<? extends OntResource> range = p.listRange().toList();
		for (OntResource ontResource : range) {
			System.out.println("range: " + ontResource);
		}
		
		OntResource r = ontModel.createOntResource ("http://foo/thing");
		Literal duration = ontModel.createTypedLiteral(6);
		r.setPropertyValue(Goodrelations.durationOfWarrantyInMonths, duration);

		List<Resource> types = r.listRDFTypes(false).toList();
		for (Resource resource : types) {
			System.out.println("new resource isa " + resource);
		}
		
	}
}
