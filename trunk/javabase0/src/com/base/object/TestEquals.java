package com.base.object;
class A{
	
}
class B{
	/* 
	 * @see java.lang.Object#hashCode()
	 * 重写 hashCode 方法
	 */
	public int hashCode(){
		return 14285251;
	}
}
//equals用来按照自己的规则判断两个对象是否相等，而重写了equals后，按照java的惯例，就需要重写hashCode ，如在hibernate中
public class TestEquals {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		//14285251 10267414
		System.out.println(a.hashCode()+" "+b.hashCode());
		//System.out.println(a==b);
		//比较两个对象是否相等
		System.out.println(a.equals(b));
		
		String aa = "123";
		String bb = "123";
		//比较两个字符串内容是否相同
		System.out.println(aa==bb);
		
		
	}

	
	
	
	
	
}
