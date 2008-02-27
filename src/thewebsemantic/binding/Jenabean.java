package thewebsemantic.binding;

import java.util.Collection;
import java.util.HashMap;

import thewebsemantic.Bean2RDF;
import thewebsemantic.Includer;
import thewebsemantic.NotFoundException;
import thewebsemantic.RDF2Bean;
import thewebsemantic.RdfProperty;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Model;

public class Jenabean {
	
	private HashMap<Class<?>, String> class2url;
	private HashMap<String, Class<?>> url2class;
	private Model model;
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
	
	public void bind(Model m) {
		model = m;
		reader = new RDF2Bean(m);
		writer = new Bean2RDF(m);
	}
	
	
	public Model model() {
		return model;
	}
	
	public Bean2RDF writer() {
		return writer;
	}
	
	public RDF2Bean reader() {
		return reader;
	}
	
	public void bind(Object o) {
		if (o.getClass().isAnnotationPresent(RdfProperty.class)) {
			bind(o.getClass().getAnnotation(RdfProperty.class));
		}
	}
	
	public Binding bind(OntClass oc) {
		return new Binding(this,oc);
	}

	public Binding bind(String ontClassUri) {
		return new Binding(this,ontClassUri);
	}
	
	protected void save(Class<?> javaClass, String ontClass) {
		class2url.put(javaClass, ontClass);
		url2class.put(ontClass, javaClass);
	}
	
	public boolean isBound(Class<?> c) {
		return class2url.containsKey(c);
	}
	
	public boolean isBound(OntClass c) {
		return url2class.containsKey(c.getURI());
	}
	
	public String getUri(Class<?> c) {
		return (class2url.containsKey(c)) ? class2url.get(c) : null;
	}
	
	public String getUri(Object bean) {
		return getUri(bean.getClass());
	}
	
	public Class<?> getClass(String uri) {
		return (url2class.containsKey(uri)) ? url2class.get(uri):null;		
	}
	
	public static boolean exists(Class<?> c, String id) {
		return instance().reader().exists(c, id);
	}

	public static <E> E load(Class<E> c, String id) throws NotFoundException{
		return myself.reader().load(c, id);
	}
	
	public static <E> Collection<E> load(Class<E> c) {
		return myself.reader().load(c);
	}
	
	public static <E> E load(Class<E> c, int id) throws NotFoundException {
		return myself.reader().load(c, id);
	}	
	public static Includer include(String s) {
		return new Includer(s, myself.reader());
	}
}
