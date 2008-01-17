package thewebsemantic;

import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.Date;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;

class PropertyContext {

	Object subject;
	PropertyDescriptor property;
	TypeWrapper type;

	public PropertyContext(Object bean, PropertyDescriptor p) {
		subject = bean;
		property = p;
		type = TypeWrapper.type(bean);
	}
	
	public String uri() {
		return type.uri(property);
	}
	
	public boolean isSymmetric() {
		return type.isSymmetric(property);
	}

	public boolean isInverse() {
		return property.getReadMethod().isAnnotationPresent(Inverse.class);
	}
	
	public boolean isTransitive() {
		return type.getAnnotation(property.getReadMethod()).transitive();
	}
	
	public Property property(Model m) { 
		return (existsInModel(m)) ? m.getProperty(uri()): null;
	}

	public boolean existsInModel(Model m) {
		return m.getGraph().contains( Node.createURI( uri() ), Node.ANY, Node.ANY );
	}
	
	
	public Object invokeGetter() {
		Object result=null;
		try {
			result = property.getReadMethod().invoke(subject);
			if ( result == null)
				result = new int[0];
		} catch (Exception e) {}
		return result;
	}
	
	public void setProperty(Object v) {
	   try {
         property.getWriteMethod().invoke(subject, v);
      } catch (Exception e) {}
	}
	
	public boolean isDate() {
	   return property.getPropertyType().equals(Date.class);
	}
	
	public boolean isPrimitive() {
	   return PrimitiveWrapper.isPrimitive(property.getPropertyType());
	}
	
    public boolean isCollection() {
       return property.getPropertyType().equals(Collection.class);
    }
    
    public boolean isArray() {
    	return property.getPropertyType().isArray();
    }
    
    public Class<?> type() {
    	return property.getPropertyType();
    }
    
}
