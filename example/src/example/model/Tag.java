package example.model;

import java.util.Collection;
import java.util.LinkedList;

import thewebsemantic.Id;

public class Tag {
	private String name;
	private Collection<Post> members = new LinkedList<Post>();

	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
