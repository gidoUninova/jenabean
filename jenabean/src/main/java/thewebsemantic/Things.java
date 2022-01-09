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

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.apache.jena.rdf.model.Statement;

public class Things {

	Set<Statement> stuff;
	
	public Things(Set<Statement> set) {
		stuff = set;
	}

	public boolean add(Statement e) {
		return stuff.add(e);
	}

	public boolean addAll(Collection<? extends Statement> c) {
		return stuff.addAll(c);
	}

	public void clear() {
		stuff.clear();
	}

	public boolean contains(Object o) {
		return stuff.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return stuff.containsAll(c);
	}

	public boolean equals(Object o) {
		return stuff.equals(o);
	}

	public int hashCode() {
		return stuff.hashCode();
	}

	public boolean isEmpty() {
		return stuff.isEmpty();
	}

	public Iterator<Statement> iterator() {
		return stuff.iterator();
	}

	public boolean remove(Object o) {
		return stuff.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return stuff.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return stuff.retainAll(c);
	}

	public int size() {
		return stuff.size();
	}

	public Object[] toArray() {
		return stuff.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return stuff.toArray(a);
	}


}
