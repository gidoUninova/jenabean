package thewebsemantic;

import java.beans.PropertyDescriptor;
import java.util.Date;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;

class PropertyContext {

	Object subject;
	PropertyDescriptor property;

	public PropertyContext(Object bean, PropertyDescriptor p) {
		subject = bean;
		property = p;
	}
	
	public String uri() {
		return TypeWrapper.type(subject).uri(property);
	}
	
	public OntProperty property(OntModel m) {
		return m.getOntProperty(uri());
	}
	
	public boolean existsInModel(OntModel m) {
		return property(m) != null;
	}
	
	public void invoke(Object v) {
	   try {
         property.getWriteMethod().invoke(subject, v);
      } catch (Exception e) {}
	}
	
	public boolean isDate() {
	   return property.getPropertyType().equals(Date.class);
	}
	
	
}
