package com.base.pattern.adapter;

/**
 * @author 姜志强
 *  组合适配器模式：适用于整合遗留的软件模块
 *  2009-5-18
 */
public class AdapterTest2 {

	public static void main(String[] args) {
		Adapter2 ada = new Adapter2();
		//调用适配器中的方法，实际上是调用目标类中的方法
		ada.targetMethod();
		//调用适配器中的方法，实际上是调用被适配器类中的方法
		ada.adapteeMethod();
	}

	
}
