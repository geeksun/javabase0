package com.base.oop;

/**
 * @author Administrator
 * @version �������������÷�Χ�Ĳ���
 * ���������ñ��������÷�Χ=�̳��Ը���ĳ�Ա+�����и��Ǹ���ĳ�Ա
 */
public class ParentTest{
	public static void main(String[] args){
		Super2 ss = new Sub();
		ss.a = 22;
		ss.hi();															// �����и��Ǹ���ĳ�Ա����
	}
}
class Super2{
	int a = 10;
	void hi(){
		System.out.println("hii");
	}
}
class Sub extends Super2{ 
	int b = 20;
	void hi(){
		System.out.println("hi****");
	}
	void bye(){
		System.out.println("bye");																	
	}
}