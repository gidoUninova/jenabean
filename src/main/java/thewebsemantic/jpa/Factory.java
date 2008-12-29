package thewebsemantic.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedNativeQuery;

import com.hp.hpl.jena.rdf.model.Model;

public class Factory implements EntityManagerFactory {

	private Model _model;
	private HashMap<String, NamedNativeQuery> _queries;
	
	public Factory(Model m, HashMap<String, NamedNativeQuery> queries) {
		_model = m;
		_queries = queries;
	}

	public void close() {

	}

	public EntityManager createEntityManager() {
		return new JenaEntityManager(_model, _queries);
	}

	public EntityManager createEntityManager(Map arg0) {
		return createEntityManager();
	}

	public boolean isOpen() {
		return false;
	}
	

}
