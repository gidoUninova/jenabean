package thewebsemantic.jpa;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import thewebsemantic.Namespace;
import thewebsemantic.Sparql;
import thewebsemantic.TypeWrapper;

import com.hp.hpl.jena.query.QuerySolutionMap;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;

@SuppressWarnings("unchecked")
public class JBQueryWrapper implements Query {

	JBEntityManager em;
	String query;
	Class<?> type;
	QuerySolutionMap initialSettings;

	
	public JBQueryWrapper(String q, JBEntityManager entityManager, Class c) {
		query = q;
		type = c;
		initialSettings = new QuerySolutionMap() ;
		em = entityManager;
	}

	public int executeUpdate() {
		return 0;
	}

	public List getResultList() {
		return Sparql.exec(em._model, type, query, initialSettings);
	}

	public Object getSingleResult() {
		List result = Sparql.exec(em._model, type, query, initialSettings);
		if ( result.size() > 1 ) 
			throw new NonUniqueResultException();
		else if ( result.size()==0 )
			throw new NoResultException();
		return result.iterator().next();
	}

	public Query setFirstResult(int startPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query setFlushMode(FlushModeType flushMode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query setHint(String hintName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query setMaxResults(int maxResult) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query setParameter(String name, Object value) {
		if ( value instanceof URI) {
			String uri = value.toString();
			setUriParameter(name, uri);
		} else if ( value.getClass().isAnnotationPresent(Namespace.class)) {
			String uri = TypeWrapper.instanceURI(value);
			setUriParameter(name, uri);
		} else if ( value instanceof Resource) {
			initialSettings.add(name, (Resource)value);
		} else {
			initialSettings.add(name, em._model.createTypedLiteral(value));
		}
		return this;
	}

	public void setUriParameter(String name, String uri) {
		RDFNode node = em._model.createResource(uri);
		initialSettings.add(name, node);
	}

	
	
	public Query setParameter(int position, Object value) {
		throw new UnsupportedOperationException("not yet supported, try setParameter(name,value)");
	}

	public Query setParameter(String name, Date value, TemporalType temporalType) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query setParameter(String name, Calendar value,
			TemporalType temporalType) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query setParameter(int position, Date value,
			TemporalType temporalType) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query setParameter(int position, Calendar value,
			TemporalType temporalType) {
		// TODO Auto-generated method stub
		return null;
	}

}
