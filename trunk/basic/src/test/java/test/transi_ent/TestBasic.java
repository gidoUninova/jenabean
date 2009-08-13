package test.transi_ent;

import java.net.URI;

import org.junit.Test;

import thewebsemantic.Bean2RDF;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestBasic {

	@Test
	public void basic() {
		
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF);
		Company c = new Company();
		c.setName("asdf");
		c.setDontsaveme("hi");
		c.setIdentifier(URI.create("http://foo"));
		Bean2RDF writer = new Bean2RDF(m);
		writer.save(c);
		m.write(System.out, "N3");
	}
}
