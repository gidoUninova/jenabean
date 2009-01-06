package thewebsemantic.jpa;

import static com.hp.hpl.jena.graph.Node.ANY;
import static com.hp.hpl.jena.graph.Node.createURI;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PersistenceException;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;

import thewebsemantic.Namespace;
import thewebsemantic.ResolverUtil;
import thewebsemantic.Util;

import com.hp.hpl.jena.assembler.Assembler;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;

public class JBProvider implements PersistenceProvider {

	public static final String JAVACLASS = "http://thewebsemantic.com/javaclass";
	public static final String TWS_PACKAGE = "tws:package";
	public static final String ASSEMBLY = "META-INF/jenamodels.n3";
	private Model assembly = null;
	private HashMap<String, JBFactory> entityManagers;
	
	
	public JBProvider() {
		entityManagers = new HashMap<String, JBFactory>();
		try {
			assembly = findAssembly(ASSEMBLY);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}	
	}
	
	public JBProvider(Model m) {
		entityManagers = new HashMap<String, JBFactory>();
		assembly = m;
	}
	
	public EntityManagerFactory createContainerEntityManagerFactory(
			PersistenceUnitInfo info, Map map) {
		throw new UnsupportedOperationException("");
	}

	public JBFactory createEntityManagerFactory(String name, Map map) {
		if (entityManagers.containsKey(name))
			return entityManagers.get(name);
		JBFactory f = _createEntityManagerFactory(name, map); 
		if ( f != null) {
			entityManagers.put(name, f);
		}
		return f;
	}
	
	private JBFactory _createEntityManagerFactory(String emName, Map map) {
		if (assembly != null) {
			String uri = assembly.expandPrefix(emName);
			if (assembly.getGraph().contains(createURI(uri), ANY, ANY)) {
				Resource r = assembly.getResource(uri);
				try {
					Model m = Assembler.general.openModel(r);
					return new JBFactory(m, bindAll(m, getPackages(r)));
				} catch(Exception e) {
					throw new PersistenceException(e);
				}
			}
		}
		return null;

	}

	private String[] getPackages(Resource r) {
		String packageUri = assembly.expandPrefix(TWS_PACKAGE);
		Property p = assembly.createProperty(packageUri);
		StmtIterator it =  r.listProperties(p);
		LinkedList<String> packageList = new LinkedList<String>();
		while(it.hasNext()) {
			String pname = it.nextStatement().getString();
			packageList.add(pname);
		}
		return packageList.toArray(new String[0]);
	}

	public Model findAssembly(String location) throws IOException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> resources = loader.getResources(location);
		Model m = ModelFactory.createDefaultModel();
		while (resources.hasMoreElements()) {
			URL url = resources.nextElement();
			m.read(url.toString(), "N3");
		}
		return m;
	}
	
	protected HashMap<String, NamedNativeQuery> bindAll(Model m, String... s) {
		HashMap<String, NamedNativeQuery> querymap = new HashMap<String, NamedNativeQuery>();
		Property javaclass = m.createProperty(JAVACLASS);
		javaclass.addProperty(RDF.type,OWL.AnnotationProperty);
		ResolverUtil<Object> resolver = new ResolverUtil<Object>();
		resolver.findAnnotated(Namespace.class, s);
		Set<Class<? extends Object>> classes = resolver.getClasses();
		for (Class<? extends Object> class1 : classes) {
			Namespace ns = class1.getAnnotation(Namespace.class);
            m.getResource(ns.value() + Util.getRdfType(class1)).addProperty(
					javaclass, class1.getName());
            if (class1.isAnnotationPresent(NamedNativeQueries.class)) {
            	storeNamedQuery(class1, querymap);
            }
		}
		return querymap;
	}

	protected void storeNamedQuery(Class<? extends Object> class1,HashMap<String, NamedNativeQuery> querymap) {
		NamedNativeQueries queries = class1.getAnnotation(NamedNativeQueries.class);
		for(NamedNativeQuery query : queries.value()) {
			querymap.put(query.name(), query);
		}
	}

}
