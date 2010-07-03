package test;

import java.util.Date;

import thewebsemantic.Id;
import thewebsemantic.Namespace;

@Namespace("http://example.org/")
public class TestArraysBean {
	
	private String[] names;
	private Date[] times;
	private int[] ages;
	private String id;

	public Date[] getTimes() {
		return times;
	}

	public void setTimes(Date[] times) {
		this.times = times;
	}

	public int[] getAges() {
		return ages;
	}

	public void setAges(int[] ages) {
		this.ages = ages;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
