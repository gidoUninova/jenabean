package example.foaf;

import java.io.IOException;

import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Main2 {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Model m = ModelFactory.createDefaultModel();
		Jenabean J = Jenabean.instance();
		J.bind(m);
		J.bindAll("example.foaf");
		
		Person p = new Person("http://foo/bar");
		p.setHomepage(new Document("http://homepage"));
		p.setName("thewebsemantic");
		J.writer().save(p);
		
		m.write(System.out, "N3");
	}
	
}
