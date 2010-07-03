package examples.model.create;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Convert {

	public static void main(String[] args) throws IOException {

		//read a local data model
		Model data = ModelFactory.createDefaultModel();
		data.read("file:bestbuy/semanticweb.rdf", "RDF/XML");
		
		data.write(System.out, "N3");
		pause();
		data.write(System.out, "RDF/XML-ABBREV");	
		pause();
		data.write(System.out, "N-TRIPLE");	
		
	}

	private static void pause() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();		
	}
	
	
}
