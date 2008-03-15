package test.bean;

import java.util.LinkedList;

import org.junit.Test;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestCollections {
	@Test
	public void testIt() throws Exception {
		OntModel m = ModelFactory.createOntologyModel();	
		final Bean2RDF writer = new Bean2RDF(m);
		TestBean bean = new TestBean();
		java.util.List<String> l = new LinkedList<String>();
		l.add("one");
		l.add("two");
		l.add("three");
		bean.setStringList(l);
		bean.setId("1");
		String[] values = { "one", "two", "three" };
		bean.setStringArray(values);
		writer.save(bean);		
		RDF2Bean reader = new RDF2Bean(m);
		TestBean bean2 = reader.loadDeep(TestBean.class, "1");
		System.out.println(bean2.getStringList().iterator().next());
		System.out.println(bean2.getStringArray()[0]);
	}
}
