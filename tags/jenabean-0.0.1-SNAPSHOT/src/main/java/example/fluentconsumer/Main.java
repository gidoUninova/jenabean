package example.fluentconsumer;

import static java.lang.System.out;
import thewebsemantic.Thing;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Main {
	
	public static void main(String[] args) {
		
		OntModel m = ModelFactory.createOntologyModel();
		// no internet?  m.read("file:foaf.rdf");
		m.read("http://danbri.org/foaf.rdf");
		m.read("http://xmlns.com/foaf/spec/index.rdf");
		
		Thing t = new Thing(m);
		t = t.at("http://danbri.org/foaf.rdf#danbri");
		String firstName = t.as(Foaf.class).name();
		System.out.println(firstName + " knows the following people:");
		for (Thing friend : t.as(Foaf.class).knows())
			if (friend.as(Foaf.class).name() != null)
				out.println('\t' + friend.as(Foaf.class).name());
		
		for (Thing mbox : t.as(Foaf.class).mbox() ) {		
			Thing replaces = mbox.as(DCTerms.class).isReplacedBy();
			System.out.println(mbox.getResource().getURI());
			if (replaces != null)
				out.println("\treplaced by" + replaces.getResource());
		}
	}
}
