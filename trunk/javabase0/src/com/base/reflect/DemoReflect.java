package com.base.reflect;

/**
 * @author ��־ǿ
 * ����demo
 * 2009-4-25
 */
public class DemoReflect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReflectUtil ru = new ReflectUtil();
		Class<? extends ReflectUtil> keyClass = ru.getClass();		//�������������ӿ�
		System.err.print(keyClass.getName()); 	//�����ַ���
		
	}

}
