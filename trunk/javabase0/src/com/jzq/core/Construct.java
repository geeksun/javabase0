package com.jzq.core;
/**
 * @author 姜志强
 * super类的构造函数不能被继承
 */
class F{
	public F()
	{
		System.out.println("88");
		view();
	}
	public void view()
	{
		System.out.print("9i");
	}
}
class C extends F{
	private int i = 10;
	public void view()
	{
		System.out.println("--"+i);
	}
}
public class Construct {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new C();
	}

}
