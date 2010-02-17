package examples.ontmodel;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class OntModel2 {

	public static void main(String[] args) {
		
		OntModel ontModel = ModelFactory.createOntologyModel();
		//ontModel.read("http://www.heppnetz.de/ontologies/goodrelations/v1.owl");
		ontModel.read("file:bestbuy/goodrelations.owl");
		
		ExtendedIterator<OntClass> classes = ontModel.listClasses();
		while(classes.hasNext()) {
			OntClass ontClass = classes.next();
			if (!ontClass.isAnon()) {
				String label = ontClass.getLabel(null);
				String comment = ontClass.getComment(null);
				if (comment!=null)
				System.out.println(label + "\n\t" + comment.substring(0,40) + "...");	
						
			}
		}
	}
}
