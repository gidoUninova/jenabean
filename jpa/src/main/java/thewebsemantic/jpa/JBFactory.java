package thewebsemantic.jpa;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import javax.persistence.Embedded;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedNativeQuery;

import thewebsemantic.AnnotationHelper;
import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;
import thewebsemantic.ValuesContext;
import thewebsemantic.binding.Persistable;

import com.hp.hpl.jena.rdf.model.Model;

public class JBFactory implements EntityManagerFactory, AnnotationHelper, MethodHandler {

	private Model _model;
	private HashMap<String, NamedNativeQuery> _queries;
	private boolean isOpen;
	private RDF2Bean reader; 
	private Bean2RDF writer;

	public JBFactory(Model m, HashMap<String, NamedNativeQuery> queries) {
		_model = m;
		reader = new RDF2Bean(_model, this);
		writer = new Bean2RDF(_model);
		_queries = queries;
		isOpen = !_model.isClosed();
	}

	public void close() {
		_model = null;
		_queries = null;
		isOpen = false;
	}

	public EntityManager createEntityManager() {
		if (!isOpen)
			throw new IllegalStateException("The factory is closed.");
		return new JBEntityManager(_model, _queries, writer, reader);
	}

	public EntityManager createEntityManager(Map arg0) {
		return createEntityManager();
	}

	public boolean isOpen() {
		return isOpen && !_model.isClosed();
	}

	public Model getModel() {
		return _model;
	}

	public boolean isGenerated(ValuesContext ctx) {
		return ctx.getAccessibleObject().isAnnotationPresent(GeneratedValue.class);
	}

	public boolean isEmbedded(Object bean) {
		AnnotatedElement ao = bean.getClass();
		return ao.isAnnotationPresent(Embedded.class);
	}

	@Override
	public Class getProxy(Class c) throws InstantiationException, IllegalAccessException {
		ProxyFactory f = new ProxyFactory();
		f.setInterfaces(new Class[] {Persistable.class});
		f.setHandler(this);
		f.setSuperclass(c);
		return f.createClass();
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3)
			throws Throwable {

		return arg2.invoke(arg0, arg3);
	}

	@Override
	public boolean proxyRequired() {
		return true;
	}
}
