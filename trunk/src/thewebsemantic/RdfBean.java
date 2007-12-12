package thewebsemantic;

import thewebsemantic.binding.Binder;

public class RdfBean<T> {

	private Binder binder;
	
	public RdfBean() {
		binder = Binder.instance();
	}
	
	public static <E> E load(Class<E> c, String id) throws NotFoundException{
		return Binder.instance().reader().load(c, id);
	}
		
	public static <E> E load(Class<E> c, int id) throws NotFoundException {
		return Binder.instance().reader().load(c, id);
	}
	
	public void save() {
		binder.writer().save(this);
	}
	
	public Filler fill() {
		return binder.reader().fill(this);
	}
	
}
