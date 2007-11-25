package thewebsemantic;

import static thewebsemantic.PrimitiveWrapper.isPrimitive;

import java.beans.PropertyDescriptor;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.Property;

public class Base {

	protected static final String JAVACLASS = "http://thewebsemantic.com/javaclass";
	protected OntModel m;

	protected Base(OntModel m) {
		this.m = m;
	}

	private RdfProperty annotation(PropertyDescriptor p) {
		return (RdfProperty) p.getReadMethod().getAnnotation(RdfProperty.class);
	}

	protected boolean annotated(Class<?> c) {
		return c.isAnnotationPresent(Namespace.class);
	}
	
	protected Property toRdfProperty(PropertyContext ctx) {
		String uri = ctx.uri();
		Property existingProperty = m.getOntProperty(uri);
		if ( existingProperty != null)
			return existingProperty;
		else
			return applyEntailments(ctx);
	}
	
	private Property applyEntailments(PropertyContext ctx) {
		OntProperty op = m.createOntProperty(ctx.uri());
		if (isSymmetric(ctx.property))
			op.convertToSymmetricProperty();
		if (isInverse(ctx.property))
			makeInverse(ctx.property, op);
		return op;
	}

	private void makeInverse(PropertyDescriptor property, OntProperty op) {
		Class<?> c = t(property);
		if (c != NullType.class) {
			TypeWrapper type = TypeWrapper.get(c);
			Inverse i = property.getReadMethod().getAnnotation(Inverse.class);
			for (PropertyDescriptor pd : type.descriptors())
				if ( pd.getName().equals(i.value()))
					op.setInverseOf(m.createProperty(type.uri(pd)));
		}
	}

	private boolean isInverse(PropertyDescriptor p) {
		return p.getReadMethod().isAnnotationPresent(Inverse.class);
	}

	private boolean isSymmetric(PropertyDescriptor p) {
		return (p.getReadMethod().isAnnotationPresent(Symmetric.class)) ? true
				: isSymmetric(annotation(p));
	}
	
	
	private boolean isSymmetric(RdfProperty a) {
		return (a!= null && a.symmetric());	
	}

	protected boolean isCollection(PropertyDescriptor property) {
		return (property.getPropertyType().equals(Collection.class)) ?
			supportedType(t(property)) : false;
	}
	
	protected boolean supportedType(Class<?> c) {
		return ((annotated(c) || isPrimitive(c)));
	}

	protected Class<?> t(PropertyDescriptor propDesc) {
		ParameterizedType type = (ParameterizedType) propDesc.getReadMethod()
				.getGenericReturnType();
		return (type == null) ? NullType.class
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
