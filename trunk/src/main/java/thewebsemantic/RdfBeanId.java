package thewebsemantic;

import java.rmi.server.UID;

public class RdfBeanId<T> extends RdfBean<T> {

	protected String id;

	public RdfBeanId() {
		this.id = new UID().toString();
	}

	public RdfBeanId(String id) {
		this.id = id;
	}

	@Id
	public String id() {return id;}

}
