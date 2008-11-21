package test.thing;

import java.util.Collection;

public interface Various {
	public Various setAge(int i);
	public Various setMiles(long l);
	public Various addFloat(float f);
	
	public Collection<Float> getFloat();
	public int getAge();
	public long getMiles();
	
}
