package test.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.Test;

import test.bean.Yin;

public class TestBasic {

	@Test
	public void basic() throws IOException {     
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("tws:test");
		EntityManager em = factory.createEntityManager();
		assertTrue(em.isOpen());
	}
	
	@Test
	public void missing() throws IOException {
		boolean caught = false;
		try {
			Persistence.createEntityManagerFactory("tws:bad");
		} catch (PersistenceException e) {
			caught = true;
		}
		assertTrue(caught);
	}

	
	@Test
	public void simple() {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("tws:test");
		EntityManager em = factory.createEntityManager();
		Yin yin = new Yin();
		em.persist(yin);
		
		Yin yin2 = em.find(Yin.class, yin.hashCode());
		assertNotNull(yin2);
	}
}
