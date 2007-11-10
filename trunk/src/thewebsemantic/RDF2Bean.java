package thewebsemantic;

import static thewebsemantic.JenaHelper.*;
import static thewebsemantic.TypeWrapper.ns;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.shared.Lock;

/**
 * RDF2Bean converts one or more RDF nodes into java beans. Normally these are
 * nodes created by the Bean2RDF class. <code>@Namespace</code> annotation value of the Class.
 * @author Taylor Cowan
 * @see Bean2RDF
 */
public class RDF2Bean extends Base {

	private HashMap<String, Object> cycle;

	public RDF2Bean(OntModel m) {
		super(m);
	}

	/**
	 * 
	 * @param c
	 *            java class of the bean
	 * @param id
	 *            unique id of the bean to find
	 * @return An instance of T, otherwise null
	 */
	public <T> T find(Class<T> c, int id) {
		return find(c, Integer.toString(id));
	}

	public synchronized <T> T find(Class<T> c, String id) {
		TypeWrapper type = TypeWrapper.get(c);
		m.enterCriticalSection(Lock.READ);
		cycle = new HashMap<String, Object>();
		T result = (!annotated(c)) ? null : toObject(c, m.getIndividual(type.rdfTypeName()
				+ id));
		m.leaveCriticalSection();
		return result;
	}

	private <T> T toObject(Class<T> c, Individual i) {
		try {
			if (i == null)
				return null;
			return (isCycle(i)) ? (T) cycle.get(i.getURI()):applyProperties(c, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private <T> T toObject(Class<T> c, RDFNode node) {
		return (node.isLiteral()) ? (T) asLiteral(node).getValue() : toObject(
				c, asIndividual(node));
	}
	
	private Object toObject(PropertyDescriptor p, Individual i) {
		return toObject(p.getPropertyType(), i);
	}

	private boolean isCycle(Individual i) {
		return cycle.containsKey(i.getURI());
	}

	private <T> T applyProperties(Class<T> c, Individual source) throws InstantiationException, IllegalAccessException {
		T target = c.newInstance();
		cycle.put(source.getURI(), target);
		for (PropertyDescriptor property : TypeWrapper.get(c).descriptors())
			apply(source, target, property);
		return target;
	}

	public synchronized <T> Collection<T> loadAll(Class<T> c) {
		cycle = new HashMap<String, Object>();
		return (!annotated(c)) ? null : loadAll(c, new LinkedList<T>());
	}

	private <T> Collection<T> loadAll(Class<T> c, LinkedList<T> list) {
		m.enterCriticalSection(Lock.READ);
		for (Individual i : listAllIndividuals(getOntClass(c)))
			list.add(toObject(c, i));
		m.leaveCriticalSection();
		return list;
	}

	private OntClass getOntClass(Class<?> c) {String s = TypeWrapper.get(c).rdfTypeName();
		return m.getOntClass(TypeWrapper.get(c).rdfTypeName());
	}

	/**
	 * Apply a particular property of an Individual (rdf) to a Java Object
	 * 
	 * @param i
	 *            Found individual we are using as a data source
	 * @param o
	 *            raw object ready to receive data from rdf
	 * @param property
	 *            descriptor for property we are applying
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private void apply(Individual i, Object o, PropertyDescriptor property) {
		NodeIterator nodes = i.listPropertyValues(toRdfProperty(o, property));
		if (nodes == null || !nodes.hasNext())
			return;
		if (isCollection(property))
			collection(o, property, nodes);
		else if (annotated(property.getPropertyType()))
			applyIndividual(o, property, asIndividual(nodes.nextNode()));
		else
			applyLiteral(o, property, asLiteral(nodes.nextNode()));
	}

	private void collection(Object o, PropertyDescriptor property,
			NodeIterator nodes) {
		invoke(property, o, fillCollection(t(property), nodes.toSet()));
	}

	private ArrayList<Object> fillCollection(Class<?> c, Set<RDFNode> nodes) {
		ArrayList<Object> results = new ArrayList<Object>();
		for (RDFNode node : nodes)
			results.add(toObject(c, node));
		return results;
	}

	private void applyIndividual(Object o, PropertyDescriptor propDesc,
			Individual i) {
		invoke(propDesc, o, toObject(propDesc, i));
	}

	private void applyLiteral(Object o, PropertyDescriptor propDesc, Literal l) {
		if (propDesc.getPropertyType().equals(Date.class))
			invoke(propDesc, o, date(l));
		else
			invoke(propDesc, o, l.getValue());
	}

	private void invoke(PropertyDescriptor p, Object o, Object v) {
		try {
			p.getWriteMethod().invoke(o, v);
		} catch (Exception e) {
		}
	}
}
/*
 * Copyright (c) 2007 Taylor Cowan
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
 */