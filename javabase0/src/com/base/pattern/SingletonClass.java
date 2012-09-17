package com.base.pattern;

/**
 * @author ��־ǿ
 *  ����(singleton):һ�������һ��ʵ�������ṩһ����������ȫ�ַ��ʵ㡣����Ϊ�˽�����߳���, �п���������Դ���ʳ�ͻ������.
 *  ���磺���ݿ����ӳع�����, �Ȳ���ͬ����ʽ������߳���Դ���ʳ�ͻ���ܽ�ʡϵͳ��Դ.
 *  2009-5-17  
 */
public class SingletonClass {
	//���������ʵ������
	private static SingletonClass instance = null;
	
	//˽�й��캯��
	private SingletonClass(){}
	
	/**
	 * ȫ�ַ��ʵ㣺 ���ڷ������η�ǰ�� synchronized �ؽ���
	 * @return instance
	 */
	public static SingletonClass getInstance(){
		if(instance==null){
			instance = new SingletonClass();
		}
		return instance;
	}
	
	/**
	 *  Ϊ�˱�������������������ʱ����������Ϊ null
	 */
	public void finalize(){
		instance = null;
	}
	
}
