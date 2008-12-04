package example.thing;

import test.thing.RdfsVocab;
import thewebsemantic.Thing;
import thewebsemantic.vocabulary.Foaf;
import thewebsemantic.vocabulary.Geo;
import thewebsemantic.vocabulary.Skos;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class FoafExample {
	
	public static void main(String[] args) {
	Model m = ModelFactory.createDefaultModel();

	m.setNsPrefix("dc", "http://purl.org/dc/elements/1.1/");
	m.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
	m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
	m.setNsPrefix("geo", "http://www.w3.org/2003/01/geo/wgs84_pos#");
	
	Thing t = new Thing("http://example.com/1",m);
	t.as(Foaf.class).
	    aimChatID("example").
		birthday("01/01/1999").
		weblog(new Thing("http://thewebsemantic.com", m)).
		knows(new Thing("http://bblfish.net/people/henry/card#me", m)).
	as(Geo.class).
		lat(33.3f).
		long_(120.1f).
	    isa(Skos.Concept.class).
	as(RdfsVocab.class).
	 	label("an example of polymorphic Thing with 3 vocabularies");
		m.write(System.out, "N3");
	}
}
