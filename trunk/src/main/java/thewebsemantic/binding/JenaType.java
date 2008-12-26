package thewebsemantic.binding;

import java.util.Collection;
import thewebsemantic.NotFoundException;

public class JenaType<T> {

	private Class<T> type;
	
	public JenaType(Class<T> c) {
		type = c;
	}

	public T load(String id) throws NotFoundException {
		return (T)Jenabean.load(type, id);
	}

	public Collection<T> query(String query) {
		return Jenabean.query(type, query);
	}
	
	public Collection<T> load() {
		return Jenabean.load(type);
	}
	
}
