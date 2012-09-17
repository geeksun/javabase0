package com.base.pattern.factory;

public class FactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PersonFactory pf = new PersonFactory();
		Person p = null;
		
		p = pf.getPerson("chinese");
		System.out.println(p.sayHello("li"));
		p = pf.getPerson("kak");
		System.out.println(p.sayHello("li"));
	}
}
