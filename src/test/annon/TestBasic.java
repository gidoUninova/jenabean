package test.annon;

import org.junit.Test;

import thewebsemantic.NotFoundException;
import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestBasic {

	@Test
	public void drive() throws NotFoundException {
		OntModel m = ModelFactory.createOntologyModel();
		m.read( getClass().getResourceAsStream("example.n3"),null, "N3");
		
		// bind Thing.class to a pre-existing RDF type ../thing
		Jenabean j = Jenabean.instance();
		j.bind(m);
		j.bind("http://thewebsemantic.com/thing").to(Thing.class);
		
		// try and find a Thing with specific url
		Thing me = j.include("knows").load(Thing.class, "http://thewebsemantic.com/me");
		
		// the thing's name from RDF
		System.out.println(me.name);
		
		// the annonymous known thing's name too
		System.out.println("me :knows " + me.getKnows().size() + " things");
		for (Thing t : me.getKnows()) {
			System.out.println(t.name);
		}
		

	}
}
