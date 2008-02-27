package test.bean;

import static org.junit.Assert.*;


import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;

import thewebsemantic.Bean2RDF;
import thewebsemantic.Namespace;
import thewebsemantic.NotFoundException;
import thewebsemantic.RDF2Bean;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class TestBean2Rdf {
	
	@Test
	public void testSimple() {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RDFS_INF);	
		final Bean2RDF writer = new Bean2RDF(m);
		KeepItSimple bean = new KeepItSimple();
		bean.setId("kisv1.1");
		bean.setValue(444);
		writer.save(bean);

	}
	
	@Test
	public void testExists() throws Exception {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RDFS_INF);	
		final Bean2RDF writer = new Bean2RDF(m);
		final User u = new User();
		writer.save(u);		
		RDF2Bean reader = new RDF2Bean(m);
		assertTrue(reader.exists(User.class, u.getScreenName()));
		assertFalse(reader.exists(User.class, "not there"));
	}

	@Test public void testThreads() throws Exception {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RDFS_INF);	
		final Bean2RDF writer = new Bean2RDF(m);
		
		final User u = new User();
		u.setEmail("email@place.com");
		u.setScreenName("123asdf");
		Profile p = new Profile("tcowan");
		p.setFirstName("First");
		p.setLastName("LastLastLast");
		u.setProfile(p);
		u.setScreenName("tcowan");
		Runnable t = new Runnable() {
			public void run() {
				for(int i=0; i<100; i++) {
					u.setScreenName(i + "");
					writer.save(u);
				}
			}
		};		
		new Thread(t).run();
		new Thread(t).run();
	}
	
	@Test public void testCycle() throws Exception {
		OntModel m = ModelFactory.createOntologyModel();	
		Bean2RDF writer = new Bean2RDF(m);
		A bean1 = new A("taylor");
		A bean2 = new A("lois");
		A bean3 = new A("jay");
		A bean4 = new A("mark");
		
		
		bean1.addFriend(bean2);
		bean2.addFriend(bean3);
		bean3.addFriend(bean4);
		bean4.addFriend(bean1);
		writer.save(bean1);
		writer.save(bean2);
		writer.save(bean3);
		writer.save(bean4);
		
		for (int i=0; i<100; i++)
			writer.save(new A("" + i));
		
		m.write(new FileWriter("tmp.rdf"));

		// read from file to ensure complete separation from first model
		m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
		m.read("file:tmp.rdf");
		RDF2Bean reader = new RDF2Bean(m);
		bean1 = reader.loadDeep(A.class, "taylor");
		assertEquals(2, bean1.getFriends().size());
		Collection<A> friends = bean1.getFriends();
		for (A a : friends)
			assertTrue(a.getId().equals("lois") || a.getId().equals("mark"));
		bean1 = reader.loadDeep(A.class, "lois");
		assertEquals(2, bean1.getFriends().size());
		friends = bean1.getFriends();
		for (A a : friends)
			assertTrue(a.getId().equals("taylor") || a.getId().equals("jay"));
		
		assertEquals(reader.load(A.class).size(), 104);
		
		
	}

	
	@Test public void testSymmetric2() throws Exception {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);	
		Bean2RDF writer = new Bean2RDF(m);
		SymmetricBean bean1 = new SymmetricBean("bean1");
		SymmetricBean adjacent1 = new SymmetricBean("adjacent1");
		SymmetricBean adjacent2 = new SymmetricBean("adjacent2");
		bean1.addAdjacent(adjacent1);
		bean1.addAdjacent(adjacent2);
		writer.save(bean1);
		RDF2Bean reader = new RDF2Bean(m);
		Collection<SymmetricBean> things = reader.load(SymmetricBean.class);
		assertEquals(3, things.size());
		
		SymmetricBean b = reader.loadDeep(SymmetricBean.class, "adjacent1");
		assertEquals(1, b.getAdjacent().size());
		for (SymmetricBean symmetricBean : b.getAdjacent()) {
			assertEquals("bean1", symmetricBean.getId());
		}
		
	}
	
	@Test public void testSymmetric() throws Exception {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);	
		Bean2RDF writer = new Bean2RDF(m);
		A bean1 = new A("taylor");
		A bean2 = new A("lois");
		bean1.addFriend(bean2);
		bean1.setName("Taylor");
		bean2.setName("Lois");
		bean2.setSalary(777.77f);
		writer.save(bean1);
		
		RDF2Bean reader = new RDF2Bean(m);
		Collection<A> friends = reader.loadDeep(A.class);
		assertEquals(2, friends.size());
		for (A a : friends) {
			assertEquals(1, a.getFriends().size());
			if ( a.getName() == "Taylor") {
				for (A b : a.getFriends()) {
					assertEquals("Lois", b.getName());
					assertEquals(777.77, b.getSalary(), .001);
				}
			}
		}
	}
	
	@Test 
	public void testAutoboxing() throws Exception {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
		Bean2RDF writer = new Bean2RDF(m);
		AutoBoxing bean = new AutoBoxing();
		for(int i=0; i<100; i++) {
			bean.addFoo(i);
			bean.addBar((char)i);
		}
		writer.save(bean);
		
		RDF2Bean reader = new RDF2Bean(m);
		Collection<AutoBoxing> results = reader.loadDeep(AutoBoxing.class);
		assertEquals(1, results.size());
		for (AutoBoxing box : results) {
			assertEquals(100, box.getFoo().size());
			assertEquals(100, box.getBar().size());
		}
		
	  
	}
	
	@Test
	public void testNonAnnotatedCollection() throws Exception {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
		Bean2RDF writer = new Bean2RDF(m);	
		
		Parent p = new Parent();
		p.addChild(new Unannotated());
		p.addChild(new Unannotated());
		p.addThing("thing one");
		p.addThing("thing two");
		writer.save(p);
		
		
	}
	
	@Test
	public void testUnannotated() throws Exception {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
		Bean2RDF writer = new Bean2RDF(m);
		writer.save(new Unannotated());
		RDF2Bean reader = new RDF2Bean(m);
		Collection<Unannotated> things = reader.load(Unannotated.class);	
		assertEquals(1, things.size());
	}
	
	@Test
	public void testNamespaces() throws Exception {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
		Bean2RDF writer = new Bean2RDF(m);
		AnnotationTester bean = new AnnotationTester();
		bean.setFullName("Jerry the Bee");
		bean.setEmail("an@email.com");
		writer.save(bean);
		
	}
	
	@Test
	public void testNotFound() throws Exception {
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);		
		RDF2Bean reader = new RDF2Bean(m);
		boolean caught = false;
		try {
			IdTesterBean bean = reader.loadDeep(IdTesterBean.class, "example");
			System.out.println(bean);
		} catch (NotFoundException e) {
			caught = true;
		} finally {
			assertTrue(caught);
		}
		Collection<IdTesterBean> c = reader.load(IdTesterBean.class);
		assertEquals(c.size(), 0);
	}
	
	@Test
	public void testId() throws Exception {
		IdTesterBean bean = new IdTesterBean();
		bean.setId("example");
		bean.setValue(17);
		
		String ns = IdTesterBean.class.getAnnotation(Namespace.class).value();
		
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
		Bean2RDF writer = new Bean2RDF(m);
		writer.save(bean);
		
		Individual i = m.getIndividual(ns + "bogus");
		assertEquals(null, i);
		i = m.getIndividual(ns + "IdTesterBean/" + bean.getId());
		assertNotNull(i);
		assertEquals(ns+"IdTesterBean/"+bean.getId(), i.getURI());
		
		RDF2Bean reader = new RDF2Bean(m);
		IdTesterBean bean2 = reader.loadDeep(IdTesterBean.class, "example");
		assertEquals(bean.getValue(), bean2.getValue());
		
		bean.setValue(1);
		writer.save(bean);
		bean2 = reader.loadDeep(IdTesterBean.class, "example");
		
		assertEquals(bean.getValue(), bean2.getValue());
		
	
	}
	
	@Test	
	public void testTypes() throws Exception {
		TypeTesterBean bean = new TypeTesterBean();
		Date aDate = new Date();
		double aDouble = 10.0987654321d;
		float aFloat = 10.0987654321f;
		int aInt = Integer.MAX_VALUE;
		long aLong = Long.MAX_VALUE;
		BigDecimal bd = new BigDecimal("1115.37");


		bean.setMyDate(aDate);
		bean.setMyDouble(aDouble);
		bean.setMyFloat(aFloat);
		bean.setMyInt(aInt);
		bean.setMyLong(aLong);
		bean.setMyChar('c');
		bean.setMyBoolean(true);
		bean.setMyCalendar(Calendar.getInstance());
		bean.setMyBigDecimal(bd);

		OntModel m = ModelFactory.createOntologyModel();
		Bean2RDF writer = new Bean2RDF(m);
		writer.save(bean);
		m.write(System.out, "N3");
		RDF2Bean reader = new RDF2Bean(m);
		TypeTesterBean bean2 = reader.loadDeep(TypeTesterBean.class, bean.hashCode());

		assertEquals(bean.getMyDate(), bean2.getMyDate());
		assertEquals(bean.getMyChar(), bean2.getMyChar());
		assertEquals(bean.getMyCalendar().getTime(), bean2.getMyCalendar().getTime());
		assertEquals(bean.getMyDouble(), bean2.getMyDouble(), .00);
		assertEquals(bean.getMyFloat(), bean2.getMyFloat(), .00);
		assertEquals(bean.getMyInt(), bean2.getMyInt());
		assertEquals(bean.getMyLong(), bean2.getMyLong());
		assertEquals(bean.isMyBoolean(), bean2.isMyBoolean());
		assertEquals(bean.getMyBigDecimal(), bean2.getMyBigDecimal());
		
		Collection<TypeTesterBean> results = reader.load(TypeTesterBean.class);
		assertEquals(1, results.size());
		for (TypeTesterBean b : results)
			assertEquals(aDate, b.getMyDate());
	}
	
	@Test
	public void testCollections() throws Exception {
		DeepBean bean = new DeepBean();
		bean.setSomeStringData("method annotation holds my > rdf property &");

		DeepBean b=null;
		for(int i=0; i<5; i++) {
			b = new DeepBean();
			b.setSomeStringData(i + " child of a bean");
			bean.addChildren(b);
		}
		// this tests cycle handling
		//b.addChildren(bean);
		OntModel m = ModelFactory.createOntologyModel();
		Bean2RDF writer = new Bean2RDF(m);
		writer.save(bean);
		writer.save(bean);
		
		RDF2Bean reader = new RDF2Bean(m);
		Collection<DeepBean> results = reader.load(DeepBean.class);
		for (DeepBean o : results)
			assertNotNull(o.getSomeStringData());
		assertEquals(6, results.size());
	}
	
	@Test
	public void testDeep() throws Exception {
		DeepBean bean = new DeepBean();
		bean.setSomeStringData("method annotation holds my > rdf property &");		
		OntModel m = ModelFactory.createOntologyModel();
		Bean2RDF writer = new Bean2RDF(m);
		writer.save(bean);	
		RDF2Bean reader = new RDF2Bean(m);		
		DeepBean bean2 = reader.loadDeep(DeepBean.class, bean.id());
		assertEquals(bean2.getSomeStringData(), bean.getSomeStringData());
	}
	
	 
	@Test
	public void testMeanBean() throws Exception {
		MeanBean bean = new MeanBean();
		bean.setSalary(1.001f);
		bean.setAge(40);
		bean.setCreated(new Date());
		
		OntModel m = ModelFactory.createOntologyModel();
		Bean2RDF writer = new Bean2RDF(m);
		writer.save(bean);	
		
		RDF2Bean reader = new RDF2Bean(m);
		
		MeanBean bean2 = reader.loadDeep(MeanBean.class, bean.id());
		assertEquals(bean.getAge(), bean2.getAge());
		assertEquals(bean.getSalary(), bean2.getSalary(), 2);
		assertEquals(bean.getCreated(), bean2.getCreated());
		
	}
	
	@Test
	public void testLoad() throws Exception {
		User u = new User("password", "a@email.com", "tcowan");
		Profile profile = new Profile(u.getScreenName());
		profile.setFirstName("Taylor");
		profile.setLastName("Cowan");
		u.setProfile(profile);
		
		OntModel m = ModelFactory.createOntologyModel();
		Bean2RDF writer = new Bean2RDF(m);
		writer.save(u);	
		RDF2Bean reader = new RDF2Bean(m);		
		User u2 = reader.loadDeep(User.class, "tcowan");
		assertEquals(u.getEmail(), u2.getEmail());
		assertEquals(u.getEncryptedPassword(), u2.getEncryptedPassword());
		assertEquals(u.getScreenName(), u2.getScreenName());

		Profile p2 =u2.getProfile();
		assertEquals(profile.getFirstName(), p2.getFirstName());
		assertEquals(profile.getLastName(), p2.getLastName());
	}

	@Test
	public void testBasic() throws Exception {
		User u = new User("password", "a@email.com", "tcowan");
		Profile profile = new Profile(u.getScreenName());
		profile.setFirstName("Taylor");
		profile.setLastName("Cowan");
		u.setProfile(profile);
		
		OntModel m = ModelFactory.createOntologyModel();
		Bean2RDF writer = new Bean2RDF(m);
		writer.save(u);
		Individual i = m.getIndividual("http://test#User/" + u.getScreenName());
		
		Property p = m.getProperty("http://test#" + "profile");
		assertNotNull(i);
		RDFNode n = i.getPropertyValue(p);
		Individual iProfile = (Individual)n.as(Individual.class);
		p = m.getProperty("http://test#" + "lastName");
		n = iProfile.getPropertyValue(p);
		assertNotNull(n);
		Literal value = (Literal)n.as(Literal.class);
		assertEquals(value.getString(), "Cowan");

		
		writer.save(u);
		writer.save(u);
		
		//update profile and expect the name to change when I save the User
		profile.setLastName("Smith");
		writer.save(u);
		
		i = m.getIndividual("http://test#User/" + u.getScreenName());
		assertNotNull(i);
		p = m.getProperty("http://test#" + "email");
		Literal l = (Literal)i.getPropertyValue(p);
		assertEquals(u.getEmail(), l.getString());
	
		p = m.getProperty("http://test#" + "screenName");
		l = (Literal)i.getPropertyValue(p);
		assertEquals(u.getScreenName(), l.getString());

		p = m.getProperty("http://test#" + "profile");
		n = i.getPropertyValue(p);
		iProfile = (Individual)n.as(Individual.class);
		p = m.getProperty("http://test#" + "lastName");
		n = iProfile.getPropertyValue(p);
		assertNotNull(n);
		value = (Literal)n.as(Literal.class);
		assertEquals("Smith", value.getString());
		
		u = new User("password", "b@email.com", "lcowan");
		writer.save(u);
		
	}
}
