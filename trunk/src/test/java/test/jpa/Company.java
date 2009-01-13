package test.jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
 
@Entity
public class Company {

    int id;
    private String name;
    private Address address;
    private Collection<Person> employees;
 
    public Company() {
    }
 
    public Company(final String name, final Address address,
            final Collection<Person> employees) {
        setName(name);
        setAddress(address);
        setEmployees(employees);
    }
 
    public Address getAddress() {
        return address;
    }
 
    public void setAddress(final Address address) {
        this.address = address;
    }
 
    public Collection<Person> getEmployees() {
        if (employees == null) {
            employees = new ArrayList<Person>();
        }
        return employees;
    }
 
    public void setEmployees(final Collection<Person> employees) {
        this.employees = employees;
    }
 
    @Id
    public int getId() {
        return id;
    }
 
    public void setId(final int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(final String name) {
        this.name = name;
    }
 
    public void hire(final Person p) {
        getEmployees().add(p);
    }
 
    public void fire(final Person p) {
        if (!getEmployees().remove(p)) {
        	throw new RuntimeException("not found");
        }
    }
}

