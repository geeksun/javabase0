package com.base.object;

/**
 * @author ½ªÖ¾Ç¿
 *  Char Öµ
 *  2009-4-27
 */
public class CharCase {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float x = 9;
		float y = 5;
		char c = '1';
		switch(c){
		case 1:
			x = x + 2;
		case 2:
			x = x + 3;
		default:
			x = x + 1;
		}
		System.out.print(x);
	}

}
