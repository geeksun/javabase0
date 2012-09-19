package com.base.oop;

public class StaticBlock {
	public StaticBlock()
	{
		System.out.println("new object");
	}
	static{
		System.out.println("static");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//  static block run earlier than construct  
		StaticBlock sb = new StaticBlock();
	}

}
