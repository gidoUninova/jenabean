package thewebsemantic.binding;

import java.util.HashMap;

import com.hp.hpl.jena.ontology.OntClass;

public class Binder {
	
	private HashMap<Class<?>, OntClass> bindings;
	
	public Binder() {
		bindings = new HashMap<Class<?>, OntClass>();
	}
	
	public Binding bind(OntClass oc) {
		return new Binding(this,oc);
	}

	protected void save(Class<?> javaClass, OntClass ontClass) {
		bindings.put(javaClass, ontClass);		
	}
	
	public String getUri(Class<?> c) {
		return bindings.get(c).getURI();
	}
}
