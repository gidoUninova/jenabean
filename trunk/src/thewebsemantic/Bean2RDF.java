package thewebsemantic;

import static thewebsemantic.PrimitiveWrapper.isPrimitive;
import static thewebsemantic.TypeWrapper.instanceURI;
import static thewebsemantic.TypeWrapper.type;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Seq;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.shared.Lock;
import com.ibm.icu.math.BigDecimal;

/**
 * Converts a simple java bean to RDF, provided it's annotated with
 * <code>Namespace</code>. To make a bean persitable by jenabean, you are
 * merely required to add the Namespace annotation. By default public bean
 * properties are converted to rdf properties by appending "has" and proper
 * casing the property name. For example, a bean with methods getName() and
 * setName() would result in the RDF property "hasName", with the namespace
 * given in the classes Namespace annotation. <br/><br/> The default behavior
 * for rdf property naming is overridden by using the RdfProperty annotation
 * along with the getter method. The value supplied to the RdfProperty
 * annotation is taken as the full RDF property URI. <br/><br/> The bean itself
 * is typed using the Namespace annotation along with the bean name, for
 * example, Book.class with namespace "http://example.org/" becomes rdf type
 * "http://example.org/Book". <br/><br/> Here's a simple example of a bean
 * that's ready to be saved:
 * 
 * <pre>
 * <code>
 * package org.example;
 * import thewebsemantic.Id;
 * public Book {
 *    private String name;
 *    public void setName(String s) { name=s;}
 *    &#064;Id
 *    public String getName() {return name;}
 * }
 * </code>
 * </pre>
 * 
 * @see Namespace
 * @see Id
 * @see RdfProperty
 */
public class Bean2RDF extends Base {
	private ArrayList<Object> cycle;
	private boolean forceDeep = false;


	/**
	 * construct a new instance bound to OntModel <tt>m</tt>.
	 * @param m Jena OntModel instance
	 */
	public Bean2RDF(Model m) {
		super(m);
	}

	/**
	 * Saves <tt>bean</tt> to jena model.
	 * 
	 * @param bean
	 * @return jena resource representing <tt>bean</tt> within the model
	 */
	public Resource save(Object bean) {
		return write(bean, false);
	}
	
	
	public void delete(Object bean) {
		Resource i = m.getResource(instanceURI(bean));
		m.removeAll(null, null, i);
		m.removeAll(i, null, null);
	}
	
	/**
	 * Saves the entire object graph starting with <tt>bean</tt>.
	 * 
	 * @param bean
	 * @return
	 */
	public Resource saveDeep(Object bean) {
		return write(bean, true);
	}

	/**
	 * write a bean to the triple store
	 * 
	 * @param bean
	 * @return
	 */
	private synchronized Resource write(Object bean, boolean forceDeep) {
		try {
			m.enterCriticalSection(Lock.WRITE);
			this.forceDeep = forceDeep;
			cycle = new ArrayList<Object>();
			return _write(bean, false);
		} finally {
			m.leaveCriticalSection();
		}
	}

	private Resource _write(Object bean, boolean shallow) {
		return (cycle.contains(bean)) ? existing(bean) : 
			write(bean, toResource(bean), shallow);
	}

	private Resource toResource(Object bean) {
		return m.createResource(instanceURI(bean), getOntClass(bean));
	}

	private Resource existing(Object bean) {
		return m.createResource(instanceURI(bean));
	}

	/**
	 * returns an existing OntClass or creates a new one adding an important
	 * annotation indicating the original java class.
	 * 
	 * @param bean
	 *            the bean we are saving or updating to the triple store
	 * @return
	 */
	private Resource getOntClass(Object bean) {
		return ontClass(bean).addProperty(javaclass, bean.getClass().getName());
	}

	private Resource ontClass(Object bean) {
	   return ontClass(getURI(bean));
	}


	private String getURI(Object bean) {
		return (isBound(bean)) ? binder.getUri(bean) : type(bean).typeUri();
	}

	private Resource write(Object bean, Resource subject, boolean shallow) {
		cycle.add(bean);
		for (ValuesContext p : TypeWrapper.valueContexts(bean))
			if (!(shallow && p.type().equals(Collection.class)) || forceDeep)
				saveOrUpdate(subject, p);
		return subject;
	}

	private void saveOrUpdate(Resource subject, ValuesContext pc) {
		Object o = pc.invokeGetter();
		Property property = toRdfProperty(pc);
		if (o instanceof Collection)
			updateCollection(subject, property, (Collection<?>) o);
		else if (isPrimitive(o.getClass()))
			new UpdateSaver(subject, property).write(o);
		else if (pc.isArray())
			updateArray(getSeq(subject, property), o);
		else if (isNormalObject(o))
			updateOrCreate(subject, property, o);
	}

	private void updateArray(Seq s, Object array) {
		int len = Array.getLength(array);
		for (int i=0; i<len; i++) {
			if (i >= s.size()) s.add(true);
			s.set(i+1, toNode(Array.get(array, i)));
		}		
	}
	
	private RDFNode toNode(Object o) {
		return (isPrimitive(o)) ? toLiteral(o):_write(o,true);
	}

	private Literal toLiteral(Object o) {	
		if (o instanceof String)
			return m.createTypedLiteral(o.toString());
		else if (o instanceof Date) {
			Calendar c = Calendar.getInstance();
			c.setTime((Date)o);
			return m.createTypedLiteral(c);
		}
		else if (o instanceof Integer)
			return m.createTypedLiteral(((Integer) o).intValue());
		else if (o instanceof Long)
			return m.createTypedLiteral(((Long) o).longValue());
		else if (o instanceof Float)
			return m.createTypedLiteral(((Float) o).floatValue());
		else if (o instanceof Double)
			return m.createTypedLiteral(((Double) o).doubleValue());
		else if (o instanceof Character)
			return m.createTypedLiteral(((Character) o).charValue());
		else if (o instanceof Boolean)
			return m.createTypedLiteral(((Boolean) o).booleanValue());
		else if (o instanceof Calendar)
			return m.createTypedLiteral((Calendar) o);
		else if (o instanceof BigDecimal)
			return m.createTypedLiteral((BigDecimal)o);
		else if (o instanceof BigInteger)
			return m.createTypedLiteral((BigInteger)o);
		return null;
	}

	private Seq getSeq(Resource subject, Property property) {
		Statement s = subject.getProperty(property);
		if (s != null) 
			return s.getSeq();
		Seq seq = m.createSeq();
		subject.addProperty(property, seq);
		return seq;
	}

	private boolean isNormalObject(Object o) {
		return !o.getClass().isArray() && !(o instanceof Collection);
	}

	/**
	 * update a one to many property.
	 * 
	 * @param subject
	 * @param property
	 * @param c
	 */
	private void updateCollection(Resource subject, Property property,
			Collection<?> c) {
		if (supportsDelete(c))
			subject.removeAll(property);
		AddSaver saver = new AddSaver(subject, property);
		for (Object o : c)
			if (isPrimitive(o))
				saver.write(o); // leaf
			else
				subject.addProperty(property, _write(o, true)); // recursive
	}

	private boolean supportsDelete(Collection<?> c) {
		return !(c instanceof AddOnlyArrayList);
	}

	/**
	 * Update or persist a domain object outside String, Date, and the usual
	 * primitive types. We set the write style to shallow=true, causing an end
	 * of recursive traversal of the object graph.
	 * 
	 * @param subject
	 * @param property
	 * @param o
	 */
	private void updateOrCreate(Resource subject, Property property, Object o) {
		Statement existingRelation = subject.getProperty(property);
		if (existingRelation != null)
			subject.removeAll(property);
		subject.addProperty(property, _write(o, true));
	}
}
/*
 * Copyright (c) 2007
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */