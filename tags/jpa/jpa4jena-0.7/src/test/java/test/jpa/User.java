package test.jpa;

import javax.persistence.Id;

public class User {

	@Id String name;
	
	public User() {
		
	}
	
	public User(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
