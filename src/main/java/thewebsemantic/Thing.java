package thewebsemantic;

import static thewebsemantic.PrimitiveWrapper.isPrimitive;
import static thewebsemantic.TypeWrapper.wrap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

import thewebsemantic.Base.NullType;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class Thing implements InvocationHandler, As {
	private Model model;
	private Resource r;
	private static Method as;
	
	static {
		try {
			as = As.class.getMethod("as", Class.class);
		} catch (Exception e) {}
	}
	
	public Thing(Resource resource, Model m) {
		model = m;
		r = resource;
	}
	
	public Thing(String resource, Model m) {
		this(m.getResource(resource),m);
	}
	
	public Resource getResource()  {
		return r;
	}
	
	public <T> T as(Class<T> c) {
		return (T)Proxy.newProxyInstance(c.getClassLoader(), new Class[] {c}, this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Class<?> returnType = method.getReturnType();
		if (method.equals(as))
			return as((Class)args[0]);		
		else if (method.getParameterTypes().length == 0)
			return get(method);
		else if (method.isAnnotationPresent(Functional.class)) {
			set(method, args[0]);
			return proxy;
		}
		add(method, args[0]);
		return proxy;
	}

	private Object get(Method m) {
		String methodName = m.getName();
		Class<?> genericType = Object.class;
		if (m.getGenericReturnType() instanceof ParameterizedType )
			genericType = getGenericType((ParameterizedType)m.getGenericReturnType());
		Class<?> returnType = m.getReturnType();
		Class<?> c = m.getDeclaringClass();
        String ns = wrap(c).namespace();
		Property p = model.getProperty(ns + methodName);
		StmtIterator it = r.listProperties(p);
		if (isPrimitive(returnType))
			return JenaHelper.convertLiteral(it.nextStatement().getLiteral(), returnType);
		if (returnType.equals(Collection.class) && isPrimitive(genericType))
			return collection(it);
		if (returnType.equals(Collection.class) && genericType.equals(Thing.class))
			return thingCollection(it);
		return null;
	}
	
	private Object thingCollection(StmtIterator it) {
		ArrayList<Object> list = new ArrayList<Object>();
		while (it.hasNext()) {
			Statement s = it.nextStatement();
			if (! s.getObject().isLiteral())
				list.add(new Thing(s.getResource(), s.getModel()));
		}
		return list;
	}

	public Class<?> getGenericType(ParameterizedType type) {
		return (type == null) ? NullType.class : (Class<?>) type
				.getActualTypeArguments()[0];		
	}

	private Object collection(StmtIterator it) {
		ArrayList<Object> list = new ArrayList<Object>();
		while (it.hasNext()) {
			Statement s = it.nextStatement();
			if (s.getObject().isLiteral())
				list.add(s.getLiteral().getValue());
		}
		return list;
	}

	private void set(Method m, Object arg) {
		String methodName = m.getName();
		Class<?> c = m.getDeclaringClass();
        String ns = wrap(c).namespace();
		Property p = model.getProperty(ns + methodName);

		if ( PrimitiveWrapper.isPrimitive(arg))
			r.removeAll(p).addProperty(p, JenaHelper.toLiteral(model, arg));
		else if (arg instanceof Thing)
			set(p, (Thing)arg);
	}

	private void add(Method m, Object arg) {
		String methodName = m.getName();
		Class<?> c = m.getDeclaringClass();
        String ns = wrap(c).namespace();
		Property p = model.getProperty(ns + methodName);
		
		if ( PrimitiveWrapper.isPrimitive(arg))
			r.addProperty(p, JenaHelper.toLiteral(model, arg));
		else if (arg instanceof Thing)
			add(p, (Thing)arg);
	}
	
	private void add(Property p, Thing arg) {
		r.addProperty(p, arg.getResource());		
	}
	
	private void set(Property p, Thing arg) {
		set(p, arg.getResource());
	}
	
	private void set(Property p, Resource r) {
		model.removeAll(r, p, null);
		r.addProperty(p, r);		
	}
}
