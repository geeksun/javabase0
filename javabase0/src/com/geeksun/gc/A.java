package com.geeksun.gc;

/**
 * @author ��־ǿ
 *  ����������finalize, ��Ϊ finalize ����û���Զ�ʵ�ֵݹ���ã������ֶ�ʵ�֣��� super.finalize();
 *  ͨ�����ַ�ʽ�����ǿ���ʵ�ִ��µ��� finalize �ĵ��ã������ͷ��û����������Դ��Ȼ�����ͷŸ������Դ��ͨ��������
 *  finalize �������ͷ�һЩ�����׿��ơ����ҷǳ���Ҫ����Դ����IO���������ݵ����ӡ�
 *  2009-4-29
 */
public class A {
	Object a = null;
	
	public A(){
		a = new Object();
		System.out.println("���� a ����");
	}
	
	/* 
	 *  �ͷ�ϵͳ��Դ
	 */
	protected void destroy(){
		System.out.println("�ͷ� a ����\n");
		//�ͷ�������ռ�õ���Դ
		a = null;
	}
	
	protected void finalize() throws Throwable{
		//˫�����ڴ��ͷ�
		destroy();
		super.finalize();		//�ݹ���ó����е� finalize()
	}
	
}
