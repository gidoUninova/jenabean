package test.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import thewebsemantic.jpa.JBFactory;
import static junit.framework.Assert.*;


public class TestTransactions {
	
	@Test
	public void basic() {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("tws:filemodel");
		EntityManager em = factory.createEntityManager();
		EntityTransaction ta = em.getTransaction();
		ta.begin();
		Man m = new Man("http://example.org/joe");
		m.setName("Joseph");
		m.setDescription("had a nice coat.");
		em.persist(m);
		ta.commit();
		
		Man m2 = em.find(Man.class, "http://example.org/joe");
		assertEquals("Joseph", m2.getName());
		JBFactory jbfactory = (JBFactory)factory;
		jbfactory.getModel().write(System.out, "N3");
		
	}

	@Test
	public void rollback() {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("tws:filemodel");
		EntityManager em = factory.createEntityManager();
		EntityTransaction ta = em.getTransaction();
		ta.begin();
		Man m = new Man("http://example.org/mark");
		m.setName("Mark");
		m.setDescription("A disciple of Jesus.");
		em.persist(m);
		ta.rollback();
		
		Man m2 = em.find(Man.class, "http://example.org/mark");
		assertNull(m2);
		
		boolean caught = false;
		try {
			m2 = em.getReference(Man.class, "http://example.org/mark");
		} catch (EntityNotFoundException e) {
			caught = true;
		}
		assertTrue(caught);
		
	}
}
