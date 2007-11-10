package test;

import static org.junit.Assert.*;

import org.junit.Test;

import thewebsemantic.TypeWrapper;

public class TypeWrapperTests {
	
	@Test
	public void testUri2() {
		TypeWrapper t1 = TypeWrapper.get(TestUriBean.class);
		TestUriBean bean = new TestUriBean();
		bean.setAddress("123 barcamp drive");
		bean.setCity("JenaTown");
		bean.setCountry("GB");
		assertEquals(bean.theUriMethod(), t1.uri(bean));
		
		
	}
	
	@Test
	public void testBasic() {
		// check caching (there can only be one)
		TypeWrapper t1 = TypeWrapper.get(DeepBean.class);
		TypeWrapper t2 = TypeWrapper.get(DeepBean.class);
		assertTrue(t1 == t2);
		t2 = TypeWrapper.get(MeanBean.class);
		assertFalse(t1 == t2);		
	}
	
	/**
	 * uri generation tests
	 */
	@Test
	public void testUri() {
		TypeWrapper t1 = TypeWrapper.get(DeepBean.class);
		assertEquals("http://test#DeepBean", t1.typeUri());
		
	}
}
