package test.driven;

import com.hp.hpl.jena.rdf.model.ModelFactory;

import thewebsemantic.binding.Jenabean;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jenabean.instance().bind(ModelFactory.createDefaultModel());
		Person p = new Person();
		p.setLang(Language.KOREAN);
		
		p.save();
		
		Jenabean.instance().model().write(System.out, "N3");
	}
}
