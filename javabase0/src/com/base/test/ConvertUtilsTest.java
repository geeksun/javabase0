package com.base.test;

import org.apache.commons.beanutils.ConvertUtils;

public class ConvertUtilsTest {
	 public static void main(String[] args) {
	  Person person = new Person();
	  //将任意的实例转变为String，用法非常简单相当与调用toString()方法
	  System.out.println(ConvertUtils.convert(person));
	  
	  String str ="123456";
	  //int ss = Integer.parseInt(str);
	  Integer s =(Integer)ConvertUtils.convert(str,Integer.class);
	  System.out.println(s);
	  
	  String[] values = {"123","456","789","aafs"};
	  Object o = ConvertUtils.convert(values,Integer.class);
	  System.out.println(o);
	  
	  
	  /* run result:
	    Person.toString()...
	  	123456
	  	[Ljava.lang.Integer;@7bd9f2	*/
	  }
}
