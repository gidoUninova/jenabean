package example.foaf;

import java.io.IOException;
import java.util.Collection;

import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Main {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Model m = ModelFactory.createDefaultModel();
		m.read("http://richard.cyganiak.de/foaf.rdf#cygri");
		m.read("http://bblfish.net/people/henry/card");
		m.read("http://www.deri.ie/fileadmin/scripts/foaf.php?id=316");
		RDF2Bean reader = new RDF2Bean(m);
		reader.bindAll("example.foaf");
		m.write(System.out, "N3");
		Collection<Person> people = reader.loadDeep(Person.class);
		for (Person person : people) {
			System.out.println(person.name);
		}
	}

}
