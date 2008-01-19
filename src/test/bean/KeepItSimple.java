package test.bean;
import thewebsemantic.Id;

public class KeepItSimple {
	private String id;
	private int value;
	public int getValue() {return value;}
	public void setValue(int i) {value = i;}
	@Id
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}	
}
