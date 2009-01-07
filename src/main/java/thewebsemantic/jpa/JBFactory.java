package thewebsemantic.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedNativeQuery;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.rdf.model.Model;

public class JBFactory implements EntityManagerFactory {

	private Model _model;
	private HashMap<String, NamedNativeQuery> _queries;
	private boolean isOpen;
	private RDF2Bean reader; 
	private Bean2RDF writer;
	
	public JBFactory(Model m, HashMap<String, NamedNativeQuery> queries) {
		_model = m;
		reader = new RDF2Bean(_model);
		writer = new Bean2RDF(_model);
		_queries = queries;
		isOpen = !_model.isClosed();
	}

	public void close() {
		_model = null;
		_queries = null;
		isOpen = false;
	}

	public EntityManager createEntityManager() {
		if (!isOpen)
			throw new IllegalStateException("The factory is closed.");
		return new JBEntityManager(_model, _queries, writer, reader);
	}

	public EntityManager createEntityManager(Map arg0) {
		return createEntityManager();
	}

	public boolean isOpen() {
		return isOpen && !_model.isClosed();
	}
	
	public Model getModel() {
		return _model;
	}
}
