package com.jzq.core;

import java.io.IOException;

/**
 * @author ��־ǿ
 *  ����ʱ������
 */
public class RunTimeUtil {
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime rt = Runtime.getRuntime();
		System.out.println("���м��±�����");
		Process pr = rt.exec("c:\\windows\\notepad.exe");
		
		// �ȴ�������ֹ,������ֹ��,������ֵֹ�����Ϊ0�������������ֹ��
		int exitValue = pr.waitFor();
		
		System.out.println("���±�������ֹ.");
		//  �رռ��±�����ʱ,ִ����������
		System.out.println("��ֵֹ: "+exitValue);

	}

}
