package com.base.pattern.adapter;

/**
 * @author 姜志强
 *  适配器测试(类继承适配器模式): 适配器(Adapter)：将一个类的接口转换成调用方希望的另外一个接口，从而解决两个已有接口之间不兼容的问题。
 *  使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 *  2009-5-18
 */
public class AdapterTest {

	public static void main(String[] args) {
		Adapter adapter = new Adapter();
		//调用目标接口中的方法
		adapter.targetMethod();
		
		//调用被适配器类中的方法
		adapter.adapteeMethod();
		
	}

}
