package examples.model.create;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class FlatFile  {
	public static void main(String[] args) {
		
		Model model = ModelFactory.createDefaultModel();
		model.read("file:bestbuy/semanticweb.rdf");
		
		StmtIterator stmts = model.listStatements();
		int count=0;
		while(stmts.hasNext()) {
			count++;
			stmts.next();
		}
		System.out.println(count + " triples were read");

	}
	
	
}