package com.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author jzq
 *  反射操作类
 *  Java语言允许通过程序化的方式间接的对Class操作，Class文件由类加载器加载后，在JVM中将形成一份描述Class的对象，通过该对象可以
 *  获知Class的结构信息，如构造函数，属性，方法等。 并分别通过Java实例对这些信息进行描述，Java允许用户通过这个Class相关的描述对
 *  象来间接调用类的功能。这就是为程序化方式操作Class文件提供了一个途径。 
 *  缺点：编译时错误难以发现，速度慢，代码冗余。
 *  2009-6-13
 */
public class Reflect {
	
	public Reflect(){}

	/**
	 *  通过反射生成 car 实例
	 *  我们完全可以通过编程的方式操作Class所提供的各项功能，这和直接通过构造函数和方法调用类功能的效果是一致的
	 */
	public Car ReflectCar() throws Throwable
	{
	   Car car = null;
	   //通过类加载器获得Car类对象, 获取当前线程的ClassLoader
	   ClassLoader carLoader = Thread.currentThread().getContextClassLoader();
	   //装载该Class的类反射实例
	   Class clazz = carLoader.loadClass("com.geeksun.reflect.Car");
	 
	   //获得类的默认构造器对象cons 并通过它实例化Car
	   Constructor cons = clazz.getDeclaredConstructor((Class[])null);
	   //这和直接通过构造函数和方法调用类功能的效果是一致的，效果等同于new Car()
	   car = (Car)cons.newInstance();
	 
	   //通过方法名与参数类型获得对象中的方法
	   Method SetName = clazz.getMethod("SetName",String.class);
	   
	   //反射调用实例中的方法, 等同于 SetName("宝马")
	   SetName.invoke(car, "宝马");
	   //System.out.println("invoke name:" + (String)SetName.invoke(car, "宝马"));
	   
	   Method SetColor = clazz.getMethod("SetColor",String.class);
	   SetColor.invoke(car, "红色");
	   Method SetPrice = clazz.getMethod("SetPrice",Double.class);
	   SetPrice.invoke(car, new Double(100));
	   
	   //调用无参方法
	   Method met = clazz.getMethod("execute", null);
	   String forward = car.getInvoker().invoke();
	   System.out.println("forward:"+forward);
	   //调用有返回值的无参方法,返回无参方法的返回值
	   String xxx = (String) met.invoke(car, null);
	   System.out.println("xxx:"+xxx);
	   
	   return car;
	}
	
	
}
