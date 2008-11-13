package thewebsemantic;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public abstract class Saver {

	private static Map<Class<?>, Saver> lookup = new HashMap<Class<?>, Saver>() ;
	
	static {
		lookup.put(Resource.class, new ResourceSaver());
		lookup.put(Collection.class, new CollectionSaver());
		lookup.put(List.class, new ListSaver());
		lookup.put(Array.class, new ArraySaver());
	}
	
	public static boolean supports(Class<?> type) {
		return lookup.containsKey(type);
	}


	public static Saver of(Class<?> type) {
		return lookup.get(type);
	}

	public abstract void save(Bean2RDF writer, Resource subject, Property property, Object o);
}
