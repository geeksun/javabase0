package com.geeksun.oop;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
class TempImpl
{
	private int id;
	private String name;
	public TempImpl(String s)
	{
		name = s;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void talk()
	{
		System.out.println("name: "+name);
	}
}
/**
 *  类反射与动态代理,JVM技术
 */
public class ReflectTest {
	public static void main(String[] args) {
		TempImpl t1 = new TempImpl("temp1");

        try {
        	//  调用 TempImpl 中的方法,talk 即为要调用的方法名
            Method t1Talk = t1.getClass().getMethod("talk", new Class[0]) ;
            t1Talk.invoke(t1, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
	}
}
