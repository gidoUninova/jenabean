package test.fieldaccess;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;
import thewebsemantic.binding.Jenabean;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestBasic {
	@Before
	public void setup() {
		System.setProperty("jenabean.fieldaccess", "true");
	}

	@Test
	public void simple() {
		Model m = ModelFactory.createDefaultModel();
		Bean2RDF writer = new Bean2RDF(m);
		GrandsonOfFatAlbert fa = new GrandsonOfFatAlbert();
		fa.grandsonname("grandson");
		fa.name("fieldaccess"); // this comes from the super super class
		fa.dontsaveme = "I don't get saved"; // this one is transient
		writer.save(fa);
		
		RDF2Bean reader = new RDF2Bean(m);
		Collection<GrandsonOfFatAlbert> results = reader
				.load(GrandsonOfFatAlbert.class);
		GrandsonOfFatAlbert bean = results.iterator().next();
		assertEquals("fieldaccess", bean.name());
		assertEquals("son", bean.sonname());
		assertEquals("grandson", bean.grandsonname());
		assertNull(bean.dontsaveme);
	}

	@Test
	public void type() {
		Model m = ModelFactory.createDefaultModel();
		m.setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
		m.setNsPrefix("", "http://test.fieldaccess/");
		m.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
		m.setNsPrefix("xsd","http://www.w3.org/2001/XMLSchema#");
		Jenabean.instance().bind(m);
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1967);
		for (int i = 0; i < 100; i++) {
			AllTypes bean = new AllTypes(i + "");
			bean.age = 40;
			bean.ssn = 444444444;
			bean.appointment = c;
			bean.birthday = d;
			bean.debt = 1000000.01;
			bean.salary = 1234.56f;
			bean.name = "Tyler Moon";
			bean.nicknames = new String[] { "bob", "doogy", "fats", "mo" };
			bean.nothing = 57;
			bean.save();
		}
		m.write(System.out, "N3");
		RDF2Bean reader = new RDF2Bean(m);
		Collection<AllTypes> beans = reader.load(AllTypes.class);
		assertEquals(100, beans.size());
		AllTypes bean2 = beans.iterator().next();
		assertEquals(40, bean2.age);
		assertEquals(444444444, bean2.ssn);
		assertEquals(1000000.01, bean2.debt, 0);
		assertEquals(d, bean2.birthday);
		//assertEquals(c, bean2.appointment);
	}
}
