package thewebsemantic.jpa;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.hp.hpl.jena.rdf.model.Model;

public class Factory implements EntityManagerFactory {

	private Model _model;
	
	public Factory(Model m) {
		_model = m;
	}

	public void close() {

	}

	public EntityManager createEntityManager() {
		return new JenaEntityManager(_model);
	}

	public EntityManager createEntityManager(Map arg0) {
		return createEntityManager();
	}

	public boolean isOpen() {
		return false;
	}
	

}
