package test.resource;

import java.util.Collection;

import org.junit.Test;
import static org.junit.Assert.*;

import com.hp.hpl.jena.rdf.model.ModelFactory;

import thewebsemantic.Resource;
import thewebsemantic.binding.Jenabean;

public class TestResource {

	@Test
	public void basic() {
		Jenabean J = Jenabean.instance();
		J.bind(ModelFactory.createDefaultModel());
		Bug ant = new Bug();
		ant.setSimilarTo(new Resource("http://termite"));
		ant.save();
		J.model().write(System.out, "N3");

		Collection<Bug> bugs = J.reader().load(Bug.class);
		for (Bug bug : bugs) {
			assertEquals("http://termite", bug.getSimilarTo().toString());
		}
		
	}
}
