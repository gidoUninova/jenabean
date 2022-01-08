package thewebsemantic.vocabulary;

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
import java.util.Date;

import org.apache.jena.rdf.model.Literal;

import thewebsemantic.As;
import thewebsemantic.Functional;
import thewebsemantic.Namespace;
import thewebsemantic.Thing;

@Namespace("http://purl.org/dc/elements/1.1/")
public interface DublinCore extends As {

	public DublinCore subject(Object s);
	public DublinCore contributor(String s);
	public DublinCore coverage(String s);
	public DublinCore creator(String s);

	@Functional
	public DublinCore date(Date d);
	public DublinCore description(String s);
	public DublinCore format(String s);
	public DublinCore identifier(String s);
	public DublinCore language(String s);
	public DublinCore publisher(String s);
	public DublinCore relation(String s);
	public DublinCore rights(String s);
	public DublinCore source(String s);

	@Functional
	public DublinCore title(String s);
	@Functional
	public DublinCore title(String s, String lang);
	public Collection<Literal> contributor();
	public String coverage();
	public Collection<Literal> creator();
	public Date date();
	public String description();
	public String format();
	public String identifier();
	public String language();
	public String publisher();
	public String relation();
	public String rights();
	public String source();
	public Collection<Literal> subject();
	public Collection<Thing> subject_();
	public String title();
	public String type();
}
