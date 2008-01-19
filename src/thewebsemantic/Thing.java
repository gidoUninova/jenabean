package thewebsemantic;

import static thewebsemantic.TypeWrapper.wrap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public class Thing implements InvocationHandler{
	private String id;
	private Model model;
	private Resource r;
	
	public Thing(String uri, Model m) {
		id = uri;
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

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (args.length > 0)
			return set(method, args[0]);
		else
			return get(method);
	}

	private Object get(Method method) {
		return null;
	}

	private Object set(Method thmethodod, Object arg) {
		Class<?> c = thmethodod.getDeclaringClass();
        String ns = wrap(c).namespace();
		Property p = model.getProperty(ns + thmethodod.getName());
		
		if ( PrimitiveWrapper.isPrimitive(arg))
			new UpdateSaver(r,p).write(arg);
		else if (arg instanceof Thing)
			set(p, (Thing)arg);
		return null;
	}

	private void set(Property p, Thing arg) {
		r.addProperty(p, arg.getResource());
		
	}
}
