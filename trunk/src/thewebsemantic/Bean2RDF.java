package thewebsemantic;

import static thewebsemantic.PrimitiveWrapper.isPrimitive;
import static thewebsemantic.TypeWrapper.instanceURI;
import static thewebsemantic.TypeWrapper.type;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.shared.Lock;

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
 * @author Taylor Cowan
 * @see Namespace
 * @see Id
 * @see RdfProperty
 */
public class Bean2RDF extends Base {
	private ArrayList<Object> cycle;
	private boolean forceDeep = false;

	private Logger logger = Logger.getLogger("thewebsemenatic",
			"thewebsemantic.messages");

	public Bean2RDF(OntModel m) {
		super(m);
	}

	public Resource write(Object bean) {
		return write(bean, false);
	}
	
	public Resource writeDeep(Object bean) {
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
		return (cycle.contains(bean)) ? existing(bean) : write(bean,
				toResource(bean), shallow);
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

	private OntClass ontClass(Object bean) {
		return m.createClass(getURI(bean));
	}

	private String getURI(Object bean) {
		return (isBound(bean)) ? binder.getUri(bean) : type(bean).typeUri();
	}

	private Resource write(Object bean, RDFNode node, boolean shallow) {
		return write(bean, (Resource) node.as(Resource.class), shallow);
	}

	private Resource write(Object bean, Resource subject, boolean shallow) {
		try {
			cycle.add(bean);
			for (PropertyDescriptor p : type(bean).descriptors())
				if (!(shallow && p.getPropertyType().equals(Collection.class)) || forceDeep)
					saveOrUpdate(subject, new PropertyContext(bean, p));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subject;
	}

	private void saveOrUpdate(Resource subject, PropertyContext pc) {
		Object o = pc.invokeGetter();
		Property property = toRdfProperty(pc);
		if (o instanceof Collection)
			updateCollection(subject, property, (Collection<?>) o);
		else if (isPrimitive(o.getClass()))
			getSaver(subject, property).write(o);
		else if (!o.getClass().isArray())
			updateOrCreate(subject, property, o);
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
		subject.removeAll(property);
		AddSaver saver = new AddSaver(subject, property);
		for (Object o : c)
			if (isPrimitive(o))
				saver.write(o); // leaf
			else
				subject.addProperty(property, _write(o, true)); // recursive
	}

	/**
	 * To simplify the type switch above, return a specialized helper either for
	 * updating an existing relation, or adding a new relation, depending on the
	 * existence of property on resource s.
	 * 
	 * @param s
	 * @param property
	 * @return appropriate saver implementation
	 */
	private Saver getSaver(Resource s, Property property) {
		return (s.getProperty(property) == null) ? new CreateSaver(s, property)
				: new UpdateSaver(s, property);
	}

	/**
	 * Update or persist a domain object outside String, Date, and the usual
	 * primitive types.  We set the write style to shallow=true,
	 * causing an end of recursive traversal of the object graph.
	 * 
	 * @param subject
	 * @param property
	 * @param o
	 */
	private void updateOrCreate(Resource subject, Property property, Object o) {
		Statement existingRelation = subject.getProperty(property);
		if (existingRelation != null)
			write(o, existingRelation.getObject(), true);
		else
			subject.addProperty(property, _write(o, true));
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
 * 
 */