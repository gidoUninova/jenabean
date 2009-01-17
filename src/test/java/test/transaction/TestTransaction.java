package test.transaction;

import org.junit.Test;

import test.jpa.Man;
import thewebsemantic.Bean2RDF;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ModelMaker;

public class TestTransaction {

	@Test
	public void basic() {
		ModelMaker maker = ModelFactory.createFileModelMaker(".");
		Model m = maker.createDefaultModel();
		Bean2RDF writer = new Bean2RDF(m);
		m.begin();
		Man man = new Man("http://example.org/him");
		man.setName("Joel Cavazos");
		writer.save(man);
		m.abort();
	}
}
