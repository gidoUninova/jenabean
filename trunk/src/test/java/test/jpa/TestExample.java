package test.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import test.jpa.model.SamplePopulation;

import com.hp.hpl.jena.rdf.model.Model;

public class TestExample {

	@BeforeClass
	public static void init() {

	}
	


	@Test
	public void basic() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("tws:filemodel");

		EntityManager em = emf.createEntityManager();
		Model m = (Model) em.getDelegate();
		m.removeAll();
		
		em.getTransaction().begin();
		new SamplePopulation().persistAll(em);
		em.getTransaction().commit();
		em.close();
		m.removeAll();
		
	}
}
