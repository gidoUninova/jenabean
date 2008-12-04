package example.thing;


import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import test.thing.RdfsVocab;
import thewebsemantic.Thing;
import thewebsemantic.vocabulary.Foaf;
import thewebsemantic.vocabulary.Skos;

/**
 * very simple example taken from http://www.w3.org/TR/2008/WD-skos-primer-20080221/
 * shows using 3 vocabularies on one "Thing", one line of code formatted for readability.
 * 
 *  creates these triples...
 * <http://www.w3.org/People/Berners-Lee/card#i> rdf:type foaf:Person;
  	foaf:name "Timothy Berners-Lee";
  	rdfs:label "Tim Berners-Lee";
  	skos:prefLabel "Tim Berners-Lee"@en.
 */
public class MixedExample {

	/**
	 * A "Thing" can easily polymorph to different vocabs.
	 * @param args
	 */
	public static void main(String[] args) {
		Model m = ModelFactory.createDefaultModel();
		m.setNsPrefix("dc", "http://purl.org/dc/elements/1.1/");
		m.setNsPrefix("skos", "http://www.w3.org/2008/05/skos#");
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		m.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
		m.setNsPrefix("rdfs","http://www.w3.org/2000/01/rdf-schema#");
		new Thing("http://www.w3.org/People/Berners-Lee/card#i", m)
		   .as(Foaf.class).isa(Foaf.Person.class).
				name("Timothy Berners-Lee").
			as(Skos.class).
				prefLabel("Tim Berners-Lee", "en").
			as(RdfsVocab.class).
				label("Tim Berners-Lee");
		m.write(System.out, "N3");
	}

}
