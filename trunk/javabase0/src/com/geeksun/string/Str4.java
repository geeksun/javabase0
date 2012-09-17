package com.geeksun.string;

public class Str4 {
	public static String handle(String s)
	{
		String temp = s.replaceAll("\"", "\" ");
	     int strLen = temp.split("\"").length - 1;
	     System.out.println(strLen);
	     return temp;
	}
	
	public static int getSpecialLength(String s)
	{
		int length = s.indexOf("\"");
		return length;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(handle("tes¡¢t\" be\"ijing"));
		System.out.println(getSpecialLength("\"atestiei"));
	}

}
