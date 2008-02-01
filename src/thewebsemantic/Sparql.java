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
	
	/**
	 * Helpful for binding a query result set with a single solution
	 * subject to a particular java bean.  This returns a collection of beans.
	 * Queries are required to follow this pattern in the select clause:
	 * 
	 * <code>SELECT ?s WHERE ...</code>
	 * 
	 * Jenabean will attempt to create an instance of type <code>c</code> bound to 
	 * the RDF resources returned in your query.  It's important to use 
	 * name variable ?s.  This is the named variable Jenabean will expect.
	 * You should make sure that your query
	 * only returns one type or base type, for example, this snippet ensures that
	 * only resources of OWL type Bird are selected...
	 * 
	 * <code>SELECT ?s WHERE { ?s a :Bird ...</code>
	 * 
	 * If you SPARQL query returns heterogenous types, classcast exceptions
	 * will be thrown.
	 * 
	 * @param <T>
	 * @param m jena model
	 * @param c Java Class to which the OWL type is bound to
	 * @param query a full SPARQL query
	 * @return
	 */
	public static <T> Collection<T> exec(Model m, Class<T> c, String query) {
		RDF2Bean reader = new RDF2Bean(m);
		QueryExecution qexec = getQueryExec(m, query);
		Collection<T> beans = new LinkedList<T>();
		try {
			ResultSet results = qexec.execSelect();
			for (;results.hasNext();) beans.add(reader.load(c, resource(results)));
			return beans;
		} finally {
			qexec.close();
		}
	}

	private static QueryExecution getQueryExec(Model m, String query) {
		Query q = QueryFactory.create(query);
		return QueryExecutionFactory.create(q, m);
	}

	private static Resource resource(ResultSet results) {
		return results.nextSolution().getResource("s");
	}
}
