package thewebsemantic;

import javax.persistence.PersistenceException;

public class NotBoundException extends PersistenceException {
	public NotBoundException(String msg) {
		super(msg);
	}
}
