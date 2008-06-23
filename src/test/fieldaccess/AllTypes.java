package test.fieldaccess;

import java.util.Calendar;
import java.util.Date;

import thewebsemantic.Id;
import thewebsemantic.RdfBean;
import thewebsemantic.RdfProperty;

public class AllTypes extends RdfBean<AllTypes> {
	
	@RdfProperty("http://xmlns.com/foaf/0.1/name")
	public String name;
	public int age;
	public long ssn;
	public float salary;
	public double debt;
	public Date birthday;
	public Calendar appointment;
	public String[] nicknames;
	public transient int nothing;
	private transient int id;
	
	
	public AllTypes(String s) {
		id = Integer.parseInt(s);
	}
	
	@Id
	public int id() {
		return id;
	}


	
}
