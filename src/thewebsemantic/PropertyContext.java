package thewebsemantic;

import java.beans.PropertyDescriptor;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Date;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;

class PropertyContext extends ValuesContext {

	Object subject;
	PropertyDescriptor property;
	TypeWrapper type;

	public PropertyContext(Object bean, PropertyDescriptor p) {
		subject = bean;
		property = p;
		type = TypeWrapper.type(bean);
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
		return TypeWrapper.getRDFAnnotation(property.getReadMethod()).transitive();
	}
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#property(com.hp.hpl.jena.rdf.model.Model)
	 */
	public Property property(Model m) { 
		return (existsInModel(m)) ? m.getProperty(uri()): null;
	}

	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#existsInModel(com.hp.hpl.jena.rdf.model.Model)
	 */
	public boolean existsInModel(Model m) {
		return m.getGraph().contains( Node.createURI( uri() ), Node.ANY, Node.ANY );
	}
	
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#invokeGetter()
	 */
	public Object invokeGetter() {
		Object result=null;
		try {
			result = property.getReadMethod().invoke(subject);
			if ( result == null)
				result = new int[0];
		} catch (Exception e) {}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#setProperty(java.lang.Object)
	 */
	public void setProperty(Object v) {
	   try {
         property.getWriteMethod().invoke(subject, v);
      } catch (Exception e) {}
	}
	
	/* (non-Javadoc)
	 * @see thewebsemantic.ValuesContext#isDate()
	 */
	public boolean isDate() {
	   return property.getPropertyType().equals(Date.class);
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

}
