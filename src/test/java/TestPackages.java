

import org.junit.Test;

import thewebsemantic.TypeWrapper;
import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import static org.junit.Assert.*;

public class TestPackages {
	@Test
	public void basic() {
		Model m = ModelFactory.createDefaultModel();
		Jenabean.instance().bind(m);
		Jenabean.instance().writer().save(new Foo());
	}
	
	@Test
	public void check() {
		String s  = TypeWrapper.wrap(Foo.class).namespace();
		assertEquals("http://default.package/", s);
		
		s  = TypeWrapper.wrap(String.class).namespace();
		assertEquals("http://java.lang/", s);
	}
}
