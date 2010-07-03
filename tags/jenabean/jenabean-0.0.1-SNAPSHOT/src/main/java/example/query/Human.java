package example.query;

import java.net.URI;


import thewebsemantic.Id;
import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;

@Namespace("http://semanticbible.org/ns/2006/NTNames#")
public class Human {
	@Id
	public URI id;
	@RdfProperty("http://www.w3.org/2000/01/rdf-schema#label")
	public String label;
	@RdfProperty("http://www.w3.org/2000/01/rdf-schema#comment")
	public String comment;
	

}
