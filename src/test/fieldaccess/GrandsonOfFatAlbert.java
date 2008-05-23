package test.fieldaccess;

public class GrandsonOfFatAlbert extends SonOfFatAlbert {

	private String grandsonname = "grandson";
	
	public String toString() {
		return super.toString() + "\n" +grandsonname;
	}
}
