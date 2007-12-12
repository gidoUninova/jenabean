package test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import thewebsemantic.binding.Binder;
import static thewebsemantic.RdfBean.*;


public class TestRdfBean {
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		OntModel m = ModelFactory.createOntologyModel();
		Binder.instance().bind(m);
	}
	
	@Test
	public void testBasic() throws Exception {
		Article a = new Article("a1");
		a.save();		
		Article b = load(Article.class, "a1");
		b.fill().with("authors");

	}
}
