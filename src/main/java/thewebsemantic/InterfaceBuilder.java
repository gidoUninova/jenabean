package thewebsemantic;

import java.util.List;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.vocabulary.RDFS;

public class InterfaceBuilder {
	OntModel m;
	private static String indent = "   ";

	public void create(String uri, String namespace, String type) {
		StringBuilder buffer = new StringBuilder();
		OntModel m = ModelFactory.createOntologyModel();
		m.read(uri);
		ExtendedIterator it = m.listOntProperties();
		List<OntProperty> props = it.toList();
		for (OntProperty ontProperty : props) {
			if (ontProperty.getNameSpace().equals(namespace)) {
				if (RDFS.Literal.equals(ontProperty.getRange())) {
					buffer.append(literalSetter(namespace, type, ontProperty));
					buffer.append("\n");
					buffer.append(literalGetter(namespace, type, ontProperty));
					buffer.append("\n");
				}
			}
		}
		System.out.println(buffer);
	}

	private Object literalGetter(String namespace, String type,
			OntProperty ontProperty) {
		return indent + "public String "
				+ ontProperty.getURI().substring(namespace.length()) + "();";
	}

	private String literalSetter(String namespace, String type,
			OntProperty ontProperty) {
		return functional(ontProperty) + indent + "public " + type + " "
				+ ontProperty.getURI().substring(namespace.length())
				+ "(String s);";
	}

	private String functional(OntProperty ontProperty) {
		return (ontProperty.isFunctionalProperty()) ? indent + "@Funtional\n" : "";
	}

	public static void main(String[] args) {
		new InterfaceBuilder().create("http://xmlns.com/foaf/spec/index.rdf",
				"http://xmlns.com/foaf/0.1/", "Foaf");
	}
}
