package thewebsemantic.binding;

import com.hp.hpl.jena.ontology.OntClass;

public class Binding {

	private OntClass ontClass;
	private Class<?> javaClass;
	private Jenabean binder;
	
	public Binding(Jenabean b, OntClass c) {
		ontClass = c;
		binder = b;
	}

	public void to(Class<?> c) {
		javaClass = c;
		binder.save(javaClass, ontClass);
	}
}
