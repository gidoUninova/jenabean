package thewebsemantic;

/*-
 * #%L
 * Jenabean binding library for RDF
 * %%
 * Copyright (C) 2015 thewebsemantic
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.lang.reflect.Array;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

public abstract class Saver {

	private static Map<Class<?>, Saver> lookup = new HashMap<Class<?>, Saver>() ;
	
	static {
		lookup.put(thewebsemantic.Resource.class, new ResourceSaver());
		lookup.put(Collection.class, new CollectionSaver());
		lookup.put(Set.class, new CollectionSaver());
		lookup.put(List.class, new ListSaver());
		lookup.put(Array.class, new ArraySaver());
		lookup.put(URI.class, new ResourceSaver());
	}
	
	public static boolean supports(Class<?> type) {
		return (type.isArray()) ? true : lookup.containsKey(type);
	}

	public static Saver of(Class<?> type) {
		return (type.isArray()) ? lookup.get(Array.class) : lookup.get(type);
	}

	public abstract void save(Bean2RDF writer, Resource subject, Property property, Object o);
}
