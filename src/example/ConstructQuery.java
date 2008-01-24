package example;

import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ConstructQuery {
	public static void main(String[] args) {
		OntDocumentManager.getInstance().addAltEntry( 
			"http://www.geonames.org/ontology", "file:src/example/geonames.owl" );		
    	OntModel m = ModelFactory.createOntologyModel();
    	
    	//extended with one new property
		m.read("file:src/example/geonamesext.owl"); 
		
		// data
		m.read("file:src/example/capitals.rdf");
		
		String queryString = 
			"PREFIX gn: <http://www.geonames.org/ontology#> " +
			"PREFIX ext: <http://www.example.org/geonamesext.owl#>\n\n " +
			"CONSTRUCT " +
            "{?place ext:population ?population} " +
			"WHERE {" +
			"      ?place gn:population ?population . " +
			"      FILTER regex(?population, \"[0-9]+\", \"i\") }";

		Query query = QueryFactory.create(queryString);

		QueryExecution qe = QueryExecutionFactory.create(query, m);
		Model results = qe.execConstruct();
		results.write(System.out, "N3");

	}
}
