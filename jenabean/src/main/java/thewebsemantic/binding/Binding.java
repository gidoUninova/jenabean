package thewebsemantic.binding;

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

import thewebsemantic.binder.Binder;

import org.apache.jena.ontology.OntClass;

public class Binding {

	private String ontClass;
	private Binder binder;
	
	public Binding(Binder b, OntClass c) {
		ontClass = c.getURI();
		binder = b;
	}

	public Binding(Binder b, String ontClassUri) {
		ontClass = ontClassUri;
		binder = b;
	}
	
	public void to(Class<?> c) {
		binder.save(c, ontClass);
	}
	
	
	

}
