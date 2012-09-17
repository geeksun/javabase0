package com.opera.pool;

/**
 * @author ��־ǿ
 *  �������
 *  2009-5-1 �Ͷ��ڿ���
 */
public class Man {
	private int age;
	private double weight;
	private String name;
	
	public Man(){}
	
	public Man(int age, double weight, String name){
		this.age = age;
		this.weight = weight;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void run(){
		System.out.println("Man is running");
	}
}
