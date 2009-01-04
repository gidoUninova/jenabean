package thewebsemantic.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedNativeQuery;

import com.hp.hpl.jena.rdf.model.Model;

public class JBFactory implements EntityManagerFactory {

	private Model _model;
	private HashMap<String, NamedNativeQuery> _queries;
	private boolean isOpen;
	
	public JBFactory(Model m, HashMap<String, NamedNativeQuery> queries) {
		_model = m;
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
		return new JBEntityManager(_model, _queries);
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
