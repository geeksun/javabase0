package com.base.serilizable;

import java.io.Serializable;

/**
 * @author jzq
 *  业务对象
 */
public class DomainObject implements Serializable {
	 private String name;  
	 private int age ;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}  
	 
}
