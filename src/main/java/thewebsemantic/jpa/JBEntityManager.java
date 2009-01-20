package thewebsemantic.jpa;

import java.util.HashMap;
import java.util.HashSet;

import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import thewebsemantic.Bean2RDF;
import thewebsemantic.NotFoundException;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.rdf.model.Model;

public class JBEntityManager implements javax.persistence.EntityManager {

	private static final String TRANSACTIONS_NOT_SUPPORTED = "This model does not support transactions.";
	private static final String CLOSED = "This EntityManager is closed.";
	protected Model _model;
	protected RDF2Bean _reader;
	protected Bean2RDF _writer;
	private HashMap<String, NamedNativeQuery> _queries;
	private boolean isOpen;
	private FlushModeType flushType = FlushModeType.COMMIT;
	private JBEntityTransaction ta;
	private HashSet<Object> cache;

	public JBEntityManager(Model m, HashMap<String, NamedNativeQuery> queries, Bean2RDF writer, RDF2Bean reader) {
		_model = m;
		_writer = writer;
		_reader = reader;
		_queries = queries;
		isOpen = true;
		cache = new HashSet<Object>();
	}

	public void clear() {
		if (! isOpen)
			throw new IllegalStateException(CLOSED);
		// TODO Auto-generated method stub
	}

	public void close() {
		cache.clear();
		isOpen = false;
	}

	public boolean contains(Object target) {
		if (! isOpen)
			throw new IllegalStateException(CLOSED);
		return _reader.exists(target);
	}

	public JBQueryWrapper createNamedQuery(String name) {
		if (! isOpen)
			throw new IllegalStateException(CLOSED);
		if (!_queries.containsKey(name))
			throw new IllegalArgumentException(name + ": query not defined in entity.");
		NamedNativeQuery nnq = _queries.get(name);
		Class cls = (nnq.resultClass() == Void.TYPE) ? Object.class : nnq.resultClass();
		return new JBQueryWrapper(nnq.query(), this, cls);
	}

	public JBQueryWrapper createNativeQuery(String queryString) {
		return createNativeQuery(queryString, Object.class);
	}

	public JBQueryWrapper createNativeQuery(String arg0, Class arg1) {	
		if (! isOpen)
			throw new IllegalStateException(CLOSED);
		return new JBQueryWrapper(arg0, this, arg1);
	}

	public Query createNativeQuery(String arg0, String arg1) {
		throw new UnsupportedOperationException("Use createNativeQuery(String, Class) instead.");
	}

	public Query createQuery(String arg0) {
		return createNativeQuery(arg0);
	}

	public <T> T find(Class<T> type, Object arg1) {
		if (! isOpen)
			throw new IllegalStateException(CLOSED);
		try {
			return _reader.load(type, arg1.toString());
		} catch (NotFoundException e) {
			return null;
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	public void flush() {
		for (Object obj : cache)
			_writer.save(obj);
	}

	public Model getDelegate() {
		return getModel();
	}

	public FlushModeType getFlushMode() {
		return flushType;
	}

	public <T> T getReference(Class<T> type, Object key) {
		if (! isOpen)
			throw new IllegalStateException(CLOSED);
		try {
			return _reader.load(type, key.toString());
		} catch (NotFoundException e) {
			throw new EntityNotFoundException();
		}
	}

	public EntityTransaction getTransaction() {
		if (! isOpen)
			throw new IllegalStateException(CLOSED);
		if (! _model.supportsTransactions())
			throw new UnsupportedOperationException(TRANSACTIONS_NOT_SUPPORTED);
		if (ta == null) ta = new JBEntityTransaction(_model.getGraph().getTransactionHandler(), this);
		return ta;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void joinTransaction() {
		throw new UnsupportedOperationException("This entity manager does not support JTA transactions");
	}

	public void lock(Object arg0, LockModeType arg1) {
		if (! isOpen)
			throw new IllegalStateException(CLOSED);
		

	}

	public <T> T merge(T bean) {
		_writer.save(bean);
		return bean;
	}

	public void persist(Object bean) {
		if ( cache.contains(bean))
			return;
		_reader.init(bean);
		_writer.save(bean);
		if (ta != null && ta.isActive())
			cache.add(bean);
	}

	public void refresh(Object bean) {
		_reader.load(bean);
	}

	public void remove(Object bean) {
		_writer.delete(bean);
	}

	public void setFlushMode(FlushModeType arg0) {
		flushType = arg0;
	}

	public Model getModel() {
		return _model;
	}

}
