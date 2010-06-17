package example.query;

import java.util.Collection;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import thewebsemantic.RDF2Bean;
import thewebsemantic.Sparql;

public class Main {


	public static void main(String[] args) {
		
		String query = 
			"prefix ntn: <http://semanticbible.org/ns/2006/NTNames#>\n" +
			"SELECT ?s WHERE { ?s a ntn:Woman }";

		Model m = ModelFactory.createOntologyModel();
		m.read("file:NTNames.owl");
		m.read("file:NTN-individuals.owl");
		
		RDF2Bean reader = new RDF2Bean(m);
		reader.bindAll("example.query");	
	
		Collection<Woman> women = Sparql.exec(m, Woman.class, query);
		
		for (Human human : women)
			System.out.println(human.label + ":" + human.comment);

	}

}
