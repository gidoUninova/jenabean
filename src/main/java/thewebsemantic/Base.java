package thewebsemantic;

import java.beans.PropertyDescriptor;
import java.lang.reflect.ParameterizedType;
import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;

public class Base {

	protected static final String JAVACLASS = "http://thewebsemantic.com/javaclass";
	protected OntModel om;
	protected Model m;
	protected Jenabean binder;
	protected Property javaclass;

	protected Resource ontClass(String uri) {
		   return m.getResource(uri).addProperty(RDF.type, OWL.Class);
	}
		
	protected Base(Model m) {
		this.m = m;
		binder = Jenabean.instance();		
		if ( m instanceof OntModel) {om = (OntModel)m;}
		javaclass = m.createProperty(JAVACLASS);
		javaclass.addProperty(RDF.type,OWL.AnnotationProperty);
	}

	protected Property toRdfProperty(ValuesContext ctx) {
		return ctx.existsInModel(m) ? ctx.property(m) : applyEntailments(ctx);
	}

	private Property applyEntailments(ValuesContext ctx) {
		if (om == null) return m.getProperty(ctx.uri());		
		OntProperty op = om.createOntProperty(ctx.uri());
		if (ctx.isSymmetric())
			op.convertToSymmetricProperty();
		else if (ctx.isTransitive())
			op.convertToTransitiveProperty();
		return op;
	}

	protected Class<?> t(PropertyDescriptor propDesc) { 

		ParameterizedType type = (ParameterizedType) propDesc.getReadMethod()
				.getGenericReturnType();
		return (type == null) ? NullType.class : (Class<?>) type
				.getActualTypeArguments()[0];
	}

	protected boolean isBound(Object o) {
		return binder.isBound(o.getClass());
	}

	class NullType {

	}

}

/*
 * Copyright (c) 2007 
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */
