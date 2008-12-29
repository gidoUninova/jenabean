package thewebsemantic.jpa;

import java.util.HashMap;

import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;

import thewebsemantic.Bean2RDF;
import thewebsemantic.NotFoundException;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.rdf.model.Model;

public class JenaEntityManager implements javax.persistence.EntityManager {

	private Model _model;
	private RDF2Bean _reader;
	private Bean2RDF _writer;
	private HashMap<String, NamedNativeQuery> _queries;
	private boolean isOpen;
	
	public JenaEntityManager(Model m, HashMap<String, NamedNativeQuery> queries) {
		_model = m;
		_writer = new Bean2RDF(m);
		_reader = new RDF2Bean(m);
		_queries = queries;
		isOpen = true;
	}
	
	public void clear() {
		// TODO Auto-generated method stub

	}

	public void close() {
		isOpen = false;
	}

	public boolean contains(Object target) {
		return _reader.exists(target);
	}

	public Query createNamedQuery(String name) {
		if (!_queries.containsKey(name))
			throw new IllegalArgumentException(name + ": query not defined in entity.");
		NamedNativeQuery nnq = _queries.get(name);
		return new QueryWrapper(nnq.query(), _model, nnq.resultClass());
	}

	public QueryWrapper createNativeQuery(String queryString) {
		return null;
	}

	public QueryWrapper createNativeQuery(String arg0, Class arg1) {		
		return new QueryWrapper(arg0, _model, arg1);
	}
	
	public Query createNativeQuery(String arg0, String arg1) {
		throw new UnsupportedOperationException("Use createQuery(String, Class) instead.");
	}

	public Query createQuery(String arg0) {
		throw new UnsupportedOperationException("Use createQuery(String, Class) instead.");
	}

	public <T> T find(Class<T> type, Object arg1) {
		try {
			return _reader.load(type, arg1.toString());
		} catch (NotFoundException e) {
			return null;
		}
	}

	public void flush() {
		// TODO Auto-generated method stub

	}

	public Object getDelegate() {
		// TODO Auto-generated method stub
		return null;
	}

	public FlushModeType getFlushMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T getReference(Class<T> arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityTransaction getTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void joinTransaction() {
		// TODO Auto-generated method stub

	}

	public void lock(Object arg0, LockModeType arg1) {
		// TODO Auto-generated method stub

	}

	public <T> T merge(T arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void persist(Object bean) {
		_writer.save(bean);

	}

	public void refresh(Object bean) {
		_reader.load(bean);

	}

	public void remove(Object bean) {
		_writer.delete(bean);

	}

	public void setFlushMode(FlushModeType arg0) {
		// TODO Auto-generated method stub

	}
	
	public Model getModel() {
		return _model;
	}

}
