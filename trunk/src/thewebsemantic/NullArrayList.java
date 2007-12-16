package thewebsemantic;

import java.util.ArrayList;
import java.util.Collection;

public class NullArrayList<T> extends ArrayList<Object> {

	@Override
	public void add(int index, Object element) {
		
	}

	@Override
	public boolean add(Object e) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Object> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Object> c) {
		return false;
	}

	@Override
	public Object set(int index, Object element) {
		return element;
	}

	@Override
	public int size() {
		return 0;
	}
	
}
