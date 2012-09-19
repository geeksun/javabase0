package com.base.gc;

public class B extends A {
	Object b = null;
	
	public B(){
		b = new Object();
		System.out.println("���� b ����");
	}
	
	/* 
	 *  �ͷ�ϵͳ��Դ
	 */
	protected void destroy(){
		//�ͷ�������ռ�õ���Դ
		System.out.println("�ͷ� b ����");
		b = null;
		super.destroy();
	}
	
	protected void finalize() throws Throwable{
		destroy();
		super.finalize();		//�ݹ���ó����е� finalize()
	}
	
}
