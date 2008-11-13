package thewebsemantic;

import java.util.Collection;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public class CollectionSaver extends Saver {

	@Override
	public void save(Bean2RDF writer, Resource subject, Property property, Object o) {
		writer.updateCollection(subject, property, (Collection<Object>)o);

	}

}
