package com.base.pattern;

/**
 * @author 姜志强
 *  单例(singleton):一个类仅有一个实例，并提供一个访问它的全局访问点。这是为了解决多线程下, 有可能引发资源访问冲突的问题.
 *  例如：数据库连接池管理者, 比采用同步方式解决多线程资源访问冲突更能节省系统资源.
 *  2009-5-17  
 */
public class SingletonClass {
	//声明该类的实例属性
	private static SingletonClass instance = null;
	
	//私有构造函数
	private SingletonClass(){}
	
	/**
	 * 全局访问点： 可在访问修饰符前加 synchronized 关健字
	 * @return instance
	 */
	public static SingletonClass getInstance(){
		if(instance==null){
			instance = new SingletonClass();
		}
		return instance;
	}
	
	/**
	 *  为了保险起见在销毁这个对象时将各变量置为 null
	 */
	public void finalize(){
		instance = null;
	}
	
}
