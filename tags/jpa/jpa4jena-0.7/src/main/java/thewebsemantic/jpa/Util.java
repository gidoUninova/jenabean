package thewebsemantic.jpa;

import javax.persistence.EntityManager;

import com.hp.hpl.jena.rdf.model.Model;

public class Util {
	public static JBEntityManager concrete(EntityManager em) {
		return (JBEntityManager)em;
	}
	
	public static Model model(EntityManager em) {
		return concrete(em).getModel();
	}
	
	public static void write(EntityManager em) {
		model(em).write(System.out, "N3");
	}
}
