package com.base.object;

/**
 * @author ��־ǿ
 *  ���򣬹�ʽ������һ�������в������磺8
 *  2009-4-27
 */
public class Formula {
	float xValue = (float) 1.5;
	int yValue = 3;
	
	public Formula(Object input){
		Integer zValue = Integer.parseInt(input.toString());
		float result = (xValue*yValue)/zValue.intValue();
		System.out.println(result);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object app = new Formula(args[0]);
	}

}
