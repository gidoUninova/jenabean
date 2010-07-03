package test.jpa.library;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries(value={
		@NamedNativeQuery(
				name="Author.ALL",
				resultClass=Author.class,
				query="SELECT ?s WHERE{?s a ?type}")
		
})

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	int id;
	String firstName;
	String middleInitial;
	String lastName;
	Collection<Book> books;
	
	public Author() {}
	public Author(String fn, String mi, String ln) {
		firstName = fn;
		lastName = ln;
		middleInitial = mi;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Collection<Book> getBooks() {
		return books;
	}
	public void setBooks(Collection<Book> books) {
		this.books = books;
	}	
}
