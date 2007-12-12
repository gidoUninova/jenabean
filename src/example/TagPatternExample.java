package example;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TagPatternExample {
	public static void main(String[] args) {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MINI_RULE_INF);	
		Bean2RDF writer = new Bean2RDF(m);
		
		// two tags
		Tag jb = new Tag();
		jb.setTerm("jenabean");		
		Tag red = new Tag();
		red.setTerm("red");
		
		Post p = new Post();
		p.setTitle("a new way to bind to rdf");
		
		Image i = new Image();
		i.setName("house.jpg");
		
		//add a tag to image i
		i.addTag(jb);
		
		//add a post to tag jb
		jb.addElement(p);
		
		p.addTag(red);
		red.addElement(i);
		

		// jb will persist all objects because...
		// jb has element p, which has tag red, which has element i
		writer.saveDeep(jb);
		m.write(System.out, "N3");
		
		// now image and post both have two tags
		// jb and red both have two elements
		// here we'll see the two elements tagged with red, one via inverse inference
		RDF2Bean reader = new RDF2Bean(m);
		Tag red2 = reader.loadDeep(Tag.class, red.getTerm());

		for (Taggable element : red2.getElements()) {
			System.out.println(element.getTags().size());
			if ( element instanceof Post) {
				p = (Post)element;
				System.out.println("Post '" + p.getTitle() + "' was tagged with " + red2.getTerm());
			} else if ( element instanceof Image) {
				i = (Image)element;
				System.out.println("Image '" + i.getName() + " was tagged with " + red2.getTerm());
			}

		}

	}
}
