package example;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;
import thewebsemantic.Uri;

@Namespace("http://thewebsemantic.com/")
public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private Date birthday;
	private Collection<Person> ancestors;
	private String uri;
	
	public Person() {
		ancestors = new LinkedList<Person>();
	}
	
	public Person(String uri) {
		this();
		this.uri = uri;
	}

	@Uri
	public String uri() {
		return (uri != null) ? uri:	
			Person.class.getAnnotation(Namespace.class).value() + firstName + lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@RdfProperty(transitive=true, value = "hasAncestor")
	public Collection<Person> getAncestors() {
		return ancestors;
	}
	
	public void setAncestors(Collection<Person> ancestors) {
		this.ancestors = ancestors;
	}
	
	public void addAncestor(Person p) {
		ancestors.add(p);
	}
}
