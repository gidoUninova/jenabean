package thewebsemantic;

import static thewebsemantic.TypeWrapper.wrap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class Thing implements InvocationHandler, As {
	private Model model;
	private Resource r;
	
	public Thing(String uri, Model m) {
		model = m;
		r = m.getResource(uri);
	}
	
	public Resource getResource()  {
		return r;
	}
	
	public <T> T as(Class<T> c) {
		return (T)Proxy.newProxyInstance(
				c.getClassLoader(), new Class[] {c}, this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Class<?> returnType = method.getReturnType();
		String actionType = method.getName().substring(0,3);
		
		
		if ("set".equals(actionType)) {
			set(method, args[0]);
			return proxy;
		} else
			return get(method);
	}

	private Object get(Method m) {
		String methodName = m.getName().substring(3);
		Class<?> returnType = m.getReturnType();
		Class<?> c = m.getDeclaringClass();
        String ns = wrap(c).namespace();
		Property p = model.getProperty(ns + methodName);
		StmtIterator it = r.listProperties(p);
		return (returnType.isPrimitive()) ? it.nextStatement().getLiteral().getValue() : new Things(it.toSet());
	}

	private void set(Method m, Object arg) {
		String methodName = m.getName().substring(3);
		Class<?> c = m.getDeclaringClass();
        String ns = wrap(c).namespace();
		Property p = model.getProperty(ns + methodName);
		
		if ( PrimitiveWrapper.isPrimitive(arg))
			new UpdateSaver(r,p).write(arg);
		else if (arg instanceof Thing)
			set(p, (Thing)arg);
	}

	private void add(Property p, Thing arg) {
		r.addProperty(p, arg.getResource());		
	}
	
	private void set(Property p, Thing arg) {
		model.removeAll(r, p, null);
		r.addProperty(p, arg.getResource());		
	}
}
