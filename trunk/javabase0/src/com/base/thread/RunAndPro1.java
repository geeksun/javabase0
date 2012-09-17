package com.base.thread;

import java.io.IOException;

/**
 * @author ��־ǿ
 * ����ʱ��Ĳ���,Runtime�������JVM����ƽ̨�Ļ������򣨷�JAVA�ࣩ,Ҳ�ṩ�й�����ƽ̨����Ϣ�� 
 * runtime object��һ��ֻ����JAVA��������ʱ�Ų����Ķ������Բ�����NEW������������ֻ����Runtime���getRuntime()����ȡ��
 * 2008-3-1
 */
public class RunAndPro1 {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec("c:\\windows\\notepad.exe");
		
		// ����JVM���õ�����ڴ�
		System.out.println("max memory: "+rt.maxMemory()+"bytes");
		// ����JVM����ʹ�õ�ȫ���ڴ�
		System.out.println("total memory: "+rt.totalMemory()+"bytes");
		// ����JVM���õ��ڴ��С
		System.out.println("free memory: "+rt.freeMemory()+"bytes");
	}
}
