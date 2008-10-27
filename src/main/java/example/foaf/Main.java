package example.foaf;

import static thewebsemantic.binding.Jenabean.load;

import java.io.IOException;
import java.util.Collection;

import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Main {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		OntModel m = ModelFactory.createOntologyModel();
		m.read("http://richard.cyganiak.de/foaf.rdf#cygri");
		m.read("http://www.deri.ie/fileadmin/scripts/foaf.php?id=316");
		Jenabean J = Jenabean.instance();
		J.bind(m);
		J.bindAll("example.foaf");
		
		Collection<Person> people = load(Person.class);
		for (Person person : people) {
			System.out.println(person.name + person.homepage);
		}
	}
	
}
