package com.geeksun.test;

/**
 * @author jzq
 * ����˼�壺��String�����Խ��в���
 * 2009-4-28
 */
public class TestString {

	/**
	 * @param String a
	 * @param String b
	 * �����ַ���a �Ƿ�����ַ���b
	 */
	static final boolean testContain(String a, String b){
		boolean flag = false;
		int len1 = a.length();
		int len2 = b.length();
		int interval = len1 - len2;				//�ַ����ĳ��ȼ����� 8-3=5
		//int limit = len1 - interval;			//���Ƴ���, 8-5=3;  mistake
		
		for(int i=0;i<=interval;i++){
			//System.out.print("\nsubstring:"+a.substring(i, i+len2));
			if(a.substring(i, i+len2).equals(b)){
				flag = true;
			}
		}
		
		return flag;
	}
	
	/**
	 * @param String a
	 * @param String b
	 * �����ַ���a �Ƿ�����ַ���b, ʹ��String��indexOf()�ж�
	 */
	static final boolean testContain2(String a, String b){
		boolean flag = false;
		int value = a.indexOf(b);
		if(value!=-1)flag = true;
		return flag;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("\n contain:" + testContain("12345566", "5566"));
		System.out.print("\n contain:" + "12345566".contains("5566"));
		System.out.print("\n contain:" + testContain2("12345566", "5566"));
		
		
	}

}
