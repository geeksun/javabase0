package com.base.oop;

/**
 * @author Administrator
 * @see 枚举的测试
 */
public class TestEnumerate {
	public static void main(String[] args) {
		MyColors color = MyColors.red;
		for(MyColors option : color.values()) {
		  System.out.println(option);
		}
		/** 不能在switch语句里这样写case MyColors.red:
		  * 这样编译器不会让你通过
		  */
		switch(color){
			case red:
			System.out.println("best color is: "+MyColors.red);
			break;
			case black:
			System.out.println("NO: " + MyColors.black);
			break;
			default:
			System.out.println("What:");
			break;
		}
	}

}
