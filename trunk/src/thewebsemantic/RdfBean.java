package thewebsemantic;

import java.beans.PropertyDescriptor;
import java.util.Collection;

import com.hp.hpl.jena.ontology.Individual;

import static thewebsemantic.TypeWrapper.instanceURI;
import static thewebsemantic.TypeWrapper.wrap;

import thewebsemantic.binding.Jenabean;

public class RdfBean<T> {

	private Jenabean binder;
	
	public RdfBean() {
		binder = Jenabean.instance();
	}
	
	public T refresh() throws NotFoundException {
		return (T)binder.reader().load(this);
	}
	
	public static <E> E load(Class<E> c, String id) throws NotFoundException{
		return Jenabean.instance().reader().load(c, id);
	}

	public static <E> Collection<E> load(Class<E> c) {
		return Jenabean.instance().reader().load(c);
	}
	
	public static <E> E load(Class<E> c, int id) throws NotFoundException {
		return Jenabean.instance().reader().load(c, id);
	}
	
	public void save() {
		binder.writer().save(this);
	}
	
	public T fill(String s) {
		binder.reader().fill(this, s);
		return (T)this;
	}
	
	public <T> T fill() {
		for (PropertyDescriptor pd : wrap(this.getClass()).collections())
			if ( pd.getPropertyType().equals(Collection.class))
				binder.reader().fill(this, pd.getName());
		return (T)this;
	}
	
	public Individual asIndividual() {
		return binder.model().getIndividual(instanceURI(this));
	}
	
}
