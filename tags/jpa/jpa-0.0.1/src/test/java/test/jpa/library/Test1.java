package test.jpa.library;

import static org.junit.Assert.*;
import static thewebsemantic.jpa.Util.concrete;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import test.jpa.Counter;
import thewebsemantic.binding.Persistable;

public class Test1 {
	

    Author[] authors = {
    	new Author("Hans","C","Anderson"),	
    	new Author("Ray","","Bradbury"),
    	new Author("Edgar","R","Burrows"),
    	new Author("Bill","","Venners"),
    	new Author("Vox","","Day"),
    	new Author("John","R","Tolkein")
    };
    

	
	@Test
	public void first() {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("tws:books");
		EntityManager em = factory.createEntityManager();
		int i=0;
		for (Author author : authors) {
			em.persist(author);
			assertEquals(i++, author.getId());
		}
		Query q = em.createNamedQuery("Author.ALL");
		q.setParameter("type", Author.class);
		List<Author> list = q.getResultList();
		assertEquals(6, list.size());
		
		Book b = new Book();
		b.setIsbn("1565923715");
		
		Author tolkein = em.find(Author.class, 5);
		list.clear();
		list.add(tolkein);
		b.setAuthors(list);
		em.persist(b);
		em.flush();
		b = em.find(Book.class, "1565923715");
		tolkein = b.getAuthors().iterator().next();
		
		
		Counter c = new Counter();
		concrete(em).setFlushListener(c);
		tolkein.setFirstName("J");
		tolkein.setMiddleInitial("RR");
		assertTrue(tolkein instanceof Persistable);
		em.flush();
		assertEquals(1, c.count);
	}


	public void createBooks() {
		//newBook("1565923715", )
		
	}
	
	public Book newBook(String isbn, Author[] authors, String title) {
		Book b = new Book();
		b.setIsbn(isbn);		
		b.setAuthors(Arrays.asList(authors));
		b.setTitle(title);
		return b;
	}
}
