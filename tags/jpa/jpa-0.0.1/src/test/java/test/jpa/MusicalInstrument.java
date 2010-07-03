package test.jpa;

import java.net.URI;

import javax.persistence.Id;

public class MusicalInstrument {
	URI id;
	String description;
	
	@Id
	public URI getId() {
		return id;
	}
	public void setId(URI id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
