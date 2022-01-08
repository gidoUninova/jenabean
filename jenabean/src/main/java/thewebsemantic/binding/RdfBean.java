package thewebsemantic.binding;

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

import static thewebsemantic.TypeWrapper.instanceURI;
import static thewebsemantic.TypeWrapper.wrap;

import java.util.Collection;

import thewebsemantic.NotFoundException;

import org.apache.jena.rdf.model.Resource;

public class RdfBean<T> {

	private transient Jenabean binder;
	
	public RdfBean() {
		binder = Jenabean.instance();
	}

	public T load(String id) throws NotFoundException {
		return (T)binder.load(this.getClass(), id);
	}
	
	public T refresh() {
		return (T)binder.reader().load(this);
	}
	
	public T save() {
		binder.writer().save(this);
		return (T)this;
	}
	
	public void delete() {
		binder.writer().delete(this);
	}
	
	public T fill(String s) {
		binder.reader().fill(this, s);
		return (T)this;
	}
	
	public Collection<T> query(String query) {
		return (Collection<T>)binder.query(getClass(), query);
	}
	
	public T fill() {
		for (String pd : wrap(this.getClass()).collections())
			binder.reader().fill(this, pd);
		return (T)this;
	}
	
	public Resource asIndividual() {
		return binder.model().getResource(instanceURI(this));
	}
	
	
}
