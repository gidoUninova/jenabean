package test;

import org.junit.Test;
import static org.junit.Assert.*;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestIdStuff {
	@Test
	public void testId() {
		String id = "myuniqueid";
		TestIDBean bean = new TestIDBean(id);
		bean.setAddress("123 Oak Circle");
		bean.setAge(32);
		OntModel m = ModelFactory.createOntologyModel();	
		Bean2RDF writer = new Bean2RDF(m);
		writer.write(bean);
		
		RDF2Bean reader = new RDF2Bean(m);
		TestIDBean bean2 = reader.find(TestIDBean.class, id);
		assertEquals("123 Oak Circle", bean2.getAddress());
		assertEquals(32, bean2.getAge());
	}
}
