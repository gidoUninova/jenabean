package example.fluentwriter;

import static java.lang.System.out;

import java.net.URI;

import thewebsemantic.Thing;
import thewebsemantic.vocabulary.Foaf;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
public class Card {

	public static void main(String[] args) {
		Model m = ModelFactory.createDefaultModel();
		Thing todaysTopic = new Thing("http://jenabean.googlecode.com", m);
	   m.setNsPrefix("foaf","http://xmlns.com/foaf/0.1/");

		new Thing(m).isa(Foaf.Person.class)
		  .name("Taylor Cowan")
		  .weblog(URI.create("http://thewebsemantic.com"))
		  .holdsAccount(URI.create("http://twitter.com/tcowan"))
		  .currentProject(todaysTopic)
		  .currentProject(URI.create("http://jo4neo.googlecode.com"));
		
		m.write(out, "N3");
		
	}
}
