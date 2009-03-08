package example.thing;

import java.net.URI;

import thewebsemantic.Thing;
import thewebsemantic.vocabulary.Rdfs;
import thewebsemantic.vocabulary.Sioc;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class SiocWriteExample {
	private static final String literal1 = "SIOC provides a unified vocabulary for content and interaction description: a semantic layer that can co-exist with existing discussion platforms.";
	private static final String uri8 = "http://johnbreslin.com/blog/index.php?sioc_type=comment&amp;sioc_id=123928";
	private static final String uri7 = "http://johnbreslin.com/blog/2006/09/07/creating-connections-between-discussion-clouds-with-sioc/#comment-123928";
	private static final String uri6 = "http://johnbreslin.com/blog/category/blogs/";
	private static final String uri4 = "http://johnbreslin.com/blog/index.php?sioc_type=user&amp;sioc_id=1";
	private static final String uri3 = "http://johnbreslin.com/blog/author/cloud/";
	private static final String uri2 = "http://johnbreslin.com/blog/index.php?sioc_type=site#weblog";
	private static final String uri1 = "http://johnbreslin.com/blog/2006/09/07/creating-connections-between-discussion-clouds-with-sioc/";

	public static void main(String[] args) {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
		m.setNsPrefix("sioc", "http://rdfs.org/sioc/ns#");
				
		Thing t = new Thing(m);
		new Thing(uri1, m).
			isa(Sioc.Post.class).
			has_container(t.$(uri2)).
			has_creator(
			  t.$(uri3).isa(Sioc.User.class).
			  seeAlso(URI.create(uri4))).
			content(literal1).
			topic(
			  t.$(uri6).as(Rdfs.class).label("blogs")).
			has_reply(
			  t.$(uri7).
			  isa(Sioc.Post.class).
			  seeAlso(URI.create(uri8)));
		
		m.write(System.out, "RDF/XML-ABBREV");
	}
}
