package example;

import thewebsemantic.RdfBean;
import thewebsemantic.RdfProperty;
import thewebsemantic.Uri;

public class Man extends RdfBean<Man>{

	private String name;
	private String description;
	private String uri;
	
	public Man(String uri) {
		this.uri = uri;
	}
	
	@Uri
	public String uri() {
		return uri;
	}
	
	@RdfProperty(NTNames.name_en_PROPERTY)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@RdfProperty(NTNames.description_PROPERTY)
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
