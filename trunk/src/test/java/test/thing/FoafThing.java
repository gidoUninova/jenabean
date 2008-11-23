package test.thing;

import java.util.Collection;

import thewebsemantic.As;
import thewebsemantic.Namespace;
import thewebsemantic.Thing;

@Namespace("http://xmlns.com/foaf/0.1/")
public interface FoafThing extends As {
	
	public FoafThing addMade(Thing s);
	public FoafThing addMbox(Thing mbox);
	
	public Collection<Thing> getMade();
	public Collection<Thing> getMbox();

}
