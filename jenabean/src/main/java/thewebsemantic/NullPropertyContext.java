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

import java.beans.PropertyDescriptor;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.util.Collection;
import java.util.Date;

import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.rdf.model.Model;

class NullPropertyContext extends ValuesContext {

	PropertyDescriptor property;
	TypeWrapper type;

	public NullPropertyContext(TypeWrapper t, PropertyDescriptor p) {
		property = p;
		type = t;
	}
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#uri()
	 */
	public String uri() {
		return type.uri(property.getReadMethod(), property.getName());
	}
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#isSymmetric()
	 */
	public boolean isSymmetric() {
		return isSymmetric(property);
	}

	private boolean isSymmetric(PropertyDescriptor p) {
		return (p.getReadMethod().isAnnotationPresent(Symmetric.class)) ? true
				: TypeWrapper.getRDFAnnotation(p.getReadMethod()).symmetric();
	}	
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#isTransitive()
	 */
	public boolean isTransitive() {
		return isTransitive(property.getReadMethod());
	}
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#existsInModel(org.apache.jena.rdf.model.Model)
	 */
	public boolean existsInModel(Model m) {
		return m.getGraph().contains( NodeFactory.createURI( uri() ), Node.ANY, Node.ANY );
	}
	
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#invokeGetter()
	 */
	public Object invokeGetter() {
		throw new UnsupportedOperationException();
	}
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#setProperty(java.lang.Object)
	 */
	public void setProperty(Object v) {
		throw new UnsupportedOperationException();
	}
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#isDate()
	 */
	public boolean isDate() {
	   return property.getPropertyType().equals(Date.class);
	}
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#isURI()
	 */
	public boolean isURI() {
	   return property.getPropertyType().equals(URI.class);
	}
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#isPrimitive()
	 */
	public boolean isPrimitive() {
	   return PrimitiveWrapper.isPrimitive(property.getPropertyType());
	}
	
    /* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#isCollection()
	 */
    public boolean isCollection() {
       return property.getPropertyType().equals(Collection.class);
    }
    
    /* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#isArray()
	 */
    public boolean isArray() {
    	return property.getPropertyType().isArray();
    }
    
    /* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#type()
	 */
    public Class<?> type() {
    	return property.getPropertyType();
    }
    
    public TypeWrapper tw() {
    	return type;
    }

	public String getName() {
		return property.getName();
	}
	
	public Class<?> t() { 
		ParameterizedType type = (ParameterizedType) property.getReadMethod()
				.getGenericReturnType();
		return getGenericType(type);
	}

	@Override
	public boolean isInverse() {
		return isInverse(property.getReadMethod());
	}
	
	public String inverseOf() {
		return inverseOf(property.getReadMethod());
	}

	@Override
	public boolean isId() {
		return false;
	}

	@Override
	public AccessibleObject getAccessibleObject() {
		return property.getReadMethod();
	}
	


}
