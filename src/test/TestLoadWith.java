package test;

import org.junit.Test;
import static org.junit.Assert.*;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestLoadWith {
   
   @Test
   public void testBasic() {
      OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MINI_RULE_INF);  
      Bean2RDF writer = new Bean2RDF(m);
      
      Tag fun = new Tag("fun");
      Tag run = new Tag("run");
      Post p1 = new Post();
      p1.setTitle("i like OWL");
      p1.addTag(fun);
      p1.addTag(run);
      writer.write(p1); 
  
      RDF2Bean reader = new RDF2Bean(m);
      
      Post shallow = reader.load(Post.class, p1.hashCode());     
      assertEquals(0, shallow.getTags().size());
      reader.load(shallow, "tags");
      assertEquals(2, shallow.getTags().size());
      
      shallow = reader.load(Post.class, p1.hashCode());     
      assertEquals(0, shallow.getTags().size());
      reader.load(shallow).with("tags");
      assertEquals(2, shallow.getTags().size());

   }
}
