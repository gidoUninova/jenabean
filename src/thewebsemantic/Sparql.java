package thewebsemantic;

import java.util.Collection;
import java.util.LinkedList;


import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

public class Sparql {
	public static <T> Collection<T> exec(String query, Model m, Class<T> c) {
		RDF2Bean reader = new RDF2Bean(m);
		Query q = QueryFactory.create(query);
		QueryExecution qexec = QueryExecutionFactory.create(q, m);
		Collection<T> beans = new LinkedList<T>();
		try {
			ResultSet results = qexec.execSelect();
			for (;results.hasNext();) {
				Resource r = results.nextSolution().getResource("s");
				beans.add(reader.load(c, r));				
			}
			return beans;
		} finally {
			qexec.close();
		}
	}
}
