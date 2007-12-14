package example;

import java.util.Collection;

import thewebsemantic.RDF2Bean;
import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class GeonamesExample {
	
	/**
	 * load up all the cities from capitals.rdf, based on ontology
	 * defined in geonames.owl.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		OntModel m = ModelFactory.createOntologyModel();
		m.read("file:src/example/geonames.owl");
		m.read("file:src/example/capitals.rdf");
		
		Jenabean b = Jenabean.instance();
		b.bind(GeonamesVocabulary.Feature).to(City.class);
		RDF2Bean reader = new RDF2Bean(m);
		Collection<City> cities = reader.load(City.class);
		
		for (City city : cities) {
			reader.fill(city).with("alternateNames");
			System.out.println(city.getName());
			System.out.println(city.getUri());
			for (String name : city.getAlternateNames()) {
				System.out.println("\t" + name);
			}
		}
	}
}
