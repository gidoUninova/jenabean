package thewebsemantic;

import java.beans.PropertyDescriptor;
import java.util.Collection;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.rdf.model.Resource;

import static thewebsemantic.TypeWrapper.instanceURI;
import static thewebsemantic.TypeWrapper.wrap;
import thewebsemantic.binding.Jenabean;

public class RdfBean<T> {

	private Jenabean binder;
	
	public RdfBean() {
		binder = Jenabean.instance();
	}

	public T load(String id) throws NotFoundException {
		return (T)binder.load(getClass(), id);
	}
	
	public T refresh() throws NotFoundException {
		return (T)binder.reader().load(this);
	}
	
	public T save() {
		binder.writer().save(this);
		return (T)this;
	}
	
	public void delete() {
		binder.writer().delete(this);
	}
	
	public T fill(String s) {
		binder.reader().fill(this, s);
		return (T)this;
	}
	
	public T fill() {
		for (PropertyDescriptor pd : wrap(this.getClass()).collections())
			if ( pd.getPropertyType().equals(Collection.class))
				binder.reader().fill(this, pd.getName());
		return (T)this;
	}
	
	public Resource asIndividual() {
		return binder.model().getResource(instanceURI(this));
	}
	
}
