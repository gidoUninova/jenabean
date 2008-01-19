package test.bean;

import org.junit.Test;

import thewebsemantic.TypeWrapper;

public class TestTypeWrapper {

	@Test
	public void basic() {
		System.out.println(TypeWrapper.wrap(Person.class).inspect());
		System.out.println(TypeWrapper.wrap(Parent.class).inspect());
		System.out.println(TypeWrapper.wrap(Profile.class).inspect());
		System.out.println(TypeWrapper.wrap(City.class).inspect());
		System.out.println(TypeWrapper.wrap(Man.class).inspect());
	}
}
