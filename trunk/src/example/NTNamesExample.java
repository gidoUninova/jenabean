package example;

import java.util.Collection;

import thewebsemantic.Sparql;
import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import static thewebsemantic.binding.Jenabean.*;

public class NTNamesExample {

	public static void main(String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		m.read("file:src/example/NTNames.owl");
		OntDocumentManager.getInstance().addAltEntry(
				"http://www.semanticbible.org/2006/11/NTNames.owl",
				"file:src/example/NTNames.owl");
		m.read("file:src/example/NTN-individuals.owl");
		Jenabean J = Jenabean.instance();
		J.bind(m);
		setupBindings(J);
		long t1 = System.currentTimeMillis();
		Collection<Woman> women = load(Woman.class);
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);

		for (Woman w : women) {
			J.reader().fill(w).with("children"); // loads getChildren() 
			System.out.println(w.getClass().getSimpleName() + ":" +  w.uri() + " : " + tickler(w));
			for (Human child : w.getChildren())
				System.out.println("\tparent of " + child.uri());
		}
		
		// demonstrate loading beans from a sparql query
		// Rebecca had two sons, Esau and Jacob
		String query =
			"PREFIX : <http://semanticbible.org/ns/2006/NTNames#>\n" +
			"SELECT ?s WHERE {?s :childOf :Rebecca .  ?s a :Man }";
		Collection<Man> men = Sparql.exec(m, Man.class, query);
		for (Man man : men)	System.out.println(man.uri());
	}

	private static void setupBindings(Jenabean J) {
		J.bind(NTNames.Man_CLASS).to(Man.class);
		J.bind(NTNames.Woman_CLASS).to(Woman.class);
		J.bind(NTNames.Human_CLASS).to(Human.class);
	}

	private static String tickler(Human h) {
		String desc = h.getDescription();
		if (desc == null)
			return "";		
		return (desc.length()>=30) ? desc.substring(0,30):desc;
	}
}
