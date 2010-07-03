package thewebsemantic.jpa;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import thewebsemantic.TypeWrapper;

import com.hp.hpl.jena.rdf.model.Resource;

public class LazyResults implements List {

	List<Resource> resources;
	JBEntityManager em;
	
	public LazyResults(List<Resource> results, JBEntityManager em) {
		resources = results;
		this.em = em;
	}

	
	public boolean add(Object e) {
		throw new UnsupportedOperationException();
	}

	
	public void add(int index, Object element) {
		throw new UnsupportedOperationException();
	}

	
	public boolean addAll(Collection c) {
		throw new UnsupportedOperationException();
	}

	
	public boolean addAll(int index, Collection c) {
		throw new UnsupportedOperationException();
	}

	
	public void clear() {
		throw new UnsupportedOperationException();
	}

	
	public boolean contains(Object o) {
		
		return false;
	}

	
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Object get(int index) {
		Resource r = resources.get(index);
		return em._reader.load(r.getURI());
	}

	
	public int indexOf(Object o) {
		String uri = TypeWrapper.type(o).uri(o);
		Resource r = em._model.createResource(uri);
		return resources.indexOf(r);
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
