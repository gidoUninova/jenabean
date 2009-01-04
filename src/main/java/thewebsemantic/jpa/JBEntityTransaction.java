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
	
	@Override
	public void begin() {
		model.begin();
		isActive = true;
	}

	@Override
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

	@Override
	public boolean getRollbackOnly() {
		if (! isActive)
			throw new IllegalStateException("transaction is not active");
		return isRollBackOnly;
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public void rollback() {
		if (! isActive)
			throw new IllegalStateException("transaction is not active");
		model.abort();
		isActive = false;

	}

	@Override
	public void setRollbackOnly() {
		isRollBackOnly = true;
	}

}
