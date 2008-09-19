package test.bean;

import org.junit.Test;

import com.hp.hpl.jena.ontology.OntClass;

import thewebsemantic.binding.Jenabean;
import static org.junit.Assert.*;

public class TestBinding {
	
	@Test
	public void testBinding() {
		Jenabean b = Jenabean.instance();
		OntClass oc = Vocabulary.Vevent;
		b.bind(oc).to(String.class);
		
		String uri = b.getUri(String.class);
		assertEquals(oc.getURI(), uri);
	}
}
