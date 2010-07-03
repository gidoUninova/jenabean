package examples.model.create;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Union {

	public static void main(String[] args) {

		//read a local data model
		Model data = ModelFactory.createDefaultModel();
		data.read("file:bestbuy/semanticweb.rdf");

		//read a public vocabulary (goodrelations)
		Model vocab = ModelFactory.createDefaultModel();
		vocab.read("http://www.heppnetz.de/ontologies/goodrelations/v1.owl");
		
		// create a union of both models
		Model combined = vocab.union(data);
		
		System.out.println(data.listStatements(). toList().size());
		System.out.println(vocab.listStatements(). toList().size());
		System.out.println(combined.listStatements(). toList().size());

	}
	
}
