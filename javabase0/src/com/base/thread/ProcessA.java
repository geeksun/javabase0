package com.base.thread;

import java.io.IOException;

/**
 * @author ��־ǿ
 * Process: ����,���ڽ��еĳ���
 * Process ����һ������ǰִ�еĽ�����ص���
 * 2008-3-1
 */
public class ProcessA {
	public static void main(String args[]) throws IOException, InterruptedException   
	{
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
