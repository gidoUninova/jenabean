package thewebsemantic;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.hp.hpl.jena.rdf.model.Resource;

public class LazyList implements List {

	private transient ValuesContext ctx;
	private transient Resource i;
	private transient RDF2Bean reader;
	private List data;
	
	public LazyList(Resource i, ValuesContext ctx, RDF2Bean r2b) {
		this.i = i;
		this.ctx = ctx;
		reader = r2b;
	}

	private List data() {
		if ( data == null)
			data = reader.lazyList(i, ctx);
		return data;
	}

	public void add(int index, Object element) {
		data().add(index, element);
	}

	public boolean add(Object e) {
		return data().add(e);
	}

	public boolean addAll(Collection c) {
		return data().addAll(c);
	}

	public boolean addAll(int index, Collection c) {
		return data().addAll(index, c);
	}

	public void clear() {
		data().clear();
	}

	public boolean contains(Object o) {
		return data().contains(o);
	}

	public boolean containsAll(Collection c) {
		return data().containsAll(c);
	}

	public boolean equals(Object o) {
		return data().equals(o);
	}

	public Object get(int index) {
		return data().get(index);
	}

	public int hashCode() {
		return data().hashCode();
	}

	public int indexOf(Object o) {
		return data().indexOf(o);
	}

	public boolean isEmpty() {
		return data().isEmpty();
	}

	public Iterator iterator() {
		return data().iterator();
	}

	public int lastIndexOf(Object o) {
		return data().lastIndexOf(o);
	}

	public ListIterator listIterator() {
		return data().listIterator();
	}

	public ListIterator listIterator(int index) {
		return data().listIterator(index);
	}

	public Object remove(int index) {
		return data().remove(index);
	}

	public boolean remove(Object o) {
		return data().remove(o);
	}

	public boolean removeAll(Collection c) {
		return data().removeAll(c);
	}

	public boolean retainAll(Collection c) {
		return data().retainAll(c);
	}

	public Object set(int index, Object element) {
		return data().set(index, element);
	}

	public int size() {
		return data().size();
	}

	public List subList(int fromIndex, int toIndex) {
		return data().subList(fromIndex, toIndex);
	}

	public Object[] toArray() {
		return data().toArray();
	}

	public Object[] toArray(Object[] a) {
		return data().toArray(a);
	}
	

}
