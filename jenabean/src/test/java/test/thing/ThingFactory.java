package test.thing;

import thewebsemantic.Thing;

import org.apache.jena.rdf.model.Model;

public class ThingFactory {

	Model m;
	public ThingFactory(Model m) {
		this.m = m;
	}

	public Thing __(String string) {
		return new Thing(string, m);
	}

}
