package test.jpa.library;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	String isbn;
	String title;
	Collection<Author> authors;
	Set<Tag> tags;
	Date copywrite;
	String shortDescription;
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Collection<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Collection<Author> authors) {
		this.authors = authors;
	}
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	public Date getCopywrite() {
		return copywrite;
	}
	public void setCopywrite(Date copywrite) {
		this.copywrite = copywrite;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	
	
}
