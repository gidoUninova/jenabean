package test.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import thewebsemantic.jpa.JBFactory;

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
		
		JBFactory jbfactory = (JBFactory)factory;
		jbfactory.getModel().write(System.out, "N3");
		
	}

}
