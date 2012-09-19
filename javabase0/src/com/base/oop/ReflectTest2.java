package com.base.oop;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
class Temp2
{
	private int id;
	private String name;
	public Temp2(){}
	public Temp2(String s)
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
 *  ¸´ÔÓµÄ·´ÉäÀý×Ó
 */
public class ReflectTest2 {
	public static void main(String[] args) {
		Temp2 t1 = new Temp2("temp1");
		Temp2 t2 = new Temp2("temp2");

        Temp2 temp2 = new Temp2();
        try {

            Method t1Talk = t1.getClass().getMethod("talk", new Class[0]) ;
            Method t2Talk = t2.getClass().getMethod("talk", new Class[0]) ;
            t1Talk.invoke(t2, null);
            t2Talk.invoke(t1, null);
            if(t1Talk.equals(t2Talk)){
                System.out.println("equals");
            }
           else{
                System.out.println("not equals");
            }
            if(t1Talk==t2Talk){
                System.out.println("ref equals");
            }
           else{
                System.out.println("ref not equals");
            }
            t2Talk.invoke(temp2, null);
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
