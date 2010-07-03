package test.jpa;

import java.net.URI;

import thewebsemantic.Namespace;

@Namespace("http://semanticbible.org/ns/2006/NTNames#")
public class Man extends Human {

	public Man() {}
	public Man(URI uri) {
		super(uri);
	}
}
