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

import java.util.Collection;

import thewebsemantic.Bean2RDF;
import thewebsemantic.Includer;
import thewebsemantic.NotFoundException;
import thewebsemantic.RDF2Bean;
import thewebsemantic.Sparql;
import thewebsemantic.binder.Binder;
import thewebsemantic.binder.BinderImp;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.rdf.model.Model;

public class Jenabean  {
	
	private Model model;
	private Bean2RDF writer;
	private RDF2Bean reader;
	private Binder binder = BinderImp.instance();
	
	private static Jenabean myself = new Jenabean();
	
	public static synchronized Jenabean instance() {
		return myself;
	}

	private Jenabean() {

	}
	
	public void bind(Model m) {
		model = m;
		reader = new RDF2Bean(m);
		writer = new Bean2RDF(m);
	}
	
	public Model model() {
		return model;
	}
	
	public Bean2RDF writer() {
		return writer;
	}
	
	public RDF2Bean reader() {
		return reader;
	}
	
	public Binding bind(OntClass oc) {
		return new Binding(binder,oc);
	}

	public Binding bind(String ontClassUri) {
		return new Binding(binder,ontClassUri);
	}
	
	public boolean isBound(Class<?> c) {
		return binder.isBound(c);
	}
	
	public boolean isBound(OntClass c) {
		return binder.isBound(c);
	}
	
	public Class<?> getClass(String uri) {
		return binder.getClass(uri);	
	}
	
	public static boolean exists(Class<?> c, String id) {
		return instance().reader().exists(c, id);
	}

	public static <E> E load(Class<E> c, String id) throws NotFoundException{
		return myself.reader().load(c, id);
	}
	
	public static <E> Collection<E> load(Class<E> c) {
		return myself.reader().load(c);
	}
	
	public static <E> Collection<E> loadDeep(Class<E> c) {
		return myself.reader().loadDeep(c);
	}
	
	public static <E> E load(Class<E> c, int id) throws NotFoundException {
		return myself.reader().load(c, id);
	}	
	public static Includer include(String s) {
		return new Includer(s, myself.reader());
	}
	public static <T> Collection<T> query(Class<T> c,String query) {
		return Sparql.exec(myself.model, c, query);
	}

	public void bindAll(String... s) {
		reader.bindAll(s);
	}
}
