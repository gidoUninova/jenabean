package test;

import static org.junit.Assert.*;

import org.junit.Test;

import thewebsemantic.TypeWrapper;

public class TypeWrapperTests {
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
		assertEquals("http://test#DeepBean", t1.rdfTypeName());
		
	}
}
