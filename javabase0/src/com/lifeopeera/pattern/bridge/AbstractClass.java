package com.lifeopeera.pattern.bridge;

/**
 * @author 姜志强
 *  抽象类
 *  2009-5-20
 */
public abstract class AbstractClass {
	//抽象方法
	public abstract void abstractMethod();
	
	/**
	 *  获取实现对象的方法
	 */
	public ImplInterface getImpl(int type){
		if(type==1){
			return new ConcreteImplA();
		}else if(type==2){
			return new ConcreteImplB();
		}else{
			return new ConcreteImplA();
		}
	}
	
}
