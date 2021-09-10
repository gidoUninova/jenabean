package test.bean;

import org.junit.Test;

import thewebsemantic.binding.Jenabean;

import org.apache.jena.ontology.OntClass;

public class TestBinding {
	
	@Test
	public void testBinding() {
		Jenabean b = Jenabean.instance();
		OntClass oc = Vocabulary.Vevent;
		b.bind(oc).to(String.class);
	}
}
