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
			setcreator("me").
			addsubject("binding").
			addsubject("owl").
			addsubject(me).
			settitle("The web semantic").
		 as(FoafThing.class).
			addmade(new Thing("http://thewebsemantic.com",m)).
		    addmade(new Thing("http://tripblox.com,",m)).
		    addmbox(new Thing("mailto:gorby.kremvax@example.com",m))
			;
		m.write(System.out, "N3");
		System.out.println(dcThing.getsubject().size());
		for (String subject : dcThing.getsubject()) {
			System.out.println(subject);
		}
		
		for (Thing thing : t.as(FoafThing.class).getmade())
			System.out.println(thing.getResource());
		
		t.as(DublinCore.class).setdescription("this is a description");
		System.out.println(t.as(DublinCore.class).getdescription());
		
	}
	
	@Test
	public void check() {
		Model m = ModelFactory.createDefaultModel();
		Thing me = new Thing("http://tcowan.myopenid.com", m);
		Date d = new Date();
		me.as(DublinCore.class).setdate(d);
		Date e = me.as(DublinCore.class).getdate();
		assertEquals(d,e);
		
		me.as(Various.class).setage(40).setmiles(4000).addfloat(1.1f).addfloat(2.2f).setdouble(1.123d).setchar('c');
		assertEquals(me.as(Various.class).getage(), 40);
		assertEquals(me.as(Various.class).getmiles(), 4000);
		assertEquals(me.as(Various.class).getfloat().size(), 2);
		assertEquals(me.as(Various.class).getdouble(), 1.123d, 0);
		assertEquals(me.as(Various.class).getchar(), 'c');
	}

	
}
