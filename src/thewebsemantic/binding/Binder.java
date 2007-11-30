package thewebsemantic.binding;

import java.util.HashMap;

import com.hp.hpl.jena.ontology.OntClass;

public class Binder {
	
	private HashMap<Class<?>, OntClass> bindings;
	private static Binder myself;
	
	public static synchronized Binder instance() {
		if ( myself == null)
			myself = new Binder();
		return myself;
	}
	private Binder() {
		bindings = new HashMap<Class<?>, OntClass>();
	}
	
	public Binding bind(OntClass oc) {
		return new Binding(this,oc);
	}

	protected void save(Class<?> javaClass, OntClass ontClass) {
		bindings.put(javaClass, ontClass);		
	}
	
	public boolean isBound(Class<?> c) {
		return bindings.containsKey(c);
	}
	
	public String getUri(Class<?> c) {
		if (bindings.containsKey(c))
			return bindings.get(c).getURI();
		else
			return null;
	}
}
