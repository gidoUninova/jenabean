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

import java.util.List;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.jena.vocabulary.RDFS;

public class ClassBuilder {
	OntModel m;
	private static String indent = "   ";

	public void create(String uri, String namespace, String type) {
		StringBuilder buffer = new StringBuilder();
		OntModel m = ModelFactory.createOntologyModel();
		m.read(uri);
		//m.write(System.out);
		ExtendedIterator it = m.listOntProperties();
		
		List<OntProperty> props = it.toList();
		for (OntProperty ontProperty : props) { 
			if (ontProperty.getNameSpace().equals(namespace)) {
				if (ontProperty.isDatatypeProperty()) {
					buffer.append(literalSetter(namespace, type, ontProperty));
					buffer.append("\n");
					buffer.append(literalGetter(namespace, type, ontProperty));
					buffer.append("\n");
				} else if (ontProperty.isObjectProperty()) {
					buffer.append(resourceSetter(namespace, type, ontProperty));
					buffer.append("\n");
					buffer.append(resourceGetter(namespace, type, ontProperty));
					buffer.append("\n");
				} else if (RDFS.Literal.equals( ontProperty.getRange())) {
					buffer.append(literalSetter(namespace, type, ontProperty));
					buffer.append("\n");
					buffer.append(literalGetter(namespace, type, ontProperty));
					buffer.append("\n");					
				} else {
					buffer.append(resourceSetter(namespace, type, ontProperty));
					buffer.append("\n");
					buffer.append(resourceGetter(namespace, type, ontProperty));
					buffer.append("\n");
				} 
			}
		}
		System.out.println(buffer);
	}

	private Object resourceGetter(String namespace, String type,
			OntProperty ontProperty) {
		return indent + "public " + resourceCollection(ontProperty)
			+ ontProperty.getURI().substring(namespace.length()) + "();";
		
	}

	private Object resourceSetter(String namespace, String type,
			OntProperty ontProperty) {
		return functional(ontProperty) + indent + "public " + type + " "
			+ ontProperty.getURI().substring(namespace.length())
			+ "(Object t);";
	}

	private Object literalGetter(String namespace, String type,
			OntProperty ontProperty) {
		return indent + "public " + literalCollection(ontProperty)
				+ ontProperty.getURI().substring(namespace.length()) + "();";
	}

	private String literalCollection(OntProperty ontProperty) {
		return (ontProperty.isFunctionalProperty()) ? "String " : "Collection<String> ";
	}
	
	private String resourceCollection(OntProperty ontProperty) {
		return (ontProperty.isFunctionalProperty()) ? "Thing " : "Collection<Thing> ";
	}

	private String literalSetter(String namespace, String type,
			OntProperty ontProperty) {
		return functional(ontProperty) + indent + "public " + type + " "
				+ ontProperty.getURI().substring(namespace.length())
				+ "(Object o);";
	}

	private String functional(OntProperty ontProperty) {
		return (ontProperty.isFunctionalProperty()) ? indent + "@Functional\n" : "";
	}

	public static void main(String[] args) {
		new ClassBuilder().create("file:cim2003.owl",
				"http://iec.ch/TC57/2003/CIM-schema-cim10#", "CIM");
	}
}
