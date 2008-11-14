package example.guide;

import thewebsemantic.Bean2RDF;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Model m = ModelFactory.createDefaultModel();
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		m.setNsPrefix("", "http://example.org/");
		Bean2RDF writer = new Bean2RDF(m);
		Book paradoxOfChoice = new Book();
		paradoxOfChoice.setIsbn("978-0060005689");
		writer.save(paradoxOfChoice);
		m.write(System.out, "N3");
	}
}
