package test.thing;

import java.util.Collection;

public interface Various {
	public Various setage(int i);
	public Various setmiles(long l);
	public Various addfloat(float f);
	public Various setdouble(double d);
	public Various setchar(char c);
	public Various setshort(short s);
	
	public Collection<Float> getfloat();
	public int getage();
	public long getmiles();
	public double getdouble();
	public char getchar();
	public short getshort();
	
}
