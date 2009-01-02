package thewebsemantic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import com.hp.hpl.jena.rdf.model.Resource;

public class LazySet implements Set {

	private transient ValuesContext ctx;
	private transient Resource i;
	private transient RDF2Bean reader;
	private Set data;

	public LazySet(Resource i, ValuesContext ctx, RDF2Bean r2b) {
		this.i = i;
		this.ctx = ctx;
		reader = r2b;
	}

	private void fill() {
		data = reader.lazySet(i, ctx);
	}

	public boolean add(Object e) {
		if (data == null)
			fill();
		return data.add(e);
	}

	public boolean addAll(Collection c) {
		if (data == null)
			fill();
		return data.addAll(c);
	}

	public void clear() {
		if (data == null)
			fill();
		data.clear();
	}

	public boolean contains(Object o) {
		if (data == null)
			fill();
		return data.contains(o);
	}

	public boolean containsAll(Collection c) {
		if (data == null)
			fill();
		return data.containsAll(c);
	}

	public boolean isEmpty() {
		if (data == null)
			fill();
		return data.isEmpty();
	}

	public Iterator iterator() {
		if (data == null)
			fill();
		return data.iterator();
	}

	public boolean remove(Object o) {
		if (data == null)
			fill();
		return data.remove(o);
	}

	public Object remove(int index) {
		if (data == null)
			fill();
		return data.remove(index);
	}

	public boolean removeAll(Collection c) {
		if (data == null)
			fill();
		return data.removeAll(c);
	}

	public boolean retainAll(Collection c) {
		if (data == null)
			fill();
		return data.retainAll(c);
	}

	public int size() {
		if (data == null)
			fill();
		return data.size();
	}

	public Object[] toArray() {
		if (data == null)
			fill();
		return data.toArray();
	}

	public Object[] toArray(Object[] a) {
		if (data == null)
			fill();
		return data.toArray(a);
	}

}
