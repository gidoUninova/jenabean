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

import java.util.ArrayList;
import java.util.Collection;

import thewebsemantic.lazy.Lazy;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.StmtIterator;

public class CollectionSaver extends Saver {

	@Override
	public void save(Bean2RDF writer, Resource subject, Property property, Object o) {
		Collection c = (Collection)o;
		if (c == null)
			return;
		
		if (o instanceof Lazy) {
			Lazy lazy = (Lazy)o;
			if (!  (lazy.isConnected() && lazy.modified()))
				return;
		}

		removeAnonymousNodes(subject, property);
		subject.removeAll(property);
		for (Object obj : c)
			subject.addProperty(property, writer.toRDFNode(obj));
	}
	
	
	private void removeAnonymousNodes(Resource subject, Property property) {
		ArrayList<Resource> anonNodes = new ArrayList<Resource>();
		StmtIterator it = subject.listProperties(property);
		while (it.hasNext()) {
			RDFNode n = it.nextStatement().getObject();
			if (n.isAnon())
				anonNodes.add(n.as(Resource.class));
		}
		it.close();
		for (Resource resource : anonNodes)
			resource.removeProperties();
	}

}
