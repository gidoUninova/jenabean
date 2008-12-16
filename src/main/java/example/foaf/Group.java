package example.foaf;

import java.util.Collection;

import thewebsemantic.Namespace;

@Namespace(FoafUri.NS)
public class Group extends Agent {

	Collection<Agent> member;
	
	public Collection<Agent> getMember() {
		return member;
	}
	public void setMember(Collection<Agent> member) {
		this.member = member;
	}
	public Group(String uri) {
		super(uri);
	}

}
