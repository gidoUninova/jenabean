package test.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.hp.hpl.jena.rdf.model.Model;

public class TestExamples {

	@Test
	public void basic() {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("tws:blank");
		EntityManager em = factory.createEntityManager();
	
		// Create new customer
	    Customer customer0 = new Customer();
	    customer0.setId(1);
	    customer0.setName("Joe Smith");

	    // Persist the customer
	    em.persist(customer0);

	    // Create 2 orders
	    Order order1 = new Order();
	    order1.setId(100);
	    order1.setAddress("123 Main St. Anytown, USA");

	    Order order2 = new Order();
	    order2.setId(200);
	    order2.setAddress("567 1st St. Random City, USA");
	    
	    customer0.getOrders().add(order1);
	    order1.setCustomer(customer0);
	 
	    customer0.getOrders().add(order2);
	    order2.setCustomer(customer0);

	    Model m = (Model)em.getDelegate();
	    m.write(System.out, "N3");
		
	}
}
