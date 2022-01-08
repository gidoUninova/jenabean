package thewebsemantic.vocabulary;

/*-
 * #%L
 * Jenabean binding library for RDF
 * %%
 * Copyright (C) 2022 schlotze
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

import java.util.Collection;

import thewebsemantic.As;
import thewebsemantic.Namespace;
import thewebsemantic.Thing;

@Namespace("http://www.w3.org/2000/01/rdf-schema#")
public interface Rdfs extends As {
	interface Class extends Rdfs {}
	interface Resource extends Rdfs {}
	
	Rdfs comment(Object o);
	Collection<String> comment();
	Rdfs label(Object o);
	Collection<String> label();
	Rdfs seeAlso(Object o);
	Collection<Thing> seeAlso();
}
