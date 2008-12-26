package test.jpa;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.Test;

import com.hp.hpl.jena.rdf.model.Model;

import test.bean.Yin;
import thewebsemantic.jpa.Provider;

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
	
	@Test
	public void testFindAssembly() throws InstantiationException, IllegalAccessException, IOException {
		Provider p = Provider.class.newInstance();
		Model m = null;
		m  = p.findAssembly("bad");
		assertNotNull(m);
	}
}
