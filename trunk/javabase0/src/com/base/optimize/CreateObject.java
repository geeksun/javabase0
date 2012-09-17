package com.base.optimize;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author ��־ǿ
 *  ���������Ӧ�ù���
 *  ��������ʱ������ѭ�����������������󣬼�ʹ�ö���ռ���ڴ�ռ䲻��
 *	������ʱʹ��������������ձ�׼��
 *	��Ҫ���ù���ļ̳в�Ρ�
 *	���ʱ��ر������ڷ������еı�����
 *	��Ҫ��һ�������ʼ����Ρ�����A, B��
 *	��Ҫ��ǰ���������ظ��ķ��䡢���������ܻ�����������������Ĺ���������ϵͳ���ܡ�
 *	2009-4-28
 */
public class CreateObject {
	private Map table = new Hashtable();
	
	/**
	 *  ��Ҫ��һ�������ʼ����Σ�����������ϴ���ڴ濪��������ϵͳ���ܡ�
	 */
	public CreateObject(){
		/*correct code: ���� table ���д���
		 * */
		//��table �����ʼ��������
		table = new Hashtable();
	}
	
	/**
	 *  ��������ʱ������ѭ�����������������󣬼�ʹ�ö���ռ���ڴ�ռ䲻��
	 *  �������˷ѽϴ���ڴ�ռ䣨�ڴ����϶����ʱ��,��Ϊ�ᴴ���ܶ����������ã�����JVM���������յĸ��ɡ�
	 */
	static void refuseOne(){
		/*  correct code: Object obj = null;   �������ڴ���ֻ����һ�ݶԸö��������
		for(int i=0;i<10000;i++){
			obj = new Object();
			System.out.print("\nobj:" + obj);
		}*/
		long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			Object obj = new Object();
			System.out.print("\nobj:" + obj);
		}
		long end = System.currentTimeMillis();
		System.err.print("Consume Time:" + (end-start));
		
	}
	
	static void refuseTwo(){
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		refuseOne();
		
		
	}

}
