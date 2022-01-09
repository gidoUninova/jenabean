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

import java.beans.PropertyDescriptor;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.ParameterizedType;
import java.util.logging.Level;

import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.rdf.model.Model;

class PropertyContext extends ValuesContext {

	PropertyDescriptor property;
	TypeWrapper type;
	boolean idmethod = false;

	public PropertyContext(Object bean, PropertyDescriptor p) {
		subject = bean;
		property = p;
		type = TypeWrapper.type(bean);
	}

	public PropertyContext(Object bean, PropertyDescriptor p, boolean b) {
		this(bean, p);
		idmethod = b;		
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
		Object result=null;
		try {
			result = property.getReadMethod().invoke(subject);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Error calling read method.", e);
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#setProperty(java.lang.Object)
	 */
	public void setProperty(Object v) {
	   try {
         property.getWriteMethod().invoke(subject, v);
      } catch (Exception e) {
			logger.log(Level.WARNING, "Error calling write method.", e);
      }
	}
	
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#isPrimitive()
	 */
	public boolean isPrimitive() {
	   return PrimitiveWrapper.isPrimitive(property.getPropertyType());
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
		return idmethod;
	}

	@Override
	public  AccessibleObject  getAccessibleObject() {
		return property.getReadMethod();
	}


}
