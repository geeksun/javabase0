package com.geeksun.md5;

public class Md5Test {
	public static void main(String args[]){
		String s = "geeksun";
		System.out.println(s);
		System.out.println("����MD5���ܺ����ɵ�����---" + MD5.toMD5(s));
		//  encrypt������
		System.out.println("sssss---" + MD5.toMD5("��־ǿ"));
		//System.out.println("1:"+MD5.encrypt("1"));
		/*c4ca4238a0b923820dcc509a6f75849b
		C4CA4238A0B923820DCC509A6F75849B*/
	}
}
