package com.base.common;

public class StringBufferTest {
	public static void main(String[] args){
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		operate(a,b);
		System.out.println(a.toString()+","+b);
	}
	public static void operate(StringBuffer x,StringBuffer y){
		y.append(x);
		y = x;						// �˴��ĸ�ֵ��ʵ������
	}
	
}
