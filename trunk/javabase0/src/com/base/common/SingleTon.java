package com.base.common;

/**
 * @author geeksun
 * @version һ����̬��:˽�й��캯��;˽�о�̬����;˽�о�̬������
 */
public class SingleTon {
	private SingleTon(){}
	private static SingleTon instance = new SingleTon();
	public  static SingleTon getInstance()
	{
		return instance;
	}
	public static void main(String [] args){
		String s = "  ";								//  ���ַ���Ҳ�г��ȣ�ÿ���ո���һ��Ԫ��
		System.out.println(s.length());
	}
}
