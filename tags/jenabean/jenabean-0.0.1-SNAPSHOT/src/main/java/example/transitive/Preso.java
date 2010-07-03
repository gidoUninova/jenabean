package example.transitive;

import static com.hp.hpl.jena.ontology.OntModelSpec.OWL_MEM_MICRO_RULE_INF;
import thewebsemantic.Bean2RDF;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Preso {
	
	public static void main(String[] args) {
		OntModel m = ModelFactory.createOntologyModel(OWL_MEM_MICRO_RULE_INF); 
		Bean2RDF writer = new Bean2RDF(m);
		
		Location bristol = new Location("gb/bristol");
		
		writer.save(bristol);
		
		m.write(System.out, "N3");
	}
}
