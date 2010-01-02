package test.jpa;

import thewebsemantic.jpa.FlushListener;

public class Counter implements FlushListener {

	public int count=0;

	public void notify(Object obj) {
		count++;
	}

}
