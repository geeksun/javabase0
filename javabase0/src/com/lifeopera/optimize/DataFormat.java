package com.lifeopera.optimize;

import java.text.MessageFormat;

/**
 * @author ��־ǿ
 * ���ݸ�ʽ���������Ż�: ʹ�ò�������ʽ��������ͨ��Ԥ�����ʽ�����ݵı��ǣ� 63��157
 * 2009-5-17
 */
public class DataFormat {

	final static int N = 25000;
	
	/**
	 *  ���ò�������ʽ������
	 */
	public static void operatorFormat(){
		String s;
		
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=N;i++){
			s = "The square of " + i + " is " + (i*i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("���ò�������ʽ������:"+(endTime-startTime)+"ms");
	}
	
	/**
	 *  ����Ԥ����ķ�ʽ��ʽ������
	 */
	public static void precompileFormat(){
		Object argvec[] = new Object[2];
		MessageFormat f = new MessageFormat("The square of {0,number,#} is {1,number,#}");
		
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=N;i++){
			argvec[0] = new Integer(i);
			argvec[1] = new Integer(i*i);
			String s = f.format(argvec);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("����Ԥ����ķ�ʽ��ʽ������:"+(endTime-startTime)+"ms");
	}
	
	/**
	 *  ���ò�������ʽ������
	 */
	/*public static void operatorFormat(){
		String s;
		
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=N;i++){
			s = "The square of " + i + " is " + (i*i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("���ò�������ʽ������:"+(endTime-startTime)+"ms");
	}*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		operatorFormat();
		precompileFormat();
		
	}

}
