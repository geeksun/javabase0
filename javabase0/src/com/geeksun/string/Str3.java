package com.geeksun.string;

public class Str3 {
	/**
	 * �ѡ�\��ת��������˵�
	 * @param a
	 * @return
	 */
	public static String replaceAllTest(String a)
	{
		String b = a.replaceAll("\"", "\" ");
		System.out.println(b);
		return b;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		replaceAllTest("ab,\"lek��uu");
	}

}
