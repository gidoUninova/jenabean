package test.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String state;
    private String zip;
 
    public Address() {
    }
 
    public Address(final String sa1, final String sa2, final String city,
            final String state, final String zip) {
        setStreetAddress1(sa1);
        setStreetAddress2(sa2);
        setCity(city);
        setState(state);
        setZip(zip);
    }
 
    public final String getCity() {
        return city;
    }
 
    public final void setCity(final String city) {
        this.city = city;
    }
 
    public final String getState() {
        return state;
    }
 
    public final void setState(final String state) {
        this.state = state;
    }
 
    public final String getStreetAddress1() {
        return streetAddress1;
    }
 
    public final void setStreetAddress1(final String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }
 
    public final String getStreetAddress2() {
        return streetAddress2;
    }
 
    public final void setStreetAddress2(final String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }
 
    public final String getZip() {
        return zip;
    }
 
    public final void setZip(final String zip) {
        this.zip = zip;
    }
}