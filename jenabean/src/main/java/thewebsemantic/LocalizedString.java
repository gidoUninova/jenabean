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

import org.apache.jena.rdf.model.Literal;

public class LocalizedString {
	private String lang;
	private String value;
	
	public LocalizedString(String value, String lang) {
		this.lang = lang;
		this.value = value;
	}
	
	public LocalizedString(Literal l) {
		this((String)l.getValue(), l.getLanguage());
	}

   public String getLang() {
   	return lang;
   }

	public String toString() {
		return value;
	}
}
