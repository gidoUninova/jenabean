package thewebsemantic.jpa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedNativeQuery;

import com.hp.hpl.jena.rdf.model.Model;

public class JBFactory implements EntityManagerFactory {

	private Model _model;
	private HashMap<String, NamedNativeQuery> _queries;
	private boolean isOpen;
	private HashSet<JBEntityManager> entityManagers;
	private String name;
	private JBProvider provider;

	public JBFactory(JBProvider p, String n, Model m, HashMap<String, NamedNativeQuery> queries) {
		_model = m;
		_queries = queries;
		isOpen = !_model.isClosed();
		entityManagers = new HashSet<JBEntityManager>();
		name = n;
		provider = p;
	}

	public synchronized void close() {
		_model = null;
		_queries = null;
		isOpen = false;
		for (JBEntityManager em : entityManagers) {
			em.close();
		}
		entityManagers.clear();
		provider.notifyClosed(this);
		provider = null;
	}

	public synchronized EntityManager createEntityManager() {
		if (!isOpen)
			throw new IllegalStateException("The factory is closed.");
		JBEntityManager em =  new JBEntityManager(_model, _queries);
		entityManagers.add(em);
		return em;
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

	public Object getName() {
		return name;
	}


}
