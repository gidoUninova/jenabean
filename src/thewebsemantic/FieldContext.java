package thewebsemantic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Date;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;

class FieldContext extends ValuesContext {

	Object subject;
	Field field;
	TypeWrapper type;

	public FieldContext(Object bean, Field p) {
		subject = bean;
		field = p;
		type = TypeWrapper.type(bean);
	}
	
	public String uri() {
		return type.uri(field, field.getName());
	}
	
	public boolean isSymmetric() {
		return isSymmetric(field);
	}

	private boolean isSymmetric(Field p) {
		return (field.isAnnotationPresent(Symmetric.class)) ? true
				: TypeWrapper.getRDFAnnotation(field).symmetric();
	}
	
    public TypeWrapper tw() {
    	return type;
    }

	
	public boolean isTransitive() {
		return TypeWrapper.getRDFAnnotation(field).transitive();
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
			field.setAccessible(true);
			result = field.get(subject);
			if ( result == null)
				result = new int[0];
		} catch (Exception e) {e.printStackTrace();}
		return result;
	}
	
	public void setProperty(Object v) {
	   try {
		 field.setAccessible(true);
         field.set(subject, v);
      } catch (Exception e) {e.printStackTrace();}
	}
	
	public boolean isDate() {
	   return field.getType().equals(Date.class);
	}
	
	public boolean isPrimitive() {
	   return PrimitiveWrapper.isPrimitive(field.getType());
	}
	
    public boolean isCollection() {
       return field.getType().equals(Collection.class);
    }
    
    public boolean isArray() {
    	return field.getType().isArray();
    }
    
    public Class<?> type() {
    	return field.getType();
    }

	public String getName() {
		return field.getName();
	}

	public Class<?> t() { 
		return getGenericType((ParameterizedType) field.getGenericType());
	}

}
