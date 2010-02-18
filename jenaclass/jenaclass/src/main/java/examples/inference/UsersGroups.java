package examples.inference;

import java.util.List;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;

public class UsersGroups {

	public static String domain = "http://examples.com/inference#";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
		
		OntClass Role = model.createClass(domain + "role");
		OntClass User = model.createClass(domain + "user");

		OntProperty hasMember = model.createOntProperty(domain + "hasMember");
		OntProperty hasRole = model.createOntProperty(domain + "hasRole");
		hasRole.setRange(Role);
		
		OntProperty hasUserRole = model.createOntProperty(domain + "hasUserRole");
		hasUserRole.setDomain(User);
		hasUserRole.setSuperProperty(hasRole);
		
		OntProperty parentRole = model.createOntProperty(domain + "parentRole");
		parentRole.setSuperProperty(hasRole);
		
		// create groups and hierachy
		OntResource developer_role = model.createOntResource(domain + "developer_role");
		OntResource technology_role = model.createOntResource(domain + "technology_role");
		OntResource employee_role = model.createOntResource(domain + "employee_role");
		OntResource sysadmin_role = model.createOntResource(domain + "sysadmin_role");
		
		developer_role.setPropertyValue(parentRole, technology_role);
		sysadmin_role.setPropertyValue(parentRole, technology_role);
		technology_role.setPropertyValue(parentRole, employee_role);
		
		// create users
		OntResource mark = model.createOntResource(domain + "mark");
		OntResource summer = model.createOntResource(domain + "summer");
		mark.setPropertyValue(hasUserRole, developer_role);
		summer.setPropertyValue(hasUserRole, sysadmin_role);
		hasRole.convertToTransitiveProperty();
		hasMember.setInverseOf(hasRole);
		
		// results
		printUser(mark);
		printUser(summer);
		printRole(employee_role);

		//model.writeAll(System.out, "N3", null);

	}
	
	private static void printRole(OntResource role) {
		System.out.println("role: " + role.getURI());
		OntProperty hasMember = role.getOntModel().getOntProperty(domain + "hasMember");
		List<RDFNode> members = role.listPropertyValues(hasMember).toList();
		for (RDFNode rdfNode : members) {
			System.out.println("\t" + rdfNode.asNode().getLocalName());
		}
		
	}

	public static void printUser(OntResource user) {
		System.out.println("user: " + user.getURI());
		List<Resource> types = user.listRDFTypes(false).toList();
		for (Resource resource : types)
			System.out.println("\tis a kind of " + resource);
		
		OntProperty hasRole = user.getOntModel().getOntProperty(domain + "hasRole");
		List<RDFNode> roles = user.listPropertyValues(hasRole).toList();
		for (RDFNode rdfNode : roles) 
			System.out.println("\thas role as " + rdfNode);
		
		
	}

}
