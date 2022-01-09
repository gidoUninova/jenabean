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

import thewebsemantic.vocabulary.Foaf;
import thewebsemantic.vocabulary.Geo;
import thewebsemantic.vocabulary.Sioc;

import org.apache.jena.rdf.model.Resource;

/**
 * Provides standard polymorphic interface for {@link Thing} vocabulary
 * interfaces. The <code>as(Class)</code> method returns dynamic proxies related
 * to the same model for a different vocabulary, while <code>isa(Class)</code>
 * does the same thing in addition to asserting a classification
 * <code>(a rdf:type p)</code>. Typically the interface is used allong with the
 * <code>Namespace</code> annotation like this:
 * 
 * <code><pre>
 * @Namespace(&quot;http://xmlns.com/foaf/0.1/&quot;) 
 * public interface Foaf extends As {
 *  // ... } 
 * </pre></code>
 * 
 * @see Thing
 * @see Foaf
 * @see Geo
 * @see Sioc
 */
public interface As {
	
	/**
	 * Polymorph this proxied interface into a new vocabulary by
	 * providing it's class.
	 * 
	 * @return a dynamic proxy related to the connected Jena model
	 * of this proxy.
	 */
	public <T> T as(Class<T> c);

	/**
	 * Polymorph and reclassify this proxied interface into a new vocabulary by
	 * providing it's class.
	 * 
	 * @return a dynamic proxy related to the connected Jena model
	 * of this proxy.
	 */
	public <T> T isa(Class<T> c);

	/**
	 * Provides access to the raw Jena resource in focus.  All requests or sets on this
	 * proxy apply the the resource
	 * 
	 * @return the underlying Jena resource targeted by this proxy.
	 */
	public Resource asResource();
}
