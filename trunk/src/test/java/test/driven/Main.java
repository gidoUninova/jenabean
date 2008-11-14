package test.driven;

import com.hp.hpl.jena.rdf.model.ModelFactory;

import thewebsemantic.NotFoundException;
import thewebsemantic.binding.Jenabean;

public class Main {
	/**
	 * @param args
	 * @throws NotFoundException 
	 */
	public static void main(String[] args) throws NotFoundException {
		Jenabean.instance().bind(ModelFactory.createDefaultModel());
		Person p = new Person();
		p.setLang(Language.KOREAN);
		p.save();
		Jenabean.instance().model().write(System.out, "N3");
		
		
		Person p1 = p.load(p.id());
		System.out.println(p1.getLang());
	}
}
