package test.bean;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Date;

import org.junit.Test;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestArrays {

	@Test public void basic() {
		TestArraysBean bean = new TestArraysBean();
		bean.setId("34fwe");
		Date d1 = new Date();
		Date d2 = new Date();
		Date d3 = new Date();
		Person p1 = new Person();
		p1.setFirstName("Amer");
		Person p2 = new Person();
		p2.setFirstName("Sam");
		Person p3 = new Person();
		p2.setFirstName("Surekha");
		bean.setAges(new int[] {1,2,3,4,5} );
		bean.setNames(new String[] {"bob", "sarah", "jimmy"});
		bean.setTimes(new Date[] {d1, d2, d3});
		bean.setPeople(new Person[] {p1,p2,p3});
		
		OntModel m = ModelFactory.createOntologyModel();	
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
	
		Bean2RDF writer = new Bean2RDF(m);
		writer.save(bean);

	
		
		RDF2Bean reader = new RDF2Bean(m);
		Collection<TestArraysBean>  beans = reader.load(TestArraysBean.class);
		assertEquals(1, beans.size());
		
		TestArraysBean loadedBean = beans.iterator().next();
		assertEquals(0, loadedBean.getAges().length);
		reader.fill(loadedBean).with("ages");
		assertEquals(5, loadedBean.getAges().length);
		reader.fill(loadedBean).with("people");
		for (Person p: loadedBean.getPeople()) {
			System.out.println(p.getFirstName());
		}
		reader.fill(loadedBean).with("times");
		for (Date d : loadedBean.getTimes()) {
			System.out.println(d);
		}
		
		bean.getAges()[0] = 100;
		writer.save(bean);
		m.write(System.out, "N3");
	}
}
