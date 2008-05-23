package thewebsemantic;

import java.lang.reflect.ParameterizedType;

import thewebsemantic.Base.NullType;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;

public abstract class ValuesContext {

	public abstract String uri();

	public abstract boolean isSymmetric();

	public abstract boolean isTransitive();

	public abstract Property property(Model m);

	public abstract boolean existsInModel(Model m);

	public abstract Object invokeGetter();

	public abstract void setProperty(Object v);

	public abstract boolean isDate();

	public abstract boolean isPrimitive();

	public abstract boolean isCollection();

	public abstract boolean isArray();
	
	public abstract String getName();

	public abstract Class<?> type();

	public abstract Class<?> t();
	
    public abstract TypeWrapper tw();

	public Class<?> getGenericType(ParameterizedType type) {
		return (type == null) ? NullType.class : (Class<?>) type
				.getActualTypeArguments()[0];		
	}

}