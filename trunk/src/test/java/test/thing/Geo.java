package test.thing;

import thewebsemantic.As;
import thewebsemantic.Functional;
import thewebsemantic.Namespace;

@Namespace("http://www.w3.org/2003/01/geo/wgs84_pos#")
public interface Geo extends As {
	
	@Functional
	public Geo lat(float l);
	public Float lat();

	@Functional
	public Geo long_(float l);
	public Float long_();

}
