package com.base.pattern.bridge;

/**
 * @author 姜志强
 *  桥梁模式: 
 *  2009-5-21
 */
public class BridgeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建具体对象 A 的实例，并且通过其构造器指定实现的类型为 ConcreteImplA
		ConcreteObjectA con = new ConcreteObjectA(1);
		//调用具体对象 A 的方法
		con.abstractMethod();
		//并引用 ConcreteImplA 的方法
		con.getImpl(1).implMethod();	
		
		//创建具体对象 A 的实例，并且通过其构造器指定实现的类型为 ConcreteImplB
		ConcreteObjectA con2 = new ConcreteObjectA(2);
		//调用具体对象 A 的方法，并引用 ConcreteImplB 的方法
		con2.abstractMethod();
		
		//创建具体对象 B 的实例，并且通过其构造器指定实现的类型为 ConcreteImplA
		ConcreteObjectB co = new ConcreteObjectB(1);
		//调用具体对象 B 的方法，并引用 ConcreteImplA 的方法
		co.abstractMethod();
		
		//创建具体对象 B 的实例，并且通过其构造器指定实现的类型为 ConcreteImplB
		ConcreteObjectB co2 = new ConcreteObjectB(2);
		//调用具体对象 B 的方法，并引用 ConcreteImplB 的方法
		co2.abstractMethod();
	}

}
