package test.jpa;

import java.net.URI;

import javax.persistence.Entity;
import javax.persistence.Id;

import thewebsemantic.Namespace;

@Entity
@Namespace("http://example.org/")
public class MusicGenre {
	@Id URI id;
	String description;
}
