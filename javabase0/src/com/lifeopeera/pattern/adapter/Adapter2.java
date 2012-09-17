package com.lifeopeera.pattern.adapter;

/**
 * @author 姜志强
 *  组合适配器模式: 适用于整合遗留的软件模块
 *  2009-5-18
 */
public class Adapter2 {
	Adaptee adaptee = new Adaptee();
	Target2 target = new Target2();
	
	public void adapteeMethod(){
		//调用被适配类的方法
		adaptee.adapteeMethod();
	}
	
	public void targetMethod(){
		//调用目标方法
		target.targetMethod();
	}
	
}
