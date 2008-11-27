package test.thing;


import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.junit.Test;

import thewebsemantic.Thing;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;


public class TestBasic {
	@Test
	public void basic() throws URISyntaxException {
		Model m = ModelFactory.createDefaultModel();

		m.setNsPrefix("dc", "http://purl.org/dc/elements/1.1/");
		m.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		
		Thing t = new Thing("http://example.com/1",m);
		
		DublinCore dcThing = t.as(DublinCore.class);
		Thing me = new Thing("http://tcowan.myopenid.com", m);
		m.write(System.out, "N3");
		t.as(DublinCore.class).
			creator("me").
			subject("binding").
			subject("owl").
			subject(1).
			subject(new Date()).
			subject(me).
			subject(new URI("http://www.google.com")).
			title("The web semantic").
		 as(FoafThing.class).
			made(new Thing("http://thewebsemantic.com",m)).
		    made(new Thing("http://tripblox.com,",m)).
		    mbox(new Thing("mailto:gorby.kremvax@example.com",m))
			;
		m.write(System.out, "N3");
		System.out.println(dcThing.subject().size());
		for (Literal subject : dcThing.subject()) {
			System.out.println(":" + subject);
		}
		
		for (Thing subject : dcThing.subject_()) {
			System.out.println("thing: " + subject);
		}
		
		for (Thing thing : t.as(FoafThing.class).made())
			System.out.println(thing.getResource()); 
		
		t.as(DublinCore.class).description("this is a description");
		System.out.println(t.as(DublinCore.class).description());
		
	}

	@Test
	public void basic2() {
		Model m = ModelFactory.createDefaultModel();

		m.setNsPrefix("dc", "http://purl.org/dc/elements/1.1/");
		m.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		m.setNsPrefix("geo", "http://www.w3.org/2003/01/geo/wgs84_pos#");
		Thing t = new Thing("http://example.com/1",m);
		t.as(FoafThing.class).
		    aimChatID("example").
			birthday("01/01/1999").
			weblog(new Thing("http://thewebsemantic.com", m)).
			knows(new Thing("http://bblfish.net/people/henry/card#me", m)).
		as(Geo.class).
			lat(33.3f).
			long_(120.1f);
		
	}
	
	@Test
	public void check() {
		Model m = ModelFactory.createDefaultModel();
		Thing me = new Thing("http://tcowan.myopenid.com", m);
		Date d = new Date();
		me.as(DublinCore.class).date(d);
		Date e = me.as(DublinCore.class).date();
		assertEquals(d,e);
		
		me.as(Various.class).age(40).miles(4000).Float(1.1f).Float(2.2f).Double(1.123d).Char('c');
		assertEquals(me.as(Various.class).age(), 40);
		assertEquals(me.as(Various.class).miles(), 4000);
		assertEquals(me.as(Various.class).Float().size(), 2);
		assertEquals(me.as(Various.class).Double(), 1.123d, 0);
		assertEquals(me.as(Various.class).Char(), 'c');
	}

	
}
