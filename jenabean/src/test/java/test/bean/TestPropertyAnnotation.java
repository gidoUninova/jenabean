package test.bean;

import org.junit.BeforeClass;
import org.junit.Test;

import thewebsemantic.binding.Jenabean;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;


public class TestPropertyAnnotation {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		OntModel m = ModelFactory.createOntologyModel();
		Jenabean.instance().bind(m);
	}
	
	@Test
	public void testBasic() {
		KeepItSimple bean = new KeepItSimple();
		bean.setId("foo");

		for (int i=0; i<1000; i++)
			Jenabean.instance().writer().save(bean);
		
		//Jenabean.instance().model().write(System.out);
	}
}
