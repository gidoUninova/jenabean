package thewebsemantic.vocabulary;

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

import thewebsemantic.As;
import thewebsemantic.Functional;
import thewebsemantic.Namespace;

@Namespace("http://www.w3.org/2003/01/geo/wgs84_pos#")
public interface Geo extends As {
	
	interface Point extends Geo{}

	@Functional
	Geo lat(float l);
	Float lat();

	@Functional
	Geo long_(float l);
	Float long_();

}
