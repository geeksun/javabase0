package com.lifeopeera.pattern.adapter;

/**
 * @author ��־ǿ
 *  ���������ģʽ: �������������������ģ��
 *  2009-5-18
 */
public class Adapter2 {
	Adaptee adaptee = new Adaptee();
	Target2 target = new Target2();
	
	public void adapteeMethod(){
		//���ñ�������ķ���
		adaptee.adapteeMethod();
	}
	
	public void targetMethod(){
		//����Ŀ�귽��
		target.targetMethod();
	}
	
}
