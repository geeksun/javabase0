package com.base.pattern.adapter;

/**
 * @author ��־ǿ
 *  ���������ģʽ���������������������ģ��
 *  2009-5-18
 */
public class AdapterTest2 {

	public static void main(String[] args) {
		Adapter2 ada = new Adapter2();
		//�����������еķ�����ʵ�����ǵ���Ŀ�����еķ���
		ada.targetMethod();
		//�����������еķ�����ʵ�����ǵ��ñ����������еķ���
		ada.adapteeMethod();
	}

	
}
