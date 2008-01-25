package test.thing;


import org.junit.Test;


import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import thewebsemantic.Thing;
import static java.lang.System.out;


public class TestBasic {
	@Test
	public void basic() {
		Model m = ModelFactory.createDefaultModel();

		m.setNsPrefix("dc", "http://purl.org/dc/elements/1.1/");
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		Thing t = new Thing("http://foo/",m);
		
		DublinCore dcThing = t.as(DublinCore.class);
		dcThing.setCreator("me")
			.setSubject("binding");
		
		dcThing.setSubject("owl");
		System.out.println(dcThing.getSubject());

		m.write(out, "N3");
	}
}
