package com.geeksun.oop;

/**@see �������ڲ������,ʹ���������ʹ�����ü��
 * @author Administrator
 * @version : ʵ�ֽӿڵ�������
 */
interface Inner{
	public void f();
}
public class Anonymous {
	public static void main(String[] args){
		Inner in = new Inner(){			// ����ʵ��Inner�ӿڵĶ���
			public void f(){
				System.out.println("fff");
			}
		};
		Inner ii = new Inner(){
			public void f(){
				System.out.println("iii");
			} 
		};
		in.f();
		ii.f();
	}
}
