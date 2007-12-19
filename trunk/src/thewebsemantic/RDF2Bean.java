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
import java.util.HashSet;
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
 * 
 * @see Bean2RDF
 */
public class RDF2Bean extends Base {
	private HashMap<String, Object> cycle;

	private boolean shallow = false;
	private Set<String> myIncludes = new HashSet<String>();
	private static final String[] none = new String[0];
	
	public RDF2Bean(OntModel m) {
		super(m);
	}

	public <T> Collection<T> loadDeep(Class<T> c) {
		return load(c, false, none);
	}

	public <T> Collection<T> load(Class<T> c) {
		return load(c, true, none);
	}

	public <T> Collection<T> load(Class<T> c, String[] includes) {
		return load(c, true, includes);
	}
	
	/**
	 * load all rdf entries that map to the bean.
	 * 
	 * @param <T>
	 * @param c
	 * @return
	 */
	public synchronized <T> Collection<T> load(Class<T> c, boolean shallow, String[] includes) {
		init(shallow, includes);
		cycle = new HashMap<String, Object>();
		try {
			return loadAll(c, new LinkedList<T>());
		} finally {
			m.leaveCriticalSection();
		}
	}

	private void init(boolean shallow, String[] includes) {
		m.enterCriticalSection(Lock.READ);
		this.shallow = shallow;
		this.myIncludes.clear();
		for (String s : includes) myIncludes.add(s);
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
	
	public <T> T load(Class<T> c, String id, String[] includes) throws NotFoundException {
		return load(c, id, true, includes);
	}
	
	public <T> T load(Class<T> c, int id) throws NotFoundException {
		return load(c, Integer.toString(id), true);
	}

	public <T> T load(Class<T> c, String id, boolean shallow) throws NotFoundException {
		return load(c,id,shallow, new String[0]);
	}
	
	private synchronized <T> T load(Class<T> c, String id, boolean shallow, String[] includes)
			throws NotFoundException {
		init(shallow, includes);
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

	public synchronized Object load(Object target)
			throws NotFoundException {
		init(shallow, none);
		cycle = new HashMap<String, Object>();
		try {
			Individual source = m.getIndividual(instanceURI(target));
			if (source == null)
				throw new NotFoundException();
			return applyProperties(source, target);
		} finally {
			m.leaveCriticalSection();
		}
	}

	public Filler fill(Object o) {
		return new Filler(this, o);
	}

	public synchronized void fill(Object o, String propertyName) {
		init(shallow, none);
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
		return (i!=null)?(T)testCycle(i):null;
	}

	private Object testCycle(Individual i) {
		return (isCycle(i))?cycle.get(i.getURI()):applyProperties(i);
	}

	private <T> T toObject(Class<T> c, RDFNode node) {
		return (node.isLiteral()) ? 
				(T) asLiteral(node).getValue() : 
				toObject(c, asIndividual(node));
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
		if (p != null) apply(ctx, i.listPropertyValues(p));
	}

	private void fill(Individual i, PropertyContext ctx) {
		Property p = m.getOntProperty(ctx.uri());
		if (p != null)
			ctx.setProperty(fillCollection(t(ctx.property), i.listPropertyValues(p)
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
		if (shallow && !included(ctx.property))
			ctx.setProperty(addOnlyCollection());
		else
			ctx.setProperty(fillCollection(t(ctx.property), nodes));
	}

	private boolean included(PropertyDescriptor property) {
		return myIncludes.contains(property.getName());
	}

	private Collection<Object> addOnlyCollection() {
		return new AddOnlyArrayList<Object>();
	}

	private ArrayList<Object> fillCollection(Class<?> c, Set<RDFNode> nodes) {
		ArrayList<Object> results = new ArrayList<Object>();
		for (RDFNode node : nodes)
			results.add(toObject(c, node));
		return results;
	}

	private void applyIndividual(PropertyContext ctx, Individual i) {
		ctx.setProperty(toObject(ctx.property, i));
	}

	private void applyLiteral(PropertyContext ctx, Literal l) {
		if (ctx.isDate()) ctx.setProperty(date(l));
		else ctx.setProperty(l.getValue());
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
 */