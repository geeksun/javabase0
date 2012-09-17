package com.geeksun.md5;

public class Md5Test {
	public static void main(String args[]){
		String s = "geeksun";
		System.out.println(s);
		System.out.println("经过MD5加密后生成的数据---" + MD5.toMD5(s));
		//  encrypt：加密
		System.out.println("sssss---" + MD5.toMD5("姜志强"));
		//System.out.println("1:"+MD5.encrypt("1"));
		/*c4ca4238a0b923820dcc509a6f75849b
		C4CA4238A0B923820DCC509A6F75849B*/
	}
}
