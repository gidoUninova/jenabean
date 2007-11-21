package test;

import java.util.Collection;

import org.junit.Test;
import static org.junit.Assert.*;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestInverse {
	
	@Test
	public void testBasic() {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MINI_RULE_INF);	
		Bean2RDF writer = new Bean2RDF(m);
		Apple a = new Apple();
		a.addOrange(new Orange());
		a.addOrange(new Orange());
		
		writer.write(a);
		
		RDF2Bean reader = new RDF2Bean(m);
		Collection<Orange> oranges = reader.loadAll(Orange.class);
		for (Orange orange : oranges) {
			assertEquals(1, orange.getApples().size());
		
		}
		
		
		
	}
}
