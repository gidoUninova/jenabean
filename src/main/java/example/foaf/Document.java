package example.foaf;

import thewebsemantic.Namespace;
import thewebsemantic.Uri;

@Namespace(FoafUri.NS)
public class Document {
	String uri;
	public Document(String uri) {
		this.uri = uri;
	}
	
	@Uri
	public String uri() {
		return uri;
	}
	
	public String toString() {
		return uri;
	}
}
