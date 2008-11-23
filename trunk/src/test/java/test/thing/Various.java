package test.thing;

import java.util.Collection;

public interface Various {
	public Various setAge(int i);
	public Various setMiles(long l);
	public Various addFloat(float f);
	public Various setDouble(double d);
	public Various setChar(char c);
	public Various setShort(short s);
	
	public Collection<Float> getFloat();
	public int getAge();
	public long getMiles();
	public double getDouble();
	public char getChar();
	public short getShort();
	
}
