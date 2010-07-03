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
		Jenabean J = Jenabean.instance();
		J.bind(m);
		J.bind(NTNames.Man_CLASS).to(Man.class);
		J.bind(NTNames.Woman_CLASS).to(Woman.class);
		J.bind(NTNames.Human_CLASS).to(Human.class);
		long t1 = System.currentTimeMillis();
		Collection<Human> humans = load(Human.class);
		Collection<Woman> women = load(Woman.class);
		Collection<Man> men = load(Man.class);
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		System.out.println("Humans: " + humans.size());
		System.out.println("Men: " + men.size());
		System.out.println("Women: " + women.size());
		System.out.println("Humans contains first man..." + humans.contains(men.iterator().next()));

		//for (Human man : men) {
		//	System.out.println(man.getClass().getSimpleName() + ":" +  man.uri() + " : " + tickler(man));
		//}
	}

	private static String tickler(Human man) {
		if (man.getDescription() == null)
			return "";
		String desc = man.getDescription();
		if (desc.length()>=20)
			return man.getDescription().substring(0,20);
		else
			return desc;
	}
}
