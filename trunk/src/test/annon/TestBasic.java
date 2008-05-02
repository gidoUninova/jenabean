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
		m.read( getClass().getResourceAsStream("example.rdf"),null, "N3");
		
		Jenabean j = Jenabean.instance();
		j.bind(m);
		j.bind("http://thewebsemantic.com/thing").to(Thing.class);
		
		Thing me = j.load(Thing.class, "http://thewebsemantic.com/me");
		System.out.println(me.name);
		System.out.println(me.getKnows().name);

	}
}
