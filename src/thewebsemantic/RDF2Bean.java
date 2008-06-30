package thewebsemantic;

import static com.hp.hpl.jena.graph.Node.ANY;
import static com.hp.hpl.jena.graph.Node.createURI;
import static thewebsemantic.JenaHelper.convertLiteral;
import static thewebsemantic.TypeWrapper.instanceURI;
import static thewebsemantic.TypeWrapper.wrap;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Seq;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.shared.Lock;
import com.hp.hpl.jena.vocabulary.RDF;

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
	private Map<String, Class> bindingsCache = new HashMap<String, Class>();
	private static final String[] none = new String[0];

	/**
	 * Constructs and instance of RDF2Bean bound to a particular ontology model.
	 * Operations have potential to modify the model.
	 * @param model a Jena Ontology Model instance
	 */
	public RDF2Bean(Model model) {
		super(model); 
	}

	/**
	 * Deeply loads all individuals having RDF type which matches Class <tt>c</tt>.
	 * Depending on the density of your model this method has the potential to load
	 * the entire graph into memory as Java beans.  For example, if you been has a
	 * <tt>hasFriends</tt> property, <tt>loadDeep()</tt> will load each friend, 
	 * each friend's friends, and so on.  Every reachable property that maps to a 
	 * corresponing bean property will be loaded recursively.
	 * 
	 * @param <T>
	 * @param c a java class which maps to individuals in your ontology.
	 * @return collection of java beans, all instances of Class <tt>c</tt>.
	 */
	public <T> Collection<T> loadDeep(Class<T> c) {
		return load(c, false, none);
	}

	
	/**
	 * Loads all individuals having RDF type which maps to Class <tt>c</tt>.
	 * Mappings are either based on Class annotations or bindings given at VM startup.
	 * <tt>load()</tt> is safe for dense graphs as it has a conservative or shallow 
	 * policy.  It loads all functional properties (where there is only one) but ignores
	 * bean properties of type <tt>Collection</tt>.  All returned bean's Collection
	 * properties are initialized to size 0.  
	 * 
	 * Once loaded you may add to Collection properties and save. This will result in addition
	 * assertions being made in your jena ontology model, however, saving will not delete 
	 * assertions unless the property is fully loaded.  Consider the common customer/order 
	 * scenario.  We can load a customer, and fill the orders, leaving other properties alone:
	 * 
	 * <code>
	 * Collection<Customer> customers = myRDF2Bean.load(Customer.class)
	 * ...
	 * myRDF2Bean.fill(aCustomer).with("orders");
	 * foreach(Order o: aCustomer.getOrders())...
	 * </code>
	 * 
	 * You may also use this alternate method to fill collection properties:
	 * 
	 * <code>
	 * myRDF2Bean.fill(aCustomer, "orders");
	 * </code>
	 * 
	 * @see binding.Jenabean
	 * @see Namespace
	 * @param <T>
	 * @param c
	 * @return
	 */
	public <T> Collection<T> load(Class<T> c) {
		return load(c, true, none);
	}

	
	/**
	 * Similar to <tt>load(Class<T> c)</tt> except that you may include an array 
	 * of property names to "include".  The properties should be of type Collection.
	 * This allows you to be specific about wich children you want unmarshalled from
	 * the ontology model into java objects.  For instance, you may just need a customer,
	 * their outstanding orders, and their recent addresses.  Assuming your ontology relates 
	 * customers to many more non-functional properties, it'd save time to just load exacly
	 * what you need.
	 * 
	 * @param <T>
	 * @param c
	 * @param includes
	 * @return
	 */
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
	protected synchronized <T> Collection<T> load(Class<T> c, boolean shallow,
			String[] includes) {
		init(shallow, includes);
		try {
			return loadAll(c);
		} finally {
			m.leaveCriticalSection();
		}
	}

	private void init(boolean shallow, String[] includes) {
		cycle = new HashMap<String, Object>();
		m.enterCriticalSection(Lock.READ);
		this.shallow = shallow;
		this.myIncludes.clear();
		for (String s:includes) myIncludes.add(s);
	}

	private <T> Collection<T> loadAll(Class<T> c) {
		Resource a = rdfType(c);
		return loadIndividuals(c, m.listSubjectsWithProperty(RDF.type, a));
	}

	private <T> Collection<T> loadIndividuals(Class<T> c, ResIterator it) {
		Collection<T> list =  new LinkedList<T>();
		while(it.hasNext()) list.add(toObject(c, it.nextResource()));
		it.close();
		return list;
	}

	/**
	 * <tt>loadDeep</tt> will load a particular individual and all it's properties,
	 * recursively.  <em>Beware</em>, this could result in loading the entire 
	 * model into memory 
	 * as java objects depending on the density of your graph.  Therefore
	 * use this method with care knowing that it's purpose is to load all
	 * information reachable via properties that bind to your objects.
	 * 
	 * @param c
	 *            java class of the bean.  The class is converted to a URI
	 *            based on its annotations or bindings.
	 * @param id
	 *            unique id of the bean to find
	 * @return An instance of T, otherwise null
	 * @see binding.Jenabean
	 * @see Namespace
	 */
	public <T> T loadDeep(Class<T> c, int id) throws NotFoundException {
		return load(c, Integer.toString(id), false);
	}

	/**
	 * Same as loadDeep(Class, String) overloaded for id's of type integer.
	 * 
	 * @param c
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	public <T> T loadDeep(Class<T> c, String id) throws NotFoundException {
		return load(c, id, false);
	}

	/**
	 * Loads an ontology individual as a java bean, based on annotations
	 * or bindings applied to Class <tt>c</tt>.
	 * 
	 * @param <T>
	 * @param c
	 * @param id
	 * @return instance of Class<tt>c</tt> matching <tt>id</tt> from model, if
	 * one exists.
	 * @throws NotFoundException
	 */
	public <T> T load(Class<T> c, String id) throws NotFoundException {
		return load(c, id, true);
	}

	/**
	 * Similar to load(Class, String), with the ability to include
	 * non-functional Collection based properties.  <tt>includes</tt> should be
	 * an array of property names, for example, if you want to load a customer with 
	 * their orders and  recent purchases...
	 * 
	 * <code>
	 * RDF2Bean reader = new RDF2Bean(model);
	 * String[] includes = {"orders","recentPurchases"};
	 * reader.load(Customer.class, "cust#2", includes);
	 * </code>
	 * 
	 * @param <T>
	 * @param c
	 * @param id
	 * @param includes
	 * @return
	 * @throws NotFoundException
	 */
	public <T> T load(Class<T> c, String id, String[] includes)
			throws NotFoundException {
		return load(c, id, true, includes);
	}

	/**
	 * same as <tt>load(String)</tt> overloaded for id's of type integer.
	 * @param <T>
	 * @param c
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	public <T> T load(Class<T> c, int id) throws NotFoundException {
		return load(c, Integer.toString(id), true);
	}
	
	public <T> T load(Class<T> c, Resource r) {
		return load(c, r, true, new String[0]);
	}

	protected <T> T load(Class<T> c, String id, boolean shallow)
			throws NotFoundException {
		return load(c, id, shallow, new String[0]);
	}

	private synchronized <T> T load(Class<T> c, String id, boolean shallow,
			String[] includes) throws NotFoundException {
		init(shallow, includes);
		try {
			T result = toObject(c, id);
			if (result != null)
				return result;
			throw new NotFoundException();
		} finally {
			m.leaveCriticalSection();
		}
	}

	private synchronized <T> T load(Class<T> c, Resource r, boolean shallow,
			String[] includes) {
		init(shallow, includes);
		try {
			return (T)toObject(c, r);
		} finally {
			m.leaveCriticalSection();
		}
	}	
	
	/**
	 * Loads an object from model with the same identifier as <tt>target</tt>.
	 * 
	 * @param target
	 * @return
	 * @throws NotFoundException
	 */
	public synchronized Object load(Object target) {
		init(shallow, none);
		try {
			Resource source = m.getResource(instanceURI(target));
			return applyProperties(source, target);
		} finally {
			m.leaveCriticalSection();
		}
	}

	/**
	 * returns true if target exists in the model
	 * 
	 * @param target
	 * @return
	 * @throws NotFoundException
	 */
	public synchronized boolean exists(Object target) {
		init(shallow, none);
		try {
			return exists(instanceURI(target));
		} finally {
			m.leaveCriticalSection();
		}
	}
	
	/**
	 * Returns a <tt>Filler</tt> for this bean.  When beans are loaded
	 * they are normally shallow, ie, their Collections are still empty.
	 * This allows the client to decide which lists (sometimes large) they'd
	 * like to work with.
	 * 
	 * This provides a certain type 
	 * of calling style:
	 * 
	 * <code>
	 * RDF2Bean rdf2bean = new RDF2Bean(model);
	 * ...
	 * rdf2bean.fill(myBean).with("children");
	 * </code>
	 * 
	 * @param o
	 * @return
	 */
	public Filler fill(Object o) {
		return new Filler(this, o);
	}

	/**
	 * fill or reload a non-functional property with values from the model.
	 * This is usefull when you've recently shallow loaded a bean from the 
	 * triple store.  non-funtional properties can contain unlimited 
	 * elements, so your app will need to be carefull regarding when it loads
	 * them.
	 * 
	 * in Jenabean, non-functional properties are represented as properties
	 * of type java.util.Collection.
	 * 
  	 * <code>
	 * RDF2Bean rdf2bean = new RDF2Bean(model);
	 * ...
	 * rdf2bean.fill(myBean,"children");
	 * </code>
	 * @param o
	 * @param propertyName
	 */
	public synchronized void fill(Object o, String propertyName) {
		init(shallow, none);
		try {
			fillWithChildren(o, propertyName);
		} finally {
			m.leaveCriticalSection();
		}
	}

	/**
	 * returns true if matching individual is found in the model.
	 * @param c
	 * @param id
	 * @return
	 */
	public boolean exists(Class<?> c, String id) {
		return exists(wrap(c).uri(id));
	}

	public boolean exists(String uri) {
		return m.getGraph().contains(createURI(uri),ANY,ANY);
	}
	
	private <T> T toObject(Class<T> c, String id) {
		return (!exists(c,id)) ? null :
			toObject(c, m.getResource(wrap(c).uri(id)));
	}

	public Object load(String uri) throws NotFoundException {
		init(shallow, none);
		try {
			if (exists(uri))
				return toObject(Object.class, m.getResource(uri));
			else
				throw new NotFoundException();
		} finally {
			m.leaveCriticalSection();
		}
	}

	private <T> T toObject(Class<T> c, Resource i) {
		return (i != null) ? (T) testCycle(i,c) : null;
	}

	private Object testCycle(Resource i, Class<?> c) {
		return (isCycle(i)) ? cachedObject(i) : applyProperties(i,c);
	}

	private Object cachedObject(Resource i) {
		return cycle.get(key(i));
	}

	private <T> T toObject(Class<T> c, RDFNode node) {
		return (node.isLiteral()) ? (T)convertLiteral(node,c): 
			toObject(c, (Resource)node.as(Resource.class));
	}

	private boolean isCycle(Resource i) {
		return cycle.containsKey(key(i));
	}

	private String key(Resource i) {
		return ( i.isAnon() ) ?
			i.getId().toString() : i.getURI();
	}
	
	private Object fillWithChildren(Object target, String propertyName) {
		Resource source = m.getResource(instanceURI(target));
		for (ValuesContext p : TypeWrapper.valueContexts(target))
			if (match(propertyName, p))
				fill(source, p);
		return target;
	}

	private boolean match(String propertyName, ValuesContext p) {
		return p.getName().equals(propertyName) &&
			   (p.type().equals(Collection.class) ||
			   p.type().isArray());
	}

	private Object applyProperties(Resource source, Class c) {
		return applyProperties(source, newInstance(source,c));
	}

	private Object applyProperties(Resource source, Object target) {
		cycle.put(source.getURI(), target);
		for (ValuesContext ctx : TypeWrapper.valueContexts(target))
			apply(source, ctx);
		return target;
	}

	private Object newInstance(Resource source, Class c) {
		try {
			return wrap(javaclass(source,c)).toBean(source);
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
	private Class<?> javaclass(Resource source, Class c) throws ClassNotFoundException {
		StmtIterator it = source.listProperties(RDF.type);
		Resource oc=null;
		while(it.hasNext()) {
			oc = (Resource)it.nextStatement().getResource();
			if (!oc.getNameSpace().startsWith("http://www.w3.org"))
				break;
		}
		if ( binder.getClass(oc.getURI()) != null)
			return binder.getClass(oc.getURI());
		else if (bindingsCache.containsKey(oc.getURI()))
			return bindingsCache.get(oc.getURI());
		else if (oc.getProperty(javaclass) != null){
			Statement node = oc.getProperty(javaclass);
			Class<?> klass = Class.forName(node.getLiteral().getString());
			bindingsCache.put(oc.getURI(), klass);
			return klass;
		} 
		return c;
	}

	private Resource rdfType(Class<?> c) {
		return ontClass( (binder.isBound(c)) ? binder.getUri(c) : wrap(c).typeUri() );
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
	private void apply(Resource i, ValuesContext ctx) {
		Property p = m.getProperty(ctx.uri());
		apply(ctx, i.listProperties(p));
	}

	private void fill(Resource i, ValuesContext ctx) {
		Property p = m.getProperty(ctx.uri());
		if (p == null) return;
		StmtIterator values = i.listProperties(p);
		if (ctx.type().isArray()) {
			Seq s = values.nextStatement().getSeq();
			Class<?> type = ctx.type().getComponentType();
			ctx.setProperty( fillArray(type, s) );			
		} else {
			ctx.setProperty( fillCollection(ctx.t(), values));
		}		
	}

	private void apply(ValuesContext ctx, StmtIterator nodes) {
		if (nodes == null)
			return;
		else if (ctx.isCollection())
			collection(ctx, nodes);
		else if (!nodes.hasNext())
			return;
		else if (ctx.isPrimitive())
			applyLiteral(ctx, nodes.nextStatement().getLiteral());
		else if (ctx.isArray())
			array(ctx, nodes.nextStatement().getResource());
		else
			applyIndividual(ctx, nodes.nextStatement().getResource());
	}

	private void array(ValuesContext ctx, RDFNode nextNode) {
		Seq s = (Seq)nextNode.as(Seq.class);
		Class<?> type = ctx.type().getComponentType();
		if (shallow && !included(ctx.getName()))
			ctx.setProperty( Array.newInstance(type, 0));
		else
			ctx.setProperty(fillArray(type, s));
		
	}

	private Object fillArray(Class<?> type, Seq s) {
		Object array = Array.newInstance(type, s.size());
		for (int i=0; i<Array.getLength(array); i++)
			Array.set(array,i,toObject(type, s.getObject(i+1) ));
		return array;
	}
	
	private void collection(ValuesContext ctx, StmtIterator nodes) {
		ctx.setProperty( (shallow && !included(ctx.getName())) ? 
				addOnlyCollection():fillCollection(ctx.t(), nodes));
	}

	private boolean included(String property) {
		return myIncludes.contains(property);
	}

	private Collection<Object> addOnlyCollection() {
		return new AddOnlyArrayList<Object>();
	}

	private ArrayList<Object> fillCollection(Class<?> c, StmtIterator nodes) {
		ArrayList<Object> results = new ArrayList<Object>();
		while(nodes.hasNext())
			results.add(toObject(c,nodes.nextStatement().getObject()));
		return results;
	}

	private void applyIndividual(ValuesContext ctx, Resource i) {
		ctx.setProperty(toObject(ctx.type(), i));
	}

	private void applyLiteral(ValuesContext ctx, Literal l) {
		ctx.setProperty(convertLiteral(l, ctx.type()));
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