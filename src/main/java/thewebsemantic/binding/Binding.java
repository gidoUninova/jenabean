package thewebsemantic.binding;

import com.hp.hpl.jena.ontology.OntClass;

public class Binding {

	private String ontClass;
	private Class<?> javaClass;
	private Jenabean binder;
	
	public Binding(Jenabean b, OntClass c) {
		ontClass = c.getURI();
		binder = b;
	}

	public Binding(Jenabean b, String ontClassUri) {
		ontClass = ontClassUri;
		binder = b;
	}
	
	public void to(Class<?> c) {
		javaClass = c;
		binder.save(javaClass, ontClass);
	}
}
