package example.geonames;

import java.util.Collection;

import thewebsemantic.LocalizedString;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Main {

	public static void main(String[] args) {
		
		Model m = ModelFactory.createDefaultModel();
		
		// if you have a connection to the internet you may uncomment 
		// this line and consume linked data.  Try variations on the query 
		// for fun.
		//m.read("file:london.rdf");

		m.read("http://ws.geonames.org/search?q=london&maxRows=10&type=rdf");
		RDF2Bean reader = new RDF2Bean(m);
		reader.bind(Feature.class);
		//reader.bind(Feature.class.getPackage());
		//reader.bindAll("com.foo", "com.bar");
		
		Collection<Feature> locations = reader.load(Feature.class);
		for (Feature feature : locations) {
			for (LocalizedString s : feature.alternateName)
				//if ( s.getLang().equals("fr"))
					System.out.println(s.getLang() + ":" + s);
			
		}
	}
}
