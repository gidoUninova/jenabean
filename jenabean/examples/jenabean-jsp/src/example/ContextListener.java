package example;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import thewebsemantic.binding.Jenabean;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;


public class ContextListener implements ServletContextListener {

	
	public void contextDestroyed(ServletContextEvent ev) {
	}

	public void contextInitialized(ServletContextEvent ev) {
		OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM_MICRO_RULE_INF );
		Jenabean.instance().bind(m);
	}


}
