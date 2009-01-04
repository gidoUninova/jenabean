package thewebsemantic.jpa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import thewebsemantic.Sparql;

import com.hp.hpl.jena.rdf.model.Model;

public class JBQueryWrapper implements Query {

	Model m;
	String query;
	Class type;
	
	public JBQueryWrapper(String s, Model m, Class c) {
		this.m = m;
		query = s;
		type = c;
	}
	
	public int executeUpdate() {
		return 0;
	}

	public List getResultList() {
		return Sparql.exec(m, type, query);
	}

	public Object getSingleResult() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	public Query setParameter(int position, Object value) {
		// TODO Auto-generated method stub
		return null;
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
