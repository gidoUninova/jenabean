package example.vinay;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hp.hpl.jena.rdf.model.Model;

public class Vinay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("tws:filemodel");
		System.out.println(factory.getClass());
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createNamedQuery("Employee.ALL");
		//Query q = em.createNativeQuery("SELECT ?s WHERE {?s a <http://example.vinay/Employee> . ?s <http://example.vinay/role> ?role}",Employee.class);
		q.setParameter("role", Role.ARCHITECT);
		Collection<Employee> emps = q.getResultList();
		for (Employee employee : emps) {
			
			System.out.println(employee.getClass());
		}
	}

}
