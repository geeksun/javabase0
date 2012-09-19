package com.base.reflect;

/**
 * @author 姜志强
 * 反射demo
 * 2009-4-25
 */
public class DemoReflect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReflectUtil ru = new ReflectUtil();
		Class<? extends ReflectUtil> keyClass = ru.getClass();		//对象所属的类或接口
		System.err.print(keyClass.getName()); 	//类名字符串
		
	}

}
