package example;

import thewebsemantic.Bean2RDF;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;

public class AssemblerExample {
	public static void main(String[] args) {
		OntModel m = ModelFactory.createOntologyModel();
		m.read("file:src/example/java/example/assembler.n3", "N3");
		Bean2RDF writer = new Bean2RDF(m);
		
		Connection con = new Connection();
		con.setDbClass("some info goes here, I guess the driver");
		con.setDbPassword("my password");
		con.setDbType("ORACLE");
		con.setDbURL("URL 2 the db");
		con.setDbUser("semantic web user");
		RDBModel rdbModel = new RDBModel();
		rdbModel.setConnection(con);
		writer.save(rdbModel);
		m.write(System.out, "N3");
	}
}
