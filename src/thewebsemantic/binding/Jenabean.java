package thewebsemantic.binding;

import java.util.HashMap;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;

public class Jenabean {
	
	private HashMap<Class<?>, String> class2url;
	private HashMap<String, Class<?>> url2class;
	private OntModel model;
	private Bean2RDF writer;
	private RDF2Bean reader;
	
	private static Jenabean myself = new Jenabean();
	
	public static synchronized Jenabean instance() {
		return myself;
	}

	private Jenabean() {
		class2url = new HashMap<Class<?>, String>();
		url2class = new HashMap<String, Class<?>>();
	}
	
	public void bind(OntModel m) {
		model = m;
		reader = new RDF2Bean(m);
		writer = new Bean2RDF(m);
	}
	
	public OntModel model() {
		return model;
	}
	
	public Bean2RDF writer() {
		return writer;
	}
	
	public RDF2Bean reader() {
		return reader;
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
