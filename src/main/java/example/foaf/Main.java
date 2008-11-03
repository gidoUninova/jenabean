package example.foaf;

import static thewebsemantic.binding.Jenabean.include;

import java.io.IOException;
import java.util.Collection;

import thewebsemantic.Resource;
import thewebsemantic.binding.Jenabean;

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
		Jenabean J = Jenabean.instance();
		J.bind(m);
		J.bindAll("example.foaf");
		m.write(System.out, "N3");
		Collection<Person> people =   include("seealso").load(Person.class);
		for (Person person : people) {
			System.out.println(person.name);
			if ( "Dan Connolly".equals(person.name)) {
				System.out.println(person.seealso.getClass());
			}
			for (Resource uri : person.seealso) {
				System.out.println("\t" + uri);
			}
		}
	}
	
}
