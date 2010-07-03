package examples.sparql;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolutionMap;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.shared.Lock;

public class Sparql2 {
	public static void main(String[] args) {		
		Model model = ModelFactory.createDefaultModel();
		model.read("file:bestbuy/semanticweb.rdf");
		
		String query = "select ?s ?p ?o {?s ?p ?o}";
		QuerySolutionMap binding = new QuerySolutionMap();
		Literal US = model.createLiteral("US", null);
		binding.add("o", US);
		QueryExecution qexec = QueryExecutionFactory.create(query, model, binding);
		
		try {
			model.enterCriticalSection(Lock.READ);
			ResultSet results = qexec.execSelect();
			String result = ResultSetFormatter.asText(results);
			System.out.println(result);
		} finally {
			model.leaveCriticalSection();
		}
	}
}

