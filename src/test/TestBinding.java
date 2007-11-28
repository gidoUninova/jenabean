package test;

import org.junit.Test;

import com.hp.hpl.jena.ontology.OntClass;

import thewebsemantic.binding.Binder;
import static org.junit.Assert.*;

public class TestBinding {
	
	@Test
	public void testBinding() {
		Binder b = new Binder();
		OntClass oc = Vocabulary.Vevent;
		b.bind(oc).to(String.class);
		
		String uri = b.getUri(String.class);
		assertEquals(oc.getURI(), uri);
	}
}
