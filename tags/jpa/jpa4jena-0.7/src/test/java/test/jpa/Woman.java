package test.jpa;

import java.net.URI;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import thewebsemantic.Namespace;

@NamedNativeQueries( { 
	@NamedNativeQuery(
		name="Woman.hasChildren", 
		query="PREFIX : <http://semanticbible.org/ns/2006/NTNames#>\n" +
		"SELECT DISTINCT ?s	WHERE { ?s a :Woman . ?s :parentOf ?Thing . }", 
		resultClass=Woman.class),
	@NamedNativeQuery(
		name="Woman.noChildren", 
		query="PREFIX : <http://semanticbible.org/ns/2006/NTNames#>\n" +
		      "SELECT ?s WHERE { ?s a :Woman . OPTIONAL { ?s :parentOf ?Thing . }\n" +
		      "FILTER (!bound(?Thing))}", 
		resultClass=Woman.class),
	@NamedNativeQuery(
		name="Woman.Jewish", 
		query="PREFIX : <http://semanticbible.org/ns/2006/NTNames#>\n" +
		"SELECT ?s	WHERE { ?s a :Woman . ?s :ethnicity :Jewish . }", 
		resultClass=Woman.class)
	
})


@Namespace("http://semanticbible.org/ns/2006/NTNames#")
public class Woman extends Human {
	
	public Woman() {}
	public Woman(URI uri) {
		super(uri);
	}
}