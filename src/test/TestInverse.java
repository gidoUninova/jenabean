package test;

import java.io.FileWriter;
import java.io.IOException;
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
	public void testBasic() throws IOException {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MINI_RULE_INF);	
		Bean2RDF writer = new Bean2RDF(m);
		Apple a = new Apple();
		Apple aprime = new Apple();
		
		a.addOrange(new Orange());
		a.addOrange(new Orange());
		
		Orange o = new Orange();
		int rememberedId = o.hashCode();
		a.addOrange(o);
		aprime.addOrange(o);
		
		writer.write(a);
		RDF2Bean reader = new RDF2Bean(m);
		Collection<Orange> oranges = reader.loadAll(Orange.class);
		for (Orange orange : oranges)
			assertEquals(1, orange.getApples().size());

		writer.write(aprime);
		m.write(new FileWriter("tmp.rdf"));
		m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MINI_RULE_INF);
		reader = new RDF2Bean(m);
		m.read("file:tmp.rdf");
		o = reader.find(Orange.class, rememberedId);
		assertEquals(2, o.getApples().size());
		
		//without reasoner, it's back to none
		m = ModelFactory.createOntologyModel();
		reader = new RDF2Bean(m);
		m.read("file:tmp.rdf");
		o = reader.find(Orange.class, rememberedId);
		assertEquals(0, o.getApples().size());
		
	}
}
