package example;

import java.util.Collection;
import java.util.LinkedHashSet;

import thewebsemantic.Namespace;
import thewebsemantic.Uri;


public class Tag {

	private Collection<Taggable> elements = new LinkedHashSet<Taggable>();
	private String term;
	private String uri;

	public Tag() {
	}
	
	public Tag(String uri) {
		this.uri = uri;
	}
	

	public Collection<Taggable> getElements() {
		return elements;
	}

	public void setElements(Collection<Taggable> elements) {
		this.elements = elements;
	}

	public void addElement(Taggable e) {
		elements.add(e);
	}

	@thewebsemantic.Id
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
}