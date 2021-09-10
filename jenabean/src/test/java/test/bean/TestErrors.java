package test.bean;

import org.junit.Test;

import thewebsemantic.Bean2RDF;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

public class TestErrors {
	
	@Test
	public void testBasic() {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MINI_RULE_INF);	
		Bean2RDF writer = new Bean2RDF(m);
		writer.save("hello");
	}
}
