package test.bean;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import static org.junit.Assert.*;

import thewebsemantic.Bean2RDF;
import thewebsemantic.NotFoundException;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;


public class TestURI {
	@Test
	public void testSimple() throws URISyntaxException, NotFoundException {
		Model m = ModelFactory.createDefaultModel();	
		Bean2RDF writer = new Bean2RDF(m);
		URITestBean bean = new URITestBean();
		bean.setUri( new URI("http://foo.com"));
		bean.setSecondaryURI(new URI("http://second.example"));
		bean.setName("test bean");
		bean.setId("1");
		writer.save(bean);
		m.write(System.out,"N3");

		
		RDF2Bean reader = new RDF2Bean(m);
		bean = reader.load(URITestBean.class, "1");
		URI foo = new URI("http://foo.com");
		URI second = new URI("http://second.example");
		assertEquals(foo, bean.getUri());
		assertEquals(second, bean.getSecondaryURI());
	}
}
