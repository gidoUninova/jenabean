package thewebsemantic.lazy;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


import com.hp.hpl.jena.rdf.model.Resource;

@SuppressWarnings("unchecked")
public class LazySet implements Set, Lazy {

	private transient Resource i;
	private transient Provider reader;
	private Set data;
	private String propertyUri;
	private Class type;

	public LazySet(Resource i, String propertyUri, Class type, Provider r2b) {
		this.i = i;
		this.propertyUri = propertyUri;
		this.type = type;
		reader = r2b;
	}

	private void fill() {
		data = reader.lazySet(i, propertyUri, type);
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

	public boolean isConnected() {
		return data != null;
	}

}
