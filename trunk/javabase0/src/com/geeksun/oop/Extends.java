package com.geeksun.oop;
class Super{
	int a;
	Super(){
		a = 1;
	}
	Super(int a){
		this.a = a;
	}
}
/**
 * @author geeksun
 * @version ͨ��extends,�����ӵ�и����ȫ����Ա
 */
public class Extends extends Super{
	int b;
	Extends(int a,int b){
		super(a);												// ���Ӵ˷���ʱ,a����ֵ1
		this.b = b;
	}
	public static void main(String[] args){
		Extends ee = new Extends(21,44);
		System.out.println(ee.a + " " + ee.b);
	}
}
