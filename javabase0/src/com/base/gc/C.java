package com.base.gc;

public class C extends B {
	Object c = null;
	public C(){
		c = new Object();
		System.out.println("���� c ����");
	}
	
	protected void destroy(){
		c = null;
		//�ͷ��������Դ
		System.out.println("�ͷ� c ����");
		//�ͷŸ���ռ�õ���Դ
		super.destroy();
	}
	
	protected void finalize() throws java.lang.Throwable{
		destroy();
		//�ݹ���ø���� finalize()
		super.finalize();
	}
}
