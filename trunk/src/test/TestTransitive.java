package test;

import java.util.Date;

import org.junit.Test;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import example.Person;

public class TestTransitive {
	
	@Test
	public void testBasic() {

		Person a = new Person();
		a.setAge(18);
		a.setBirthday(new Date());
		a.setFirstName("a_ancestor");
		a.setLastName("Bean");

		Person b = new Person();
		b.setAge(18);
		b.setBirthday(new Date());
		b.setFirstName("b_ancestor");
		b.setLastName("Bean");
		b.addAncestor(a);
		
		
		Person p = new Person();
		p.setAge(18);
		p.setBirthday(new Date());
		p.setFirstName("Jena");
		p.setLastName("Bean");
		p.addAncestor(b);
		
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MINI_RULE_INF);	
		Bean2RDF writer = new Bean2RDF(m);
		writer.write(p);
		
		RDF2Bean reader = new RDF2Bean(m);
		Person q = reader.find(Person.class, p.uri());
		System.out.println(q.getFirstName());
		for (Person person : q.getAncestors()) {
			System.out.println(person.uri());
		}

	}
}
