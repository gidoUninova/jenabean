package thewebsemantic;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import thewebsemantic.Base.NullType;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;

public abstract class ValuesContext {

	public abstract String uri();

	public abstract boolean isSymmetric();

	public abstract boolean isTransitive();
	
	public abstract boolean isInverse();
	
	public abstract String inverseOf();

	public abstract boolean existsInModel(Model m);

	public abstract Object invokeGetter();

	public abstract void setProperty(Object v);

	public abstract boolean isPrimitive();

	public abstract boolean isCollection();

	public abstract boolean isArray();
	
	public abstract boolean isURI();
	
	public abstract String getName();

	public abstract Class<?> type();

	public abstract Class<?> t();
	
    public abstract TypeWrapper tw();

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

}