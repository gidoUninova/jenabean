package thewebsemantic;

import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.Date;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;

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
	
	public OntProperty property(OntModel m) {
		return m.getOntProperty(uri());
	}
	
	public boolean existsInModel(OntModel m) {
		return property(m) != null;
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
    
}
