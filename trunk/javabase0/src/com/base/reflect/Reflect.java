package com.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author jzq
 *  ���������
 *  Java��������ͨ�����򻯵ķ�ʽ��ӵĶ�Class������Class�ļ�������������غ���JVM�н��γ�һ������Class�Ķ���ͨ���ö������
 *  ��֪Class�Ľṹ��Ϣ���繹�캯�������ԣ������ȡ� ���ֱ�ͨ��Javaʵ������Щ��Ϣ����������Java�����û�ͨ�����Class��ص�������
 *  ������ӵ�����Ĺ��ܡ������Ϊ���򻯷�ʽ����Class�ļ��ṩ��һ��;���� 
 *  ȱ�㣺����ʱ�������Է��֣��ٶ������������ࡣ
 *  2009-6-13
 */
public class Reflect {
	
	public Reflect(){}

	/**
	 *  ͨ���������� car ʵ��
	 *  ������ȫ����ͨ����̵ķ�ʽ����Class���ṩ�ĸ���ܣ����ֱ��ͨ�����캯���ͷ��������๦�ܵ�Ч����һ�µ�
	 */
	public Car ReflectCar() throws Throwable
	{
	   Car car = null;
	   //ͨ������������Car�����, ��ȡ��ǰ�̵߳�ClassLoader
	   ClassLoader carLoader = Thread.currentThread().getContextClassLoader();
	   //װ�ظ�Class���෴��ʵ��
	   Class clazz = carLoader.loadClass("com.geeksun.reflect.Car");
	 
	   //������Ĭ�Ϲ���������cons ��ͨ����ʵ����Car
	   Constructor cons = clazz.getDeclaredConstructor((Class[])null);
	   //���ֱ��ͨ�����캯���ͷ��������๦�ܵ�Ч����һ�µģ�Ч����ͬ��new Car()
	   car = (Car)cons.newInstance();
	 
	   //ͨ����������������ͻ�ö����еķ���
	   Method SetName = clazz.getMethod("SetName",String.class);
	   
	   //�������ʵ���еķ���, ��ͬ�� SetName("����")
	   SetName.invoke(car, "����");
	   //System.out.println("invoke name:" + (String)SetName.invoke(car, "����"));
	   
	   Method SetColor = clazz.getMethod("SetColor",String.class);
	   SetColor.invoke(car, "��ɫ");
	   Method SetPrice = clazz.getMethod("SetPrice",Double.class);
	   SetPrice.invoke(car, new Double(100));
	   
	   //�����޲η���
	   Method met = clazz.getMethod("execute", null);
	   String forward = car.getInvoker().invoke();
	   System.out.println("forward:"+forward);
	   //�����з���ֵ���޲η���,�����޲η����ķ���ֵ
	   String xxx = (String) met.invoke(car, null);
	   System.out.println("xxx:"+xxx);
	   
	   return car;
	}
	
	
}
