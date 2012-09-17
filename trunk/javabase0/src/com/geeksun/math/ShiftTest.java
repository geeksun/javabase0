package com.geeksun.math;

/**
 * @author jzq
 * 位运算符
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
		//位与：全1为1，有0为0
		System.out.println(5&2);
		//位或：有1为1，全0为0
		System.out.println(5|2);
		//位异或：相同为0，相异为1
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
