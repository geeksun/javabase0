package com.base.inner;

/**
 * @author ��־ǿ
 *  �ڲ����÷���
 *  2009-5-17
 */
public class C {
	private String mainName = null;
	
	public void showMessage(){
		//�����в���ֱ�������ڲ����е��κγ�Ա, ������벻��ȷ
		/*innerName = "";
		innerMethod1();
		innerMethod2();*/
	}
	
	public void mainMethod() {
		
	}
	
	/**
	 *	���� C �е��ڲ���
	 */
	class InnerClass{
		private String innerName = null;
		
		public void innerMethod1(){
			//�������ڲ��������������˽�г�Ա
			mainName = "";
			mainMethod();
		}
		
		private void innerMethod2(){
			;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	

}
