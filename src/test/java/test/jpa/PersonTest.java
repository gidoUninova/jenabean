package test.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hp.hpl.jena.rdf.model.Model;

import static org.junit.Assert.*;

public class PersonTest {
	 private final Address a1 = new Address("A Rd.", "", "Dallas", "TX", "75001");
	    private final Person p1 = new Person("Brett", 'L', "Schuchert", a1);
	 
	    private final Address a2 = new Address("B Rd.", "S2", "OkC", "OK", "73116");
	    private final Person p2 = new Person("FirstName", 'K', "LastName", a2);
 
    private EntityManagerFactory emf;
    private EntityManager em;
 
    @Before
    public void initEmfAndEm() {
        emf = Persistence.createEntityManagerFactory("tws:filemodel");
        em = emf.createEntityManager();
        p1.setId(0);
        p2.setId(1);
        Model m = (Model)em.getDelegate();
        //m.write(System.out,"N3");
    }
 
    @After
    public void cleanup() {
        Model m = (Model)em.getDelegate();
        m.removeAll();
        em.close();
    }
 
    @SuppressWarnings("unchecked")
    @Test
    public void insertAndRetrieve() {
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
 
        final List<Person> list = em.createNativeQuery("select ?s where { ?s a <http://test.jpa/Person> }")
                .getResultList();
 
        assertEquals(2, list.size());
        for (Person current : list) {
            final String firstName = current.getFirstName();
            assertTrue(firstName.equals("Brett")
                    || firstName.equals("FirstName"));
        }
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void insertAndRetrieveWAddress() {
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
 
        final List<Person> list = 
        	em.createNativeQuery("select ?s where { ?s a <http://test.jpa/Person> }").getResultList();
 
        assertEquals(2, list.size());
        for (Person current : list) {
            final String firstName = current.getFirstName();
            final String streetAddress1 = current.getAddress()
                    .getStreetAddress1();
 
            assertTrue(firstName.equals("Brett")
                    || firstName.equals("FirstName"));
            assertTrue(streetAddress1.equals("A Rd.")
                    || streetAddress1.equals("B Rd."));
        }
    }
    
    @Test
    public void createCompany() {
        final Company c1 = new Company();
        c1.setId(0);
        c1.setName("The Company");
        c1.setAddress(new Address("D Rd.", "", "Paris", "TX", "77382"));
 
        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().commit();
 
        final Company foundCompany = findCompanyNamed(em, "The Company");
 
        assertEquals("D Rd.", foundCompany.getAddress().getStreetAddress1());
        // Note, we do not need an assert. Why? the method getSingleResult()
        // will throw an exception if there is not exactly one
        // object found. We'll research that in the second JPA tutorial.
    }

    private Company findCompanyNamed(final EntityManager em, String name) {
        return (Company) em.createNativeQuery(
                "select ?s where { " +
                "?s a <http://test.jpa/Company>  . " +
                "?s <http://test.jpa/name> ?name FILTER regex(?name, ?match) }")
                .setParameter("match", name).getSingleResult();
    }
    
    private Company createCompanyWithTwoEmployees() {
        final Company c1 = new Company();
        c1.setId(11);
        c1.setName("The Company");
        c1.setAddress(new Address("D Rd.", "", "Paris", "TX", "77382"));
 
        final List<Person> people = PersonTest.generatePersonObjects();
        for (Person p : people) {
            c1.hire(p);
        }
 
        em.getTransaction().begin();
        for (Person p : people) {
            em.persist(p);
        }
        em.persist(c1);
        em.getTransaction().commit();
 
        return c1;
    }
    @SuppressWarnings("unchecked")
    @Test
    public void createCompanyAndHirePeople() {
        createCompanyWithTwoEmployees();
 
        final List<Person> list = em.createNativeQuery("select ?s where { ?s a <http://test.jpa/Person> }")
                .getResultList();
        assertEquals(2, list.size());
 
        final Company foundCompany = findCompanyNamed(em, "The Company");
        assertEquals(2, foundCompany.getEmployees().size());
    }
 
    @Test
    public void hireAndFire() {
        final Company c1 = createCompanyWithTwoEmployees();
        final List<Person> people = PersonTest.generatePersonObjects();
 
        em.getTransaction().begin();
 
        for (Person p : people) {
            c1.fire(p);
        }

        em.persist(c1);
        em.getTransaction().commit();
        ((Model)em.getDelegate()).write(System.out, "N3");
        final Company foundCompany = findCompanyNamed(em, "The Company");
        assertEquals(0, foundCompany.getEmployees().size());
    }

    public static List<Person> generatePersonObjects() {
        final List<Person> people = new ArrayList<Person>();
        final Address a1 = new Address("A Rd.", "", "Dallas", "TX", "75001");
        final Person p1 = new Person("Brett", 'L', "Schuchert", a1);
        p1.setId(0);
 
        final Address a2 = new Address("B Rd.", "S2", "OkC", "OK", "73116");
        final Person p2 = new Person("FirstName", 'K', "LastName", a2);
        p2.setId(1);
        
        people.add(p1);
        people.add(p2);
 
        return people;
    }

}