package test.fieldaccess;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
		GrandsonOfFatAlbert fa = new GrandsonOfFatAlbert();
		fa.grandsonname("grandson");
		fa.name("fieldaccess"); // this comes from the super super class
		fa.dontsaveme = "I don't get saved"; // this one is transient
		writer.save(fa);
		m.write(System.out,"N3");
		
		RDF2Bean reader = new RDF2Bean(m);
		Collection<GrandsonOfFatAlbert> results 
			= reader.load(GrandsonOfFatAlbert.class);
		GrandsonOfFatAlbert bean = results.iterator().next();
		assertEquals("fieldaccess", bean.name());
		assertEquals( "son", bean.sonname());
		assertEquals("grandson", bean.grandsonname());
		assertNull(bean.dontsaveme);
	}
}
