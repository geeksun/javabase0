package com.geeksun.math;

/**
 * @author jzq
 * λ�����
 * 2009-5-8
 */
public class ShiftTest {
	static int t = 0; 
	public ShiftTest(){
		t++;
		System.out.println(t);
	}
	
	String i = "3";
	
	public static void main(String[] args) {
		//λ�룺ȫ1Ϊ1����0Ϊ0
		System.out.println(5&2);
		//λ����1Ϊ1��ȫ0Ϊ0
		System.out.println(5|2);
		//λ�����ͬΪ0������Ϊ1
		System.out.println(5^2);
		
		ShiftTest st = new ShiftTest();
		System.out.println(st.toString());
	}
	
	/**
	 *  StackOverflowError
	 */
	public String toString(){
		  //return this + "@" + this.hashCode(); 
		return this + this.i; 
		
	} 
	
}
