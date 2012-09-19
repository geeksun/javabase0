package com.base.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;

class Person {
	 private String name;
	 private String sex;
	 private int age;
	 private Address address;
	 private List goods;
	 private Map contact;
	 
	 public Person() {
	 }
	 
	 public Person(String name) {
	  this.name = name;
	 }
	 
	 public Person(String name,String sex) {
	  this.name = name;
	  this.sex = sex;
	 }
	 
	 public String getName() {
	  return this.name;
	 }
	 
	 public void setName(String name) {
	  this.name = name;
	 }
	 
	 public String getSex() {
	  return this.sex;
	 }
	 
	 public void setSex(String sex) {
	  this.sex = sex;
	 }
	 
	 public int getAge() {
	  return this.age;
	 }
	 
	 public void setAge(int age) {
	  this.age = age;
	 }
	 
	 public Address getAddress() {
	  return this.address;
	 }
	 
	 public void setAddress(Address address) {
	  this.address = address;
	 }
	 
	 public List getGoods() {
	  return this.goods;
	 }
	 
	 public void setGoods(List goods) {
	  this.goods = goods;
	 }
	 
	 public Map getContact() {
	  return this.contact;
	 }
	 
	 public void setContact(Map contact) {
	  this.contact = contact;
	 }
	 
	 public void sayHello() {
	  System.out.println("Hello World!");
	 }
	 
	 public void f(String str) {
	  System.out.println("Person.f()..." + str);
	 }
	 
	 public String toString() {
	  return "Person.toString()...";
	 }
	}

class Address {
	 private String province;
	 private String city;
	 private String street;
	 private String zipcode;
	 
	 public String getProvince() {
	  return this.province;
	 }
	 
	 public void setProvince(String province) {
	  this.province = province;
	 }
	 
	 public String getCity() {
	  return this.city;
	 }
	 
	 public void setCity(String city) {
	  this.city = city;
	 }
	 
	 public String getStreet() {
	  return this.street;
	 }
	 
	 public void setStreet(String street) {
	  this.street = street;
	 }
	 
	 public String getZipcode() {
	  return this.zipcode;
	 }
	 
	 public void setZipcode(String zipcode) {
	  this.zipcode = zipcode;
	 }
	}


public class BeanUtilsTest {
	public static void main(String[] args) throws Exception {
	     Address address = new Address();
	     address.setProvince("hunan");
	     address.setCity("changsha");
	     address.setStreet("wuyilu");
	     address.setZipcode("410000");
	     
	     List goods = new ArrayList();
	     goods.add("sporting");
	     goods.add("singing");
	     goods.add("dancing");
	     
	     Map contact = new HashMap();
	     contact.put("student","Tom");
	     contact.put("teacher","Lucy");
	     
	     Person person = new Person();
	     person.setName("Mike");
	     person.setSex("male");
	     person.setAge(25);
	     person.setAddress(address);
	     person.setGoods(goods);
	     person.setContact(contact);
	     
	     //BeanUtilsTest.cloneBean(person);
	     //BeanUtilsTest.copyProperties(person);
	     //BeanUtilsTest.propertyUtilsCopyProperties(person);
	     //BeanUtilsTest.copyProperty(person);
	     //BeanUtilsTest.describe(person);
	     //BeanUtilsTest.propertyUtilsDescribe(person);
	     //BeanUtilsTest.getArrayProperty(person);
	     //BeanUtilsTest.getIndexedProperty(person);
	     //BeanUtilsTest.getMappedProperty(person);
	     //BeanUtilsTest.getNestedProperty(person);
	     //BeanUtilsTest.populate(person);
	     
	     //�õ�һ��bean��ָ�����Ե�ֵ���൱��getter
//	     System.out.println(BeanUtils.getProperty(person,"name"));
//	     //�޸�һ��bean��ָ�����Ե�ֵ���൱��setter
//	     BeanUtils.setProperty(person,"name","Tom");
//	     System.out.println(BeanUtils.getProperty(person,"name"));
//	     System.out.println("--------------------------------------");
//	     
	     BeanUtilsTest.invokeMethod();
//	     System.out.println("--------------------------------------");
//	     BeanUtilsTest.getAccessibleMethod();
//	     System.out.println("--------------------------------------");
//	     BeanUtilsTest.invokeConstructor();
//	     System.out.println("--------------------------------------");
	     BeanUtilsTest.getAccessibleConstructor();
	     
	    }
	    
	    //BeanUtils.cloneBean()--��¡Ŀ��bean
	    public static void cloneBean(Person person) throws Exception {
	     Person p = (Person)BeanUtils.cloneBean(person);
	     System.out.println(p.getAddress().getCity());
	     System.out.println(person.getAddress().getCity());
	     p.getAddress().setCity("hengyang");
	     System.out.println("---------------------------");
	     System.out.println(p.getAddress().getCity());
	     System.out.println(person.getAddress().getCity());
	     System.out.println(p.getAddress() == person.getAddress());
	    }
	    
	    //BeanUtils.copyProperties()--����Ŀ��bean�����Ե�ֵ���ܽ�������ת��
	    public static void copyProperties(Person person) throws Exception {
	     Person p = new Person();
	     BeanUtils.copyProperties(p,person);
	     System.out.println(p.getAddress().getCity());
	     System.out.println(person.getAddress().getCity());
	     p.getAddress().setCity("hengyang");
	     System.out.println("---------------------------");
	     System.out.println(p.getAddress().getCity());
	     System.out.println(person.getAddress().getCity());
	     System.out.println(p.getAddress() == person.getAddress());
	    }
	    
	    //PropertyUtils.copyProperties()--����Ŀ��bean�����Ե�ֵ�����ܽ�������ת��
	    public static void propertyUtilsCopyProperties(Person person) throws Exception {
	     Person p = new Person();
	     PropertyUtils.copyProperties(p,person);
	     System.out.println(p.getAddress().getCity());
	     System.out.println(person.getAddress().getCity());
	     p.getAddress().setCity("hengyang");
	     System.out.println("---------------------------");
	     System.out.println(p.getAddress().getCity());
	     System.out.println(person.getAddress().getCity());
	     System.out.println(p.getAddress() == person.getAddress());
	    }
	    
	    //BeanUtils.copyProperty()--����һ��ֵ��Ŀ��Bean��һ�����ԣ��ܽ�������ת��
	    public static void copyProperty(Person person) throws Exception {
	     Person p = new Person();
	     BeanUtils.copyProperty(p,"age","12");
	     System.out.println(p.getAge());
	    }
	    
	    //BeanUtils.describe()--�õ�һ��bean���������������ص���һ��map
	    public static void describe(Person person) throws Exception {
	     Map map = BeanUtils.describe(person);
	     Set set = map.keySet();
	     for(Iterator it = set.iterator(); it.hasNext(); ) {
	      Object o = it.next();
	      System.out.println(o + ": " + map.get(o));
	     }
	     System.out.println("--------------------------------------");
//	     Collection c = map.values();
//	     for(Object o : c) {
//	      System.out.println(o);
//	     }
	    }
	    
	    
	    //PropertyUtils.describe()--�õ�һ��bean���������������ص���һ��map
	    public static void propertyUtilsDescribe(Person person) throws Exception {
	     Map map = PropertyUtils.describe(person);
	     Set set = map.keySet();
	     for(Iterator it = set.iterator(); it.hasNext(); ) {
	      Object o = it.next();
	      System.out.println(o + ": " + map.get(o));
	     }
	     System.out.println("--------------------------------------");
//	     Collection c = map.values();
//	     for(Object o : c) {
//	      System.out.println(o);
//	     }
//	     System.out.println("----------------------------");
	    }
	    
	    //BeanUtils.populate()--ʹ��һ��mapΪbean��ֵ
	    public static void populate(Person person) throws Exception {
	     Map map = PropertyUtils.describe(person);
	     Person p = new Person();
	     BeanUtils.populate(p,map);
	     System.out.println(p.getName());
	     System.out.println(p.getSex());
	     System.out.println(p.getAge());
	     System.out.println(p.getAddress().getProvince());
	     System.out.println(p.getGoods().get(1));
	     System.out.println(p.getContact().get("student"));
	     System.out.println("--------------------------------------");
	    }
	    
	    //BeanUtils.getArrayProperty()--��Ŀ��bean��һ�����Ե�ֵת����һ���ַ�������
	    public static void getArrayProperty(Person person) throws Exception {
	     String[] array = BeanUtils.getArrayProperty(person,"goods");
	     for(int i=0;i<array.length;i++){
	     //for(String str : array) {
	      System.out.println(array[i]);
	     }
	    }
	    
	    //BeanUtils.getIndexedProperty()--���Լ���Ŀ��bean������򼯺����͵�����ָ��������ֵ
	    public static void getIndexedProperty(Person person) throws Exception {
	     System.out.println(BeanUtils.getIndexedProperty(person,"goods[0]"));
	     System.out.println(BeanUtils.getIndexedProperty(person,"goods",1));
	    }
	    
	    //BeanUtils.getMappedProperty()--���Լ���Ŀ��bean�о���map���͵������ж�Ӧ����ֵ
	    public static void getMappedProperty(Person person) throws Exception {
	     System.out.println(BeanUtils.getMappedProperty(person,"contact(student)"));
	     System.out.println(BeanUtils.getMappedProperty(person,"contact","teacher"));
	    }
	    
	    //BeanUtils.getNestedProperty()--�õ�Ŀ��bean��Ƕ�����Ե�ֵ
	    public static void getNestedProperty(Person person) throws Exception {
	     System.out.println(BeanUtils.getNestedProperty(person,"address.province"));
	    }
	    
	    //MethodUtils.invokeMethod()--��̬���÷���
	    public static void invokeMethod() throws Exception {
	     //MethodUtils.invokeMethod(Object arg1,String arg2,Object[] arg3)
	     //arg1 һ��bean������
	     //arg2 ָ��bean�ķ�����
	     //arg3 �����еĲ����б�
	     MethodUtils.invokeMethod(new Person(),"sayHello",new Object[]{});
	     //MethodUtils.invokeMethod(Object arg1,String arg2,Object arg3)
	     //arg1 һ��bean������
	     //arg2 ָ��bean�ķ�����
	     //arg3 �����еĲ���
	     MethodUtils.invokeExactMethod(new Person(),"f","hello");;
	    }
	    
	    //MethodUtils.getAccessibleMethod()--�õ�����
	    public static void getAccessibleMethod() throws Exception {
	     //MethodUtils.getAccessibleMethod(Class clazz,String methodName,Class[] parameterTypes)
	     //clazz һ��bean�������
	     //methodName bean�еķ�����
	     //parameterTypes �����в����������б�
	     System.out.println(MethodUtils.getAccessibleMethod(Person.class,"f",new Class[]{String.class}));
	     System.out.println(MethodUtils.getAccessibleMethod(Person.class,"f",String.class));
	    }
	    
	    //ConstructorUtils.invokeConstructor()
	    public static void invokeConstructor() throws Exception {
	     //ConstructorUtils.invokeConstructor(Class clazz,Object[] args)
	     //clazz һ��bean�������
	     //args bean�Ĺ��캯���Ĳ����б�
	     Person p1 = (Person)ConstructorUtils.invokeConstructor(Person.class,new Object[]{});
	     Person p2 = (Person)ConstructorUtils.invokeConstructor(Person.class,"Tom");
	     System.out.println(p2.getName());
	    }
	    
	    //ConstructorUtils.getAccessibleConstructor()
	    public static void getAccessibleConstructor() throws Exception {
	     //ConstructorUtils.getAccessibleConstructor(Class clazz,Class[] parameterTypes)
	     //clazz һ��bean�������
	     //parameterTypes bean�Ĺ��캯���Ĳ��������б�
	     System.out.println(ConstructorUtils.getAccessibleConstructor(Person.class,String.class));
	     System.out.println(ConstructorUtils.getAccessibleConstructor(Person.class,new Class[]{String.class,String.class}));
	    }

}
