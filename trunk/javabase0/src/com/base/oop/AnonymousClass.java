package com.base.oop;

/**
 * @author Administrator
 * @version �����ڲ�����ΪΨһ������������,��Ķ��������Ĵ������ϲ���һ��
 * �����ڲ������ʵ�ֽӿڻ��Ǽ̳б����
 */
class Anony{
	public void hi(){
		System.out.println("hi?");
	}
	public void hello(){
		System.out.println("hello?");
	}
}
public class AnonymousClass {
	public static void main(String[] args){
		Anony aa = new Anony(){						//  �̳�Anony���������
			public void hi(){
				System.out.println("hi,you?");
		}
	};
	aa.hi();
	aa.hello();
	}												
}
