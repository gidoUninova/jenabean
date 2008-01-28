package example;

import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.update.GraphStore;
import com.hp.hpl.jena.update.GraphStoreFactory;
import com.hp.hpl.jena.update.UpdateFactory;
import com.hp.hpl.jena.update.UpdateRequest;

public class ConstructQuery {
	public static void main(String[] args) {
		OntDocumentManager.getInstance().addAltEntry( 
			"http://www.geonames.org/ontology", "file:src/example/geonames.owl" );		
    	OntModel m = ModelFactory.createOntologyModel();
    	m.setNsPrefix("ext", "http://www.example.org/geonamesext.owl#");
		m.read("file:src/example/geonamesext.owl"); 
		m.read("file:src/example/capitals.rdf");
		
		String q =  
			"PREFIX gn: <http://www.geonames.org/ontology#> " +
			"PREFIX ext: <http://www.example.org/geonamesext.owl#>\n\n " +
			"INSERT " +
            "{?place ext:population ?population} " +
			"WHERE {" +
			"      ?place gn:population ?population . " +
			"      FILTER regex(?population, \"[0-9]+$\") }";

		UpdateRequest qe = UpdateFactory.create(q);
		GraphStore graphStore = GraphStoreFactory.create();
		graphStore.setDefaultGraph(m.getGraph());
		qe.exec(graphStore);
		m.write(System.out, "N3");

	}
}
