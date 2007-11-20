package example.model;

import java.util.Collection;
import java.util.LinkedList;

import thewebsemantic.Id;
import thewebsemantic.Namespace;

@Namespace("http://example.org/")
public class Tag {
	private String name;
	private Collection<Post> members = new LinkedList<Post>();

	public Tag(String name) {
		this.name = name;
	}

	@Id
	public String getName() {
		return name;
	}

	public Collection<Post> getMembers() {
		return members;
	}

	public void setMembers(Collection<Post> members) {
		this.members = members;
	}
	
	public void addMember(Post p) {
		members.add(p);
	}

}
