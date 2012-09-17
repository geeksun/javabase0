package com.base.common;

public class ExtendsTest {
	public static void main(String[] args){
		A a = new A();
		A a2 = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		System.out.println(a.f(b));
		System.out.println(a.f(c));
		System.out.println(b.f(a2));
	}
}
	class A{
		String f(D o){
			return "D"+"T";
		}
		String f(A a){
			return "A"+"T";
		}
	}
	class B extends A{
		String f(B b){
			return "A"+"B";
		}
		String f(D o){
			return "B"+"D";
		}
	}
	class C extends B{
		
	}
	class D extends B{
		
	}
