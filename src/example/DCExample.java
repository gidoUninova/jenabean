package example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class DCExample {
	public static void main(String[] args) throws Exception {
		OntModel m = ModelFactory.createOntologyModel();
		Bean2RDF writer = new Bean2RDF(m);		
		Book bean = new Book();
		bean.setIsbn("0596002637");
		bean.setCreator("Shelley Powers");
		bean.setSubject("RDF, semantic web, xml");
		writer.save(bean);
		m.write(System.out);
		
		//write to a file
		m.write(new FileWriter("book.rdf"));
		//create a new empty model
		m = ModelFactory.createOntologyModel();
		// read in rdf 
		m.read("file:book.rdf");
		
		// make sure we have one book by Shelley Powers
		RDF2Bean reader = new RDF2Bean(m);
		Collection<Book> books = reader.load(Book.class);
		for (Book book : books)
			System.out.println(book.getCreator() + book.getIsbn());		
	}
}
