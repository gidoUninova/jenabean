package test.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.junit.Test;

import test.bean.Yin;
import thewebsemantic.jpa.JBFactory;
import thewebsemantic.jpa.JBProvider;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

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
		JBProvider p = JBProvider.class.newInstance();
		Model m = null;
		m  = p.findAssembly("bad");
		assertNotNull(m);
	}
	
	@Test
	public void testContainerUnsupported() throws InstantiationException, IllegalAccessException, IOException {
		JBProvider p = JBProvider.class.newInstance();
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
		JBProvider p = new JBProvider(m);
		JBFactory f =  p.createEntityManagerFactory("tws:test", null);
		EntityManager em =  f.createEntityManager();
		Man jesse = em.find(Man.class, "http://semanticbible.org/ns/2006/NTNames#Jesse");
		assertNotNull(jesse);
		assertEquals("the father of King David", jesse.getDescription());

		Human human = em.find(Human.class, "http://semanticbible.org/ns/2006/NTNames#Jesse");
		assertNotNull(human);
		assertEquals("the father of King David", human.getDescription());

		boolean caught = false;
		try {
			em.find(Woman.class, "http://semanticbible.org/ns/2006/NTNames#Jesse");
		} catch (PersistenceException e) {
			caught = true;
		}
		assertTrue(caught);
		Query q = em.createNamedQuery("Woman.hasChildren");
		List<Woman> haveChildren = q.getResultList();
		assertNotNull(haveChildren);
		assertTrue(haveChildren.size() > 0);
		q = em.createNamedQuery("Woman.noChildren");
		List<Woman> withoutChildren = q.getResultList();
		assertNotNull(withoutChildren);
		assertTrue(withoutChildren.size() > 0);
		for (Woman woman2 : withoutChildren) {
			assertFalse(haveChildren.contains(woman2));
		}

		f = p.createEntityManagerFactory("tws:test2", null);
		em = f.createEntityManager();
		em.find(UnkownThing.class, "http://semanticbible.org/ns/2006/NTNames#Jesse");		
	}
}
