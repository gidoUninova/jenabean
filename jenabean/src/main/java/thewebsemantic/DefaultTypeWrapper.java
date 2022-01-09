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

import static thewebsemantic.Bean2RDF.logger;

import java.util.logging.Level;

import org.apache.jena.rdf.model.Resource;

public class DefaultTypeWrapper extends TypeWrapper {

	public DefaultTypeWrapper(Class<?> c) {
		super(c);
	}
	
	@Override
	public String uri(String id) {
		return typeUri() + '/' + id;
	}

	public String id(Object bean) {
		return String.valueOf(bean.hashCode());
	}

	@Override
	public Object toProxyBean(Resource source, AnnotationHelper jpa) {
		try {
			return jpa.getProxy(c).newInstance();
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception caught while invoking default constructor on " + c, e);
		}
		return null;
	}



}
