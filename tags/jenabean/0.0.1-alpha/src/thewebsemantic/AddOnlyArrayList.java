package thewebsemantic;

import java.util.ArrayList;

public class AddOnlyArrayList<T> extends ArrayList<Object> {

	private static final long serialVersionUID = -1709611655062980216L;

	@Override
	public Object remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	
}
