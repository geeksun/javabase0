package com.geeksun.test;

import java.util.Map;
class LazyDynaBean{
	private String property;
	private int variable;
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public int getVariable() {
		return variable;
	}
	public void setVariable(int variable) {
		this.variable = variable;
	}
	public void set(String s,String t){
		s = t;
	}
	public void set(String s,Integer i){
		s = String.valueOf(i);
	}
}
public class LazyDynaBeanTest {
	public static void main(String[] args) {
		  //����һ��LazyDynaBean��ʵ�������ͺ���ͨ��beanһ��
		     LazyDynaBean customer = new LazyDynaBean();
		     customer.set("name","Tom");
		     customer.set("sex","male");
		     customer.set("age",new Integer(25));
		     //��map��ʽ�����Ը�ֵ����һ�����������������ڶ��������Ǽ���������������ֵ
		    /* customer.set("address","province","hunan");
		     //���������һ������򼯺ϣ�������������ʽ��ֵ
		     //��һ���������������򼯺������ڶ�������������������������������ͼ����д��ֵ
		     customer.set("orders",0,"order001");
		     customer.set("orders",1,"order002");*/
		     
		    /* System.out.println("name: " + customer.get("name"));
		     System.out.println("sex: " + customer.get("sex"));
		     System.out.println("age: " + customer.get("age"));
		     System.out.println("address: " + ((Map)customer.get("address")).get("province"));
		     System.out.println("orders: " + customer.get("orders",0) + " " + customer.get("orders",1));*/
		     
		     
		     
		    }

}
