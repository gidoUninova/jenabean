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

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import thewebsemantic.Base.NullType;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;

public abstract class ValuesContext {

	protected Object subject;

	public abstract AccessibleObject  getAccessibleObject();
	
	public abstract String uri();
	
	public abstract boolean isId();

	public abstract boolean isSymmetric();

	public abstract boolean isTransitive();
	
	public abstract boolean isInverse();
	
	public abstract String inverseOf();

	public abstract boolean existsInModel(Model m);

	public abstract Object invokeGetter();

	public abstract void setProperty(Object v);

	public abstract boolean isPrimitive();

    public boolean isCollection() {
       return type().equals(Collection.class);
    }
    
    public boolean isCollectionOrSet() {
    	return isCollection() || isSet();
    }

    public boolean isSet() {
        return type().equals(Set.class);
    }
    
    public boolean isCollectionType() {
		return Collection.class.isAssignableFrom(type());
	}

	public boolean isURI() {
	   return type().equals(URI.class);
	}
	
	public abstract String getName();

	public abstract Class<?> type();

	public abstract Class<?> t();
	
	public Class<?> getGenericType(ParameterizedType type) {
		return (type == null) ? NullType.class : (Class<?>) type
				.getActualTypeArguments()[0];		
	}

	public boolean isTransitive(AccessibleObject o) {
		return TypeWrapper.getRDFAnnotation(o).transitive();
	}

	public boolean isInverse(AccessibleObject o) {
		String inverseProperty = 
			TypeWrapper.getRDFAnnotation(o).inverseOf();
		return !"".equals(inverseProperty);
	}
	
	public String inverseOf(AccessibleObject o) {
		return TypeWrapper.getRDFAnnotation(o).inverseOf();
	}

	public Property property(Model m) { 
		return m.getProperty(uri());
	}

	public boolean isList() {
		return type().equals(List.class);
	}
	
	public boolean isAggregateType() {
		return isCollectionType() || isArray();
	}

	public boolean isArray() {
		return type().isArray();
	}
	
	public String toString() {return getName();}


}
