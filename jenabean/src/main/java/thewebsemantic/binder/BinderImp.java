package thewebsemantic.binder;

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

import java.util.HashMap;

import org.apache.jena.ontology.OntClass;


public class BinderImp implements Binder {
	
	private static Binder myself = new BinderImp();
	private HashMap<Class<?>, String> class2url;
	private HashMap<String, Class<?>> url2class;
	
	public BinderImp() {
		class2url = new HashMap<Class<?>, String>();
		url2class = new HashMap<String, Class<?>>();
	}
	
	public boolean isBound(Class<?> c) {
		return class2url.containsKey(c);
	}
	
	public boolean isBound(OntClass c) {
		return url2class.containsKey(c.getURI());
	}
	
	public String getUri(Class<?> c) {
		return class2url.get(c);
	}
	
	public String getUri(Object bean) {
		return getUri(bean.getClass());
	}
	
	public Class<?> getClass(String uri) {
		return url2class.get(uri);		
	}
	
	public void save(Class<?> javaClass, String ontClass) {
		class2url.put(javaClass, ontClass);
		url2class.put(ontClass, javaClass);
	}
	
	public static Binder instance() { return myself;}
}
