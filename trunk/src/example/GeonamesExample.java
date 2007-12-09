package example;

import java.util.Collection;

import thewebsemantic.RDF2Bean;
import thewebsemantic.binding.Binder;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class GeonamesExample {
	
	/**
	 * load up all the cities from capitals.rdf, based on ontology
	 * defined in geonames.owl.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		m.read("file:src/example/geonames.owl");
		m.read("file:src/example/capitals.rdf");
		
		Binder b = Binder.instance();
		b.bind(GeonamesVocabulary.Feature).to(City.class);
		RDF2Bean reader = new RDF2Bean(m);
		Collection<City> cities = reader.load(City.class);
		for (City city : cities) {
			System.out.println(city.getName());
			System.out.println(city.getUri());
			for (String name : city.getAlternateNames()) {
				System.out.println("\t" + name);
			}
		}
	}
}
