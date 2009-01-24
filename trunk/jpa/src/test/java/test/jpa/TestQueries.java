package test.jpa;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import thewebsemantic.jpa.JBEntityManager;
import thewebsemantic.jpa.JBQueryWrapper;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.sparql.util.StringUtils;

public class TestQueries {

	@Test
	public void testUpdateQuery() {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("tws:blank");
		EntityManager em = factory.createEntityManager();
		Model m = (Model)em.getDelegate();
		String squery = StringUtils.join("\n", new String[] {
			"DELETE { ?s ?p ?o } WHERE { ?s a ?type . ?s ?p ?o }"
		});
		
		String insert = StringUtils.join("\n", new String[] {
				"INSERT { ",
				"?id <http://semanticbible.org/ns/2006/NTNames#name_en> ?value}",
				"WHERE { FILTER(bound(?value) && bound(?id)) }"
		});

		Man peter = new Man(URI.create("http://example.org/peter"));
		Man paul = new Man(URI.create("http://example.org/paul"));
		paul.setName("Paul");
		em.persist(peter);
		em.persist(paul);
		
		Query query = em.createNativeQuery(squery);
		query.setParameter("type", Man.class);
		query.executeUpdate();

		Query qry = em.createNativeQuery("select ?s where { ?s a ?type }");
		qry.setParameter("type", Man.class);
		List<Man> results = qry.getResultList();
		assertEquals(0, results.size());
		
		em.persist(peter);
		em.persist(paul);	
		// add peter's name with an insert query
		Query last = em.createNativeQuery(insert);
		last.setParameter("value", "Peter");
		last.setParameter("id", peter);
		last.executeUpdate();

		results = qry.getResultList();
		assertEquals(2, results.size());
		peter = em.find(Man.class, "http://example.org/peter");
		assertEquals("Peter", peter.getName());
	}
	
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
		
		Woman mary = new Woman(URI.create("http://example.org/mary"));
		mary.setName("Mary");
		Woman eve = new Woman(URI.create("http://example.org/eve"));
		mary.setName("Eve");

		Man peter = new Man(URI.create("http://example.org/peter"));
		peter.setName("Peter");
		peter.setKnew(mary);
		Man paul = new Man(URI.create("http://example.org/paul"));
		paul.setName("Paul");
		paul.setKnew(mary);
		Man adam = new Man(URI.create("http://example.org/adam"));
		adam.setName("adam");
		adam.setKnew(eve);
		
		em.persist(mary);
		em.persist(peter);
		em.persist(paul);
		em.persist(adam);
		em.persist(eve);
		
		//jem.getModel().write(System.out, "N3");
		
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
	
	@Test
	public void david() {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("tws:blank");
		EntityManager em = factory.createEntityManager();
		
		Person p = new Person();
		p.setId(0);
		p.setFirstName("taylor");
		em.persist(p);
		
		
		Model m = (Model)em.getDelegate();
		m.write(System.out, "N3");

	}
	
	
}
