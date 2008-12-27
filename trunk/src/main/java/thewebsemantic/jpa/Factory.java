package thewebsemantic.jpa;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.hp.hpl.jena.rdf.model.Model;

public class Factory implements EntityManagerFactory {

	private Model _model;
	private String[] _packages;
	
	public Factory(Model m, String[] packages) {
		_model = m;
		_packages = packages;
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
	
	public String[] getPackages() {
		return _packages;
	}

}
