package test.jpa;

import java.util.Collection;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;
import thewebsemantic.Uri;
@NamedNativeQueries( { 
	@NamedNativeQuery(
		name="Human.hasChildren", 
		query="PREFIX : <http://semanticbible.org/ns/2006/NTNames#>\n" +
		"SELECT DISTINCT ?s	WHERE { ?s a :Human . ?s :parentOf ?Thing . }"
		)	
})

@Namespace("http://semanticbible.org/ns/2006/NTNames#")
public class Human {
	private String name;
	private String description;
	private String uri;
	private Collection<Human> children;
	private Human knew;
	
	public Human getKnew() {
		return knew;
	}

	public void setKnew(Human knew) {
		this.knew = knew;
	}

	@RdfProperty("http://semanticbible.org/ns/2006/NTNames#parentOf")
	public Collection<Human> getChildren() {
		return children;
	}

	public void setChildren(Collection<Human> children) {
		this.children = children;
	}

	public Human(String uri) {
		this.uri = uri;
	}
	
	@Uri
	public String uri() {
		return uri;
	}
	
	@RdfProperty("http://semanticbible.org/ns/2006/NTNames#name_en")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@RdfProperty("http://semanticbible.org/ns/2006/NTNames#description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (obj instanceof Human)
			return equals((Human)obj);
		else
			return false;
	}
	
	public boolean equals(Human h) {
		return uri.equals(h.uri);
	}
	
	
	
}
