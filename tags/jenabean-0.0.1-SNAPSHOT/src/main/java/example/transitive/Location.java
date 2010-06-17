package example.transitive;

import java.util.ArrayList;
import java.util.Collection;

import thewebsemantic.Id;
import thewebsemantic.RdfProperty;

public class Location {
	
	public String name;
	
	@Id
	public String id;
	
	@RdfProperty(transitive=true)
	public Collection<Location> within;
	
	@RdfProperty(inverseOf="within")
	public Collection<Location> contains;
	
	public Location(String id) {
		this();
		this.id = id;
	}
	
	public Location() {
		within = new ArrayList<Location>();
		contains = new ArrayList<Location>();
	}

}
