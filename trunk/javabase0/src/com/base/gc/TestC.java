package com.base.gc;

/**
 * @author ��־ǿ
 *  ���� finalize() ���������Σ��������ʱ�����ܱ��������Ĭ�Ϲ������д�������ʼ�������Ķ��󣬷�ֹ�ڵ���������Ĺ�����
 *  ʱ��ɲ���Ҫ���ڴ���Դ�˷ѡ�
 *  2009-4-30
 */
public class TestC {
	C c = null;
	public TestC(){
		c = new C();
	}
	
	protected void destroy(){
		if(c!=null){
			c.destroy();
		}else{
			System.out.println("c �����ѱ��ͷ�");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestC tc = new TestC();
		tc.destroy();
		
	}

}
