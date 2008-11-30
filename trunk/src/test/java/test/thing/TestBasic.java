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
		m.write(System.out, "N3");
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
			long_(120.1f).
		    isa(SkosThing.Concept.class);
		m.write(System.out, "N3");
		
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
		m.write(System.out, "N3");
		
		assertEquals(me.as(Various.class).age(), 40);
		assertEquals(me.as(Various.class).miles(), 4000);
		assertEquals(me.as(Various.class).Float().size(), 2);
		float f = me.as(Various.class).Float().iterator().next();
		assertEquals(f, 2.2, 0.001);
		assertEquals(me.as(Various.class).Double(), 1.123d, 0);
		assertEquals(me.as(Various.class).Char(), 'c');
	}
	
	@Test
	public void skos27() {
		Model m = ModelFactory.createDefaultModel();

		m.setNsPrefix("dc", "http://purl.org/dc/elements/1.1/");
		m.setNsPrefix("skos", "http://www.w3.org/2008/05/skos#");
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		m.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
		m.setNsPrefix("rdfs","http://www.w3.org/2000/01/rdf-schema#");
		Thing t = new Thing("Protein",m);
		t.as(SkosThing.class).
			definition("A physical entity consisting of a sequence of amino-acids; a protein monomer; a single polypeptide chain. An example is the EGFR protein.", "en");
		
		
		//28, <A> skos:broader <B> ; skos:related <C> .
		Thing a = new Thing("A", m);
		Thing b = new Thing("B", m);
		Thing c = new Thing("C", m);
		a.as(SkosThing.class).broader(b).related(c);
		
		Thing rocks = new Thing("rocks", m);
		rocks.isa(SkosThing.Concept.class).
			prefLabel("rocks", "en").
			altLabel("basalt", "en").
			altLabel("granite", "en").
			altLabel("slate", "en");
		
		//<http://www.w3.org/People/Berners-Lee/card#i> rdf:type foaf:Person;
		//	  foaf:name "Timothy Berners-Lee";
		//	  rdfs:label "Tim Berners-Lee";
		//	  skos:prefLabel "Tim Berners-Lee"@en.

		Thing tbl = new Thing("http://www.w3.org/People/Berners-Lee/card#i", m);
		tbl.as(FoafThing.class).isa(FoafThing.Person.class).
				name("Timothy Berners-Lee").
			as(SkosThing.class).
				prefLabel("Tim Berners-Lee", "en").
			as(RdfsVocab.class).
				label("Tim Berners-Lee");
		m.write(System.out, "N3");
	}
	
	@Test
	public void skosPrimer() {
		/*
ex2:catScheme rdf:type skos:ConceptScheme;
   dc:title "The Complete Cat Thesaurus"@en. 

ex1:cats skos:inScheme ex2:catScheme.

ex2:abyssinian rdf:type skos:Concept;
   skos:prefLabel "Abyssinian Cats"@en;
   skos:broader ex1:cats;
   skos:inScheme ex2:catScheme.

ex2:siamese rdf:type skos:Concept;
   skos:prefLabel "Siamese Cats"@en;
   skos:broader ex1:cats;
   skos:inScheme ex2:catScheme.
		 */
		 
		Model m = ModelFactory.createDefaultModel();

		m.setNsPrefix("dc", "http://purl.org/dc/elements/1.1/");
		m.setNsPrefix("skos", "http://www.w3.org/2008/05/skos#");
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		m.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
		m.setNsPrefix("rdfs","http://www.w3.org/2000/01/rdf-schema#");	
		m.setNsPrefix("ex1","http://ex1#");
		m.setNsPrefix("ex2","http://ex2#");
		Thing ex2 = new Thing("http://ex2#catScheme", m);
		ex2.isa(SkosThing.ConceptScheme.class).
		as(DublinCore.class).title("The Complete Cat Thesaurus","en");
		Thing ex1 = new Thing("http://ex1#cats", m);
		ex1.as(SkosThing.class).inScheme(ex2);
		
		new Thing("http://ex2#abyssinian", m).
			as(SkosThing.class).isa(SkosThing.Concept.class).
			prefLabel("Abyssinian Cats", "en").
			broader(ex1).inScheme(ex2);
		
		new Thing("http://ex2#siamese", m).
			as(SkosThing.class).isa(SkosThing.Concept.class).
			prefLabel("Siamese Cats", "en").
			broader(ex1).inScheme(ex2);		
		m.write(System.out, "N3");
	}

	
}
