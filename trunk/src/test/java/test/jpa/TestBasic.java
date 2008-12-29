package test.jpa;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.Test;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import test.bean.Yin;
import thewebsemantic.jpa.Factory;
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
	public void foundButNotModel() throws IOException {
		boolean caught = false;
		try {
			Persistence.createEntityManagerFactory("tws:notamodel");
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
	
	@Test
	public void testContainerUnsupported() throws InstantiationException, IllegalAccessException, IOException {
		Provider p = Provider.class.newInstance();
		boolean caught = false;
		try {
			p.createContainerEntityManagerFactory(null, null);
		} catch (UnsupportedOperationException e) {
			caught = true;
		}
		assertTrue(caught);
	}
	
	@Test
	public void testForceAssembler() {
		Model m = ModelFactory.createDefaultModel();
		m.read("file:src/test/resources/testassembler.n3", "N3");
		Provider p = new Provider(m);
		Factory f =  p.createEntityManagerFactory("tws:test", null);
		EntityManager em =  f.createEntityManager();
		Man jesse = em.find(Man.class, "http://semanticbible.org/ns/2006/NTNames#Jesse");
		assertNotNull(jesse);
		assertEquals("the father of King David", jesse.getDescription());
	}
}
