package thewebsemantic;

import static thewebsemantic.JenaHelper.asIndividual;
import static thewebsemantic.JenaHelper.asLiteral;
import static thewebsemantic.JenaHelper.date;
import static thewebsemantic.JenaHelper.listAllIndividuals;
import static thewebsemantic.TypeWrapper.*;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
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

	private boolean shallow = false;

	public RDF2Bean(OntModel m) {
		super(m);
	}

	public <T> Collection<T> loadDeep(Class<T> c) {
		return load(c, false);
	}

	public <T> Collection<T> load(Class<T> c) {
		return load(c, true);
	}

	/**
	 * load all rdf entries that map to the bean.
	 * 
	 * @param <T>
	 * @param c
	 * @return
	 */
	public synchronized <T> Collection<T> load(Class<T> c, boolean shallow) {
		m.enterCriticalSection(Lock.READ);
		this.shallow = shallow;
		cycle = new HashMap<String, Object>();
		try {
			return loadAll(c, new LinkedList<T>());
		} finally {
			m.leaveCriticalSection();
		}
	}

	private <T> Collection<T> loadAll(Class<T> c, LinkedList<T> list) {
		for (Individual i : listAllIndividuals(getOntClass(c)))
			list.add(toObject(c, i));
		return list;
	}

	/**
	 * 
	 * @param c
	 *            java class of the bean
	 * @param id
	 *            unique id of the bean to find
	 * @return An instance of T, otherwise null
	 */
	public <T> T loadDeep(Class<T> c, int id) throws NotFoundException {
		return load(c, Integer.toString(id), false);
	}

	public <T> T loadDeep(Class<T> c, String id) throws NotFoundException {
		return load(c, id, false);
	}

	public <T> T load(Class<T> c, String id) throws NotFoundException {
		return load(c, id, true);
	}

	public <T> T load(Class<T> c, int id) throws NotFoundException {
		return load(c, Integer.toString(id), true);
	}

	public synchronized <T> T load(Class<T> c, String id, boolean shallow)
			throws NotFoundException {
		m.enterCriticalSection(Lock.READ);
		this.shallow = shallow;
		cycle = new HashMap<String, Object>();
		try {
			T result = toObject(c, id);
			if (result != null)
				return result;
			throw new NotFoundException();
		} finally {
			m.leaveCriticalSection();
		}
	}

	public synchronized <T> T load(Object target)
			throws NotFoundException {
		m.enterCriticalSection(Lock.READ);
		this.shallow = true;
		cycle = new HashMap<String, Object>();
		try {
			Individual source = m.getIndividual(instanceURI(target));
			if (source == null)
				throw new NotFoundException();
			T result = (T)applyProperties(source, target);
			return result;
		} finally {
			m.leaveCriticalSection();
		}
	}

	public Filler fill(Object o) {
		return new Filler(this, o);
	}

	public synchronized void fill(Object o, String propertyName) {
		m.enterCriticalSection(Lock.READ);
		this.shallow = true;
		try {
			fillWithChildren(o, propertyName);
		} finally {
			m.leaveCriticalSection();
		}
	}

	public boolean exists(Class<?> c, String id) {
		return !(m.getIndividual(wrap(c).uri(id)) == null);
	}

	private <T> T toObject(Class<T> c, String id) {
		return (wrap(c).uriSupport()) ? 
				toObject(c, m.getIndividual(id)): 
				toObject(c, m.getIndividual(wrap(c).uri(id)));
	}

	private <T> T toObject(Class<T> c, Individual i) {
		if (i != null)
			return (isCycle(i)) ? (T) cycle.get(i.getURI())
					: (T) applyProperties(i);
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

	private Object fillWithChildren(Object target, String propertyName) {
		Individual source = m.getIndividual(instanceURI(target));
		for (PropertyDescriptor p : type(target).descriptors())
			if (p.getName().equals(propertyName)
					&& p.getPropertyType().equals(Collection.class))
				fill(source, new PropertyContext(target, p));
		return target;
	}

	private Object applyProperties(Individual source) {
		return applyProperties(source, newInstance(source));
	}

	private Object applyProperties(Individual source, Object target) {
		cycle.put(source.getURI(), target);
		for (PropertyDescriptor p : type(target).descriptors())
			apply(source, new PropertyContext(target, p));
		return target;
	}

	private Object newInstance(Individual source) {
		try {
			return wrap(javaclass(source)).toBean(source);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Given an Individual, return the appropriate class. This could have been
	 * stored as an annotation if jenabean was involved in writing the
	 * individual. If not we'll use the binder.
	 * 
	 * @param source
	 * @return
	 * @throws ClassNotFoundException
	 */
	private Class<?> javaclass(Individual source) throws ClassNotFoundException {
		OntClass oc = (OntClass) source.getRDFType().as(OntClass.class);
		RDFNode node = oc.getPropertyValue(javaclass);
		return (node != null) ?
			Class.forName(asLiteral(node).getString()):
			binder.getClass(oc.getURI());
	}

	private OntClass getOntClass(Class<?> c) {
		return (binder.isBound(c)) ?
			m.getOntClass(binder.getUri(c)):
			m.getOntClass(wrap(c).typeUri());
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
	private void apply(Individual i, PropertyContext ctx) {
		Property p = m.getOntProperty(ctx.uri());
		if (p != null)
			apply(ctx, i.listPropertyValues(p));
	}

	private void fill(Individual i, PropertyContext ctx) {
		Property p = m.getOntProperty(ctx.uri());
		if (p != null)
			ctx.invoke(fillCollection(t(ctx.property), i.listPropertyValues(p)
					.toSet()));
	}

	private void apply(PropertyContext ctx, NodeIterator nodes) {
		if (nodes == null)
			return;
		else if (ctx.isCollection())
			collection(ctx, nodes.toSet());
		else if (!nodes.hasNext())
			return;
		else if (ctx.isPrimitive())
			applyLiteral(ctx, asLiteral(nodes.nextNode()));
		else
			applyIndividual(ctx, asIndividual(nodes.nextNode()));
	}

	private void collection(PropertyContext ctx, Set<RDFNode> nodes) {
		if (shallow)
			ctx.invoke(newCollection());
		else
			ctx.invoke(fillCollection(t(ctx.property), nodes));
	}

	private ArrayList<Object> newCollection() {
		return new ArrayList<Object>();
	}

	private ArrayList<Object> fillCollection(Class<?> c, Set<RDFNode> nodes) {
		ArrayList<Object> results = newCollection();
		for (RDFNode node : nodes)
			results.add(toObject(c, node));
		return results;
	}

	private void applyIndividual(PropertyContext ctx, Individual i) {
		ctx.invoke(toObject(ctx.property, i));
	}

	private void applyLiteral(PropertyContext ctx, Literal l) {
		if (ctx.isDate()) ctx.invoke(date(l));
		else ctx.invoke(l.getValue());
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