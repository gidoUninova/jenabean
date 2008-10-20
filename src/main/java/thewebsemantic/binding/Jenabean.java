package thewebsemantic.binding;

import java.util.Collection;
import java.util.Set;

import thewebsemantic.Bean2RDF;
import thewebsemantic.Includer;
import thewebsemantic.Namespace;
import thewebsemantic.NotFoundException;
import thewebsemantic.RDF2Bean;
import thewebsemantic.RdfProperty;
import thewebsemantic.ResolverUtil;
import thewebsemantic.binder.Binder;
import thewebsemantic.binder.BinderImp;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Model;

public class Jenabean  {
	
	private Model model;
	private Bean2RDF writer;
	private RDF2Bean reader;
	private Binder binder = BinderImp.instance();
	
	private static Jenabean myself = new Jenabean();
	
	public static synchronized Jenabean instance() {
		return myself;
	}

	private Jenabean() {

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
		return new Binding(binder,oc);
	}

	public Binding bind(String ontClassUri) {
		return new Binding(binder,ontClassUri);
	}
	
	public boolean isBound(Class<?> c) {
		return binder.isBound(c);
	}
	
	public boolean isBound(OntClass c) {
		return binder.isBound(c);
	}
	
	public String getUri(Class<?> c) {
		return binder.getUri(c);
	}
	
	public String getUri(Object bean) {
		return getUri(bean.getClass());
	}
	
	public Class<?> getClass(String uri) {
		return binder.getClass(uri);	
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

	public void bindAll(String... string) {
		ResolverUtil<Object> resolver = new ResolverUtil<Object>();
		resolver.findAnnotated(Namespace.class, "example");
		Set<Class<? extends Object>> classes = resolver.getClasses();
		for (Class<? extends Object> class1 : classes) {
			Namespace ns = class1.getAnnotation(Namespace.class);
			String namespace = ns.value();
			bind(namespace + "#" + class1.getSimpleName()).to(class1);
		}		
		
	}
}
