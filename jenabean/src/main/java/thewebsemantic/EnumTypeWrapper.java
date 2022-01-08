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

import static thewebsemantic.Util.last;

import org.apache.jena.rdf.model.Resource;

public class EnumTypeWrapper extends TypeWrapper {
	
	public EnumTypeWrapper(Class<?> c) {
		super(c);
	}

	@Override
	public String uri(String id) {
		return typeUri() + '/' + id;
	}

	public String id(Object bean) {
		return ((Enum)bean).name();
	}
	
	public Object toBean(String uri) {
		Class<? extends Enum> d =  (Class<? extends Enum>)c;
		return Enum.valueOf(d, last(uri));
	}

	@Override
	public Object toProxyBean(Resource source, AnnotationHelper jpa) {
		return toBean(source.getURI());
	}

}
