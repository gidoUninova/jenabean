package example.guide;

import thewebsemantic.Id;
import thewebsemantic.Namespace;

@Namespace("http://example.org/")
public class Book {
	String isbn;

	@Id
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
