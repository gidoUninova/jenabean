package examples.model;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.vocabulary.DCTerms;

/**
 * Converting from short form URI's to long form
 * and vice versa.
 */
public class DefaultModel7 {
	
	public static void main(String[] args) {
		
		Model m = ModelFactory.createDefaultModel();	
		m.read("file:bestbuy/dcterms.rdf");
		m.setNsPrefix("dcterms", DCTerms.NS);
		String longForm = m.expandPrefix("dcterms:title");
		System.out.println(longForm);
		
		String shortForm = m.shortForm(longForm);
		System.out.println(shortForm);
	}

}
