package thewebsemantic.jpa;

import static com.hp.hpl.jena.graph.Node.ANY;
import static com.hp.hpl.jena.graph.Node.createURI;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;

import com.hp.hpl.jena.assembler.Assembler;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

public class Provider implements PersistenceProvider {

	private static final String ASSEMBLY = "META-INF/jenamodels.n3";

	public EntityManagerFactory createContainerEntityManagerFactory(
			PersistenceUnitInfo info, Map map) {
		throw new UnsupportedOperationException("");
	}

	public Factory createEntityManagerFactory(String emName,
			Map map) {

		Model m = null;
		Model assembly = null;
		try {
			assembly = findAssembly(ASSEMBLY);
		} catch (IOException e) {
			throw new PersistenceException(e);
		}
		if (assembly != null) {
			String uri = assembly.expandPrefix(emName);
			if (assembly.getGraph().contains(createURI(uri), ANY, ANY)) {
				Resource r = assembly.getResource(uri);
				m = Assembler.general.openModel(r);
			}
		}

		return (m == null) ? null : new Factory(m);

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
