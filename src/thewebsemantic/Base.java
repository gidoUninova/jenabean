package thewebsemantic;

import static thewebsemantic.PrimitiveWrapper.isPrimitive;
import static thewebsemantic.TypeWrapper.ns;

import java.beans.PropertyDescriptor;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.Property;

public class Base {

	private static final String HAS = "has";
	protected OntModel m;

	protected Base(OntModel m) {
		this.m = m;
	}

	protected String toRDFPropertyName(PropertyDescriptor p) {
		return HAS + Util.toProperCase(p.getName());
	}

	protected RdfProperty annotation(PropertyDescriptor p) {
		return (RdfProperty) p.getReadMethod().getAnnotation(RdfProperty.class);
	}

	protected boolean isAnnotated(PropertyDescriptor p) {
		return p.getReadMethod().isAnnotationPresent(RdfProperty.class);
	}

	protected boolean annotated(Class<?> c) {
		return c.isAnnotationPresent(Namespace.class);
	}

	protected Property toRdfProperty(Object o, PropertyDescriptor p) {
		return toRdfProperty(ns(o), p);
	}

	protected Property toRdfProperty(String namespace, PropertyDescriptor p) {
		if (isAnnotated(p))
			return createProperty(p);
		else
			return createProperty(namespace, p);
	}

	private OntProperty createProperty(PropertyDescriptor p) {
		return m.createOntProperty(annotation(p).value());
	}

	private Property createProperty(String ns, PropertyDescriptor p) {
		OntProperty op  = m.createOntProperty(ns + toRDFPropertyName(p));
		if ( isSymmetric(p))
			op.convertToSymmetricProperty();
		return op;
	}

	private boolean isSymmetric(PropertyDescriptor p) {
		return p.getReadMethod().isAnnotationPresent(Semetric.class);
	}

	protected boolean isCollection(PropertyDescriptor property) {
		if (property.getPropertyType().equals(Collection.class)) {
			Class<?> c = t(property);
			return (c != null && (annotated(c) || isPrimitive(c)));
		}
		return false;
	}

	protected Class<?> t(PropertyDescriptor propDesc) {
		ParameterizedType type = (ParameterizedType) propDesc.getReadMethod()
				.getGenericReturnType();
		return (type == null) ? null
				: (Class<?>) type.getActualTypeArguments()[0];
	}


}

/*
 * Copyright (c) 2007 Taylor Cowan
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
