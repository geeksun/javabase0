package com.geeksun.string;

/**
 * @author Administrator
 * дһ��������ʵ���ַ����ķ�ת���磺����abc�����cba
 */
public class Reverse {
	public static String reverse(String s){
        int length=s.length();
        StringBuffer result=new StringBuffer(length);
        for(int i=length-1;i>=0;i--)
            result.append(s.charAt(i));
        return result.toString();
    }
	public static void main(String[] args){
		//Reverse r = new Reverse();
		System.out.println(reverse("abc"));
	}
}
