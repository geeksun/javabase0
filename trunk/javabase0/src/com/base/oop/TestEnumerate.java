package com.base.oop;

/**
 * @author Administrator
 * @see ö�ٵĲ���
 */
public class TestEnumerate {
	public static void main(String[] args) {
		MyColors color = MyColors.red;
		for(MyColors option : color.values()) {
		  System.out.println(option);
		}
		/** ������switch���������дcase MyColors.red:
		  * ������������������ͨ��
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
