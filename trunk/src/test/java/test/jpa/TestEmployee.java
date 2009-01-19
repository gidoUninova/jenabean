package test.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import test.jpa.model.Employee;
import test.jpa.model.Gender;
import test.jpa.model.PhoneNumber;
import test.jpa.model.SamplePopulation;

import com.hp.hpl.jena.rdf.model.Model;

public class TestEmployee {

	@BeforeClass
	public static void init() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("tws:filemodel");

		EntityManager em = emf.createEntityManager();
		Model m = (Model) em.getDelegate();
		m.removeAll();

		em.getTransaction().begin();
		new SamplePopulation().persistAll(em);
		em.getTransaction().commit();
		em.close();
	}

	@AfterClass
	public static void after() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("tws:filemodel");

		EntityManager em = emf.createEntityManager();
		Model m = (Model) em.getDelegate();
		m.removeAll();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void basic() {
		EntityManager em = getEM();
		Query q = em.createNativeQuery("PREFIX : <http://test.jpa.model/>\n" +
				"SELECT ?s WHERE {?s a ?type . ?s :firstName ?firstName }", Employee.class);
		q.setParameter("type", Employee.class);
		q.setParameter("firstName", "Jill");
		List<Employee> results = q.getResultList();
		assertTrue(results.size() > 0);
		for (Employee employee : results) {
			assertEquals(employee.getFirstName(), "Jill");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void basic1() {
		EntityManager em = getEM();
		Query q = em.createNativeQuery("PREFIX : <http://test.jpa.model/>\n" +
				"SELECT ?s WHERE {?s a ?type . ?s :gender ?gender }", Employee.class);
		q.setParameter("type", Employee.class);
		q.setParameter("gender", Gender.Male);
		List<Employee> results = q.getResultList();
		assertTrue(results.size() == 7);
		for (Employee employee : results) {
			assertTrue(Gender.Male == employee.getGender());
		}
		
		q.setParameter("gender", Gender.Female);
		results = q.getResultList();
		assertTrue(results.size() == 5);
		for (Employee employee : results) {
			assertTrue(Gender.Female == employee.getGender());
		}
	}
	
	
	@Test
	public void basic2() {
		EntityManager em = getEM();
		Query q = em.createNativeQuery(
				"PREFIX : <http://test.jpa.model/>\n" +
				"PREFIX list: <http://jena.hpl.hp.com/ARQ/list#>\n" +
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
				"SELECT ?s WHERE {?s a ?type . ?s :phoneNumbers ?seq . ?seq rdfs:member ?member  . ?member :number \"5551234\" }", 
				Employee.class);
		q.setParameter("type", Employee.class);
		List<Employee> results = q.getResultList();
		for (Employee employee : results) {
			boolean found = false;
			for (PhoneNumber num : employee.getPhoneNumbers()) {
				if ("5551234".equals(num.getNumber()))
					found = true;
			}
			assertTrue(found);
		}

	}
	public EntityManager getEM() {
		EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("tws:filemodel");
		return emf.createEntityManager();		
	}

}
