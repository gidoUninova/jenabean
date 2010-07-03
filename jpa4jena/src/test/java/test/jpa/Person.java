package test.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
 
@Entity
public class Person {

    int id;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private Address address;
 
    public Person() {
    }
 
    public Person(final String fn, final char mi, final String ln,
            final Address address) {
        setFirstName(fn);
        setMiddleInitial(mi);
        setLastName(ln);
        setAddress(address);
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
 
    @Id
    public int getId() {
        return id;
    }
 
    public void setId(final int id) {
        this.id = id;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
 
    public char getMiddleInitial() {
        return middleInitial;
    }
 
    public void setMiddleInitial(final char middleInitial) {
        this.middleInitial = middleInitial;
    }
 
    public final Address getAddress() {
        return address;
    }
 
    public final void setAddress(final Address address) {
        this.address = address;
    }

	@Override
	public boolean equals(Object obj) {
		if ( obj == null) return false;
		if ( this == obj ) return true;
		if ( !(obj instanceof Person) ) return false;
		return ( ((Person)obj).id == id);
	}
	
	public int hashCode() {
		return id;
	}
	

    
    
}