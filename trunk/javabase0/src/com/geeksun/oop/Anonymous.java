package com.geeksun.oop;

/**@see 与其它内部类相比,使用匿名类可使代码变得简洁
 * @author Administrator
 * @version : 实现接口的匿名类
 */
interface Inner{
	public void f();
}
public class Anonymous {
	public static void main(String[] args){
		Inner in = new Inner(){			// 创建实现Inner接口的对象
			public void f(){
				System.out.println("fff");
			}
		};
		Inner ii = new Inner(){
			public void f(){
				System.out.println("iii");
			} 
		};
		in.f();
		ii.f();
	}
}
