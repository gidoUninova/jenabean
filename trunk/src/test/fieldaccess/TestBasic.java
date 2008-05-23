package test.fieldaccess;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestBasic {
	@Before
	public void setup() {
		System.setProperty("jenabean.fieldaccess", "true");
	}
	
	@Test
	public void simple() {
		Model m = ModelFactory.createDefaultModel();
		Bean2RDF writer = new Bean2RDF(m);
		writer.save(new GrandsonOfFatAlbert());
		m.write(System.out,"N3");
		
		RDF2Bean reader = new RDF2Bean(m);
		Collection<GrandsonOfFatAlbert> results 
			= reader.load(GrandsonOfFatAlbert.class);
		System.out.println( results );
	}
}
