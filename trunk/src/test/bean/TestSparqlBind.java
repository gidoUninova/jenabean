package test.bean;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

public class TestSparqlBind {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		OntModel m = ModelFactory.createOntologyModel();
		Jenabean.instance().bind(m);
	}
	
	@Test
	public void test() {
		Man man = new Man("http://people/cslewis");
		man.setDescription("C.S. Lewis authored the Lion, Witch, and the Wardrobe");
		man.setName("C.S. Lewis");
		man.save();
		
		Jenabean jb = Jenabean.instance();
		Model m = jb.model();
		String queryString = 
			"SELECT ?s WHERE { ?s a <http://test.bean/Man>}";

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, m);
		try {
			ResultSet results = qexec.execSelect();
			for (;results.hasNext();) {
				Resource r = results.nextSolution().getResource("s");
				Man man2 = jb.reader().load(Man.class, r);
				assertEquals(man.getName(), man2.getName());
				assertEquals(man.getDescription(), man2.getDescription());

			}
		} finally {
			qexec.close();
		}
		
		
	}
	

}
