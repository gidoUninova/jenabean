package thewebsemantic.binding;

import java.util.HashMap;

import com.hp.hpl.jena.ontology.OntClass;

public class Binder {
	
	private HashMap<Class<?>, String> class2url;
	private HashMap<String, Class<?>> url2class;

	private static Binder myself = new Binder();
	
	public static synchronized Binder instance() {
		return myself;
	}

	private Binder() {
		class2url = new HashMap<Class<?>, String>();
		url2class = new HashMap<String, Class<?>>();
	}
	
	public Binding bind(OntClass oc) {
		return new Binding(this,oc);
	}

	protected void save(Class<?> javaClass, OntClass ontClass) {
		class2url.put(javaClass, ontClass.getURI());
		url2class.put(ontClass.getURI(), javaClass);
	}
	
	public boolean isBound(Class<?> c) {
		return class2url.containsKey(c);
	}
	
	public boolean isBound(OntClass c) {
		return url2class.containsKey(c.getURI());
	}
	
	public String getUri(Class<?> c) {
		if (class2url.containsKey(c))
			return class2url.get(c);
		else
			return null;
	}
	
	public String getUri(Object bean) {
		return getUri(bean.getClass());
	}
	
	public Class<?> getClass(String uri) {
		if (url2class.containsKey(uri))
			return url2class.get(uri);
		else
			return null;		
	}
}
