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

import static thewebsemantic.Bean2RDF.logger;

import java.lang.reflect.Method;
import java.util.logging.Level;

import org.apache.jena.rdf.model.Resource;

public class UriMethodTypeWrapper extends TypeWrapper {

	private Method uriMethod;
	
	public UriMethodTypeWrapper(Class<?> c, Method m) {
		super(c);
		uriMethod = m;
	}

	@Override
	public String uri(Object bean) {
		return invokeMethod(bean, uriMethod);
	}

	@Override
	public String uri(String id) {
		return id;
	}

	@Override
	public String id(Object bean) {
		return invokeMethod(bean, uriMethod);
	}

	/**
	 * This implementation of toBean() supplies the URI to a constructor, if it
	 * exists.  This enables the loading of pre-existing RDF what wasn't created
	 * with Jenabean managed URI's.  
	 */
	@Override
	public Object toBean(String uri) {
		try {
			return (constructor != null) ?
				constructor.newInstance(uri):c.newInstance();
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception caught while instantiating " + c, e);
		}
		return null;
	}

	@Override
	public Object toProxyBean(Resource source, AnnotationHelper jpa) {
		throw new UnsupportedOperationException();
	}

}
