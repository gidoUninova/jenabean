package thewebsemantic;

import java.beans.PropertyDescriptor;

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
	
	
}
