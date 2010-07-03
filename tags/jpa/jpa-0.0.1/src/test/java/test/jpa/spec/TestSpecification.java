package test.jpa.spec;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSpecification {


	/**
	 * Once an EntityManagerFactory
	 * has been closed, all its entity managers are 
	 * considered to be in the closed state.
	 */
	@Test
	public void ch5_4() {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("tws:blank");
		EntityManager em1 = factory.createEntityManager();
		EntityManager em2 = factory.createEntityManager();
		factory.close();
		assertFalse(em1.isOpen());
		assertFalse(em2.isOpen());	
		
	}
	
	/**
	 * If the close method is invoked when a transaction is active, 
	 * the persistence context remains managed until the transaction completes
	 */
	@Test
	public void ch5_7() {
		EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("tws:filemodel");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.close();
		assertTrue(em.isOpen());
		em.getTransaction().commit();
		assertFalse(em.isOpen());
	}
}
