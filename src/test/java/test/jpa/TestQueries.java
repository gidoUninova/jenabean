package test.jpa;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import thewebsemantic.jpa.JBEntityManager;
import thewebsemantic.jpa.JBQueryWrapper;

import com.hp.hpl.jena.sparql.util.StringUtils;

public class TestQueries {
	@Test
	public void basic() throws IOException {   
		
		
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("tws:blank");
		EntityManager em = factory.createEntityManager();
		JBEntityManager jem = (JBEntityManager)em;
		String query = 
		StringUtils.join("\n", new String[] {
				"PREFIX : <http://example.org/>",
				"SELECT ?s WHERE {",
				" ?s <http://semanticbible.org/ns/2006/NTNames#knew> ?uri",
				"}"
		});
		
		Woman mary = new Woman("http://example.org/mary");
		mary.setName("Mary");
		Woman eve = new Woman("http://example.org/eve");
		mary.setName("Eve");

		Man peter = new Man("http://example.org/peter");
		peter.setName("Peter");
		peter.setKnew(mary);
		Man paul = new Man("http://example.org/paul");
		paul.setName("Paul");
		paul.setKnew(mary);
		Man adam = new Man("http://example.org/adam");
		adam.setName("adam");
		adam.setKnew(eve);
		
		em.persist(mary);
		em.persist(peter);
		em.persist(paul);
		em.persist(adam);
		em.persist(eve);
		
		jem.getModel().write(System.out, "N3");
		
		JBQueryWrapper q = new JBQueryWrapper(query, jem, Human.class);		
		List<Human> people = q.getResultList();
		assertEquals(3, people.size());
		
		//bind to just people who knew Mary
		q.setParameter("uri", mary);
		people = q.getResultList();
		assertEquals(2, people.size());
		for (Human human : people) {
			System.out.println(human.getName());
		}
	}
}
