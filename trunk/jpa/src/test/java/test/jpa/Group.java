package test.jpa;

import java.util.Set;

import javax.persistence.Id;

public class Group {
	
	Set<User> users;
	@Id String id;
	
	public Group() {
		
	}
	
	public Group(String name) {
		id = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
