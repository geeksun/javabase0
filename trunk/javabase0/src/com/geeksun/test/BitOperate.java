package com.geeksun.test;

/**
 * @author jzq
 * & �� && ������
 * 
 */
public class BitOperate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 2 & 3;
		boolean l = false & true;	//&: λ�����
		System.out.println(i);
		System.out.println(l);
		
		boolean j = false && false;	//&&: �߼������, ��·�����, 
		System.out.println(j);
		
	}

}
