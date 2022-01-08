package thewebsemantic;

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
import java.util.LinkedList;


public class Includer {

	private Collection<String> includes = new LinkedList<String>();
	private RDF2Bean reader;
	private static final String[] none = new String[0];
	
	public Includer(String s, RDF2Bean reader) {
		includes.add(s);
		this.reader = reader;
	}
	
	public Includer include(String s) {
		includes.add(s);return this;
	}
	
	public <T> Collection<T> load(Class<T> c) {
		return reader.load(c, true, includes.toArray(none));
	}
	
	public <T> T load(Class<T> c, String id) throws NotFoundException {
		return reader.load(c, id, includes.toArray(none));
	}
}
