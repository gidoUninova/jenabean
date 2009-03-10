package thewebsemantic;

import com.hp.hpl.jena.rdf.model.Resource;

public interface As {
	public <T> T as(Class<T> c);
	public <T> T isa(Class<T> c);
	public Resource asResource();
}
