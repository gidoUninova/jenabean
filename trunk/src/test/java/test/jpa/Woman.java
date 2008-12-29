package test.jpa;

import java.util.Collection;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import thewebsemantic.Namespace;

@NamedNativeQueries( { 
	@NamedNativeQuery(name="Woman.hasChildren", query="", resultClass=Woman.class),
	@NamedNativeQuery(
			name="Woman.noChildren", 
			query="PREFIX : <http://semanticbible.org/ns/2006/NTNames#>\n" +
			"SELECT ?s	WHERE { ?s a :Woman .  OPTIONAL { ?s :parentOf ?Thing . } FILTER (!bound(?Thing))}", 
			resultClass=Woman.class),
	@NamedNativeQuery(name="Woman.Jewish", query="", resultClass=Woman.class) 
})


@Namespace("http://semanticbible.org/ns/2006/NTNames#")
public class Woman extends Human {
	public Woman(String uri) {
		super(uri);
	}
}