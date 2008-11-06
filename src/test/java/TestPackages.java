

import org.junit.Test;

import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestPackages {
	@Test
	public void basic() {
		Model m = ModelFactory.createDefaultModel();
		Jenabean.instance().bind(m);
		Jenabean.instance().writer().save(new Foo());
	}
}
