package test.thing;


import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import thewebsemantic.Thing;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;


public class TestBasic {
	@Test
	public void basic() {
		Model m = ModelFactory.createDefaultModel();

		m.setNsPrefix("dc", "http://purl.org/dc/elements/1.1/");
		m.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		
		Thing t = new Thing("http://example.com/1",m);
		
		DublinCore dcThing = t.as(DublinCore.class);
		Thing me = new Thing("http://tcowan.myopenid.com", m);
		m.write(System.out, "N3");
		t.as(DublinCore.class).
			setCreator("me").
			addSubject("binding").
			addSubject("owl").
			addSubject(me).
			setTitle("The web semantic").
		 as(FoafThing.class).
			addMade(new Thing("http://thewebsemantic.com",m)).
		    addMade(new Thing("http://tripblox.com,",m)).
		    addMbox(new Thing("mailto:gorby.kremvax@example.com",m))
			;
		m.write(System.out, "N3");
		System.out.println(dcThing.getSubject().size());
		for (String subject : dcThing.getSubject()) {
			System.out.println(subject);
		}
		
		for (Thing thing : t.as(FoafThing.class).getMade())
			System.out.println(thing.getResource());
		
		t.as(DublinCore.class).setDescription("this is a description");
		System.out.println(t.as(DublinCore.class).getDescription());
		
	}
	
	@Test
	public void check() {
		Model m = ModelFactory.createDefaultModel();
		Thing me = new Thing("http://tcowan.myopenid.com", m);
		Date d = new Date();
		me.as(DublinCore.class).setDate(d);
		Date e = me.as(DublinCore.class).getDate();
		assertEquals(d,e);
		
		me.as(Various.class).setAge(40).setMiles(4000).addFloat(1.1f).addFloat(2.2f).setDouble(1.123d).setChar('c');
		assertEquals(me.as(Various.class).getAge(), 40);
		assertEquals(me.as(Various.class).getMiles(), 4000);
		assertEquals(me.as(Various.class).getFloat().size(), 2);
		assertEquals(me.as(Various.class).getDouble(), 1.123d, 0);
		assertEquals(me.as(Various.class).getChar(), 'c');
	}

	
}
