package example;

import java.util.Collection;

import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import static thewebsemantic.binding.Jenabean.*;

public class NTNamesExample {

	public static final String ONT1 = "urn:ntnames:1";

	public static void main(String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		m.read("file:src/example/NTNames.owl");
		OntDocumentManager.getInstance().addAltEntry(
				"http://www.semanticbible.org/2006/11/NTNames.owl",
				"file:src/example/NTNames.owl");
		
		m.read("file:src/example/NTN-individuals.owl");

		Jenabean.instance().bind(m);
		Jenabean.instance().bind(m.getOntClass(NTNames.Man_CLASS)).to(Man.class);
		long t1 = System.currentTimeMillis();
		Collection<Man> men = load(Man.class);
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		System.out.println(men.size());
		for (Man man : men) {
			System.out.println(man.uri() + " : " + tickler(man));
		}

	}

	private static String tickler(Man man) {
		if (man.getDescription() == null)
			return "";
		String desc = man.getDescription();
		if (desc.length()>=20)
			return man.getDescription().substring(0,20);
		else
			return desc;
	}
}
