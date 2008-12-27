package thewebsemantic.jpa;

import static com.hp.hpl.jena.graph.Node.ANY;
import static com.hp.hpl.jena.graph.Node.createURI;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;

import com.hp.hpl.jena.assembler.Assembler;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class Provider implements PersistenceProvider {

	private static final String TWS_PACKAGE = "tws:package";
	private static final String ASSEMBLY = "META-INF/jenamodels.n3";

	public EntityManagerFactory createContainerEntityManagerFactory(
			PersistenceUnitInfo info, Map map) {
		throw new UnsupportedOperationException("");
	}

	public Factory createEntityManagerFactory(String emName,
			Map map) {

		Model m = null;
		Model assembly = null;
		String[] packages = new String[0];

		try {
			assembly = findAssembly(ASSEMBLY);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}

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
					return new Factory(m, packageList.toArray(new String[0]));
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

}
