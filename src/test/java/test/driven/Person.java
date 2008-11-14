package test.driven;

import thewebsemantic.binding.RdfBeanId;

public class Person extends RdfBeanId<Person> {
	
	Language lang;

	public Language getLang() {
		return lang;
	}

	public void setLang(Language lang) {
		this.lang = lang;
	}
	
	
	
}
