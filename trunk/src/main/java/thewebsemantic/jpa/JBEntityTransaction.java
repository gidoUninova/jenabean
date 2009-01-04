package thewebsemantic.jpa;

import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.hp.hpl.jena.rdf.model.Model;

public class JBEntityTransaction implements EntityTransaction {

	private Model model;
	private boolean isActive = false;
	private boolean isRollBackOnly = false;
	
	public JBEntityTransaction(Model m) {
		model = m;
	}
	
	
	public void begin() {
		model.begin();
		isActive = true;
	}

	
	public void commit() {
		if (! isActive)
			throw new IllegalStateException("transaction is not active");

		try {
			model.commit();
			isActive = false;
		} catch (Exception e) {
			throw new RollbackException(e);
		}
	}

	
	public boolean getRollbackOnly() {
		if (! isActive)
			throw new IllegalStateException("transaction is not active");
		return isRollBackOnly;
	}

	
	public boolean isActive() {
		return isActive;
	}

	
	public void rollback() {
		if (! isActive)
			throw new IllegalStateException("transaction is not active");
		model.abort();
		isActive = false;

	}

	
	public void setRollbackOnly() {
		isRollBackOnly = true;
	}

}
