package test.thing;


import org.junit.Test;


import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import thewebsemantic.Thing;


public class TestBasic {
	@Test
	public void basic() {
		Model m = ModelFactory.createDefaultModel();

		m.setNsPrefix("dc", "http://purl.org/dc/elements/1.1/");
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		Thing t = new Thing("http://foo/",m);
		
		DublinCore dcThing = t.as(DublinCore.class);
		dcThing.creator("me")
			.subject("binding");
		
		dcThing.subject("owl");
	
		

		//m.write(out, "N3");
	}
}
