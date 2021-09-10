package test.bean;

import org.junit.Test;

import thewebsemantic.Bean2RDF;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

public class TestCycle {
	
	@Test
	public void testBasic() {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RDFS_INF);	
		Bean2RDF writer = new Bean2RDF(m);
		
		Yin yin = new Yin();
		Yang yang = new Yang();
		
		yin.setYang(yang);
		yang.setYin(yin);
		writer.save(yin);
		
		
	}
}
