package test.thing;


import java.util.Set;

import org.junit.Test;


import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import example.Man;

import thewebsemantic.Namespace;
import thewebsemantic.ResolverUtil;
import thewebsemantic.Thing;
import thewebsemantic.binding.Jenabean;


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
		//System.out.println(dcThing.getSubject());
		//m.write(out, "N3");
	}
	
	@Test
	public void annotated() {
		ResolverUtil<Object> resolver = new ResolverUtil<Object>();
		resolver.findAnnotated(Namespace.class, "example");
		Set<Class<? extends Object>> classes = resolver.getClasses();
		for (Class<? extends Object> class1 : classes) {
			//System.out.println(class1.getName());
		}
	}
	
	@Test
	public void binding() {
		Jenabean J = Jenabean.instance();
		J.bind(ModelFactory.createOntologyModel());
		J.bindAll("example");
		System.out.println(J.getUri(Man.class));
		
	}
	
}
