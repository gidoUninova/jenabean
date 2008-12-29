package thewebsemantic.jpa;

import static com.hp.hpl.jena.graph.Node.ANY;
import static com.hp.hpl.jena.graph.Node.createURI;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
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

public class Provider implements PersistenceProvider {

	public static final String JAVACLASS = "http://thewebsemantic.com/javaclass";
	private static final String TWS_PACKAGE = "tws:package";
	private static final String ASSEMBLY = "META-INF/jenamodels.n3";
	private Model assembly = null;
	
	public Provider() {
		try {
			assembly = findAssembly(ASSEMBLY);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}	
	}
	
	public Provider(Model m) {
		assembly = m;
	}
	
	public EntityManagerFactory createContainerEntityManagerFactory(
			PersistenceUnitInfo info, Map map) {
		throw new UnsupportedOperationException("");
	}

	public Factory createEntityManagerFactory(String emName, Map map) {
		Model m = null;
		if (assembly != null) {
			String uri = assembly.expandPrefix(emName);
			if (assembly.getGraph().contains(createURI(uri), ANY, ANY)) {
				Resource r = assembly.getResource(uri);
				String packageUri = assembly.expandPrefix(TWS_PACKAGE);
				Property p = assembly.createProperty(packageUri);
				StmtIterator it =  r.listProperties(p);
				LinkedList<String> packageList = new LinkedList<String>();
				while(it.hasNext()) {
					String pname = it.nextStatement().getString();
					packageList.add(pname);
				}
				try {
					m = Assembler.general.openModel(r);
					bindAll(m, packageList.toArray(new String[0]));
					return new Factory(m);
				} catch(Exception e) {
					throw new PersistenceException(e);
				}
			}
		}
		return null;

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
	
	protected void bindAll(Model m, String... s) {
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
            	storeNamedQuery(class1);
            }
		}
	}

	protected void storeNamedQuery(Class<? extends Object> class1) {
		NamedNativeQueries queries = class1.getAnnotation(NamedNativeQueries.class);
		for(NamedNativeQuery query : queries.value()) {
			
		}
	}

}
