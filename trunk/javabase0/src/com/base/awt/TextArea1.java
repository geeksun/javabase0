package com.base.awt;

import java.awt.Frame;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextArea1 {

	/**
	 * �����ı���
	 * @since jdk 1.5
	 * @param args 
	 * @throws IOException    
	 */
	public static void main(String[] args) throws IOException {
		Frame f = new Frame("�鿴�ļ�");
		TextArea ta = new TextArea(20, 50);		//show file content 
		String aline;							//������ļ��ж�ȡ������
		
		//System.out.println(class.getClassLoader().getResource("").getPath());
		System.err.println(System.getProperty("user.dir"));
				
		//ʹ�� BufferedReader, ÿ�δ��ļ��ж�ȡһ������
		BufferedReader br = new BufferedReader(new FileReader
			(
				"D:/work/mianshi/src/com/geeksun/awt/TextArea1.java")
			);
		
		while((aline=br.readLine())!=null)		//��ȡһ�����ݺ󣬴��� aline ��
			ta.append(aline + '\n'); 			//x1, �� aline �е�����׷���� ta β��
		
			br.close();							//�ر���
			
			f.add(ta);
			f.pack();				//�Զ�����Frame�Ĵ�С,ʹ�������ʾ�������е����
			f.setVisible(true);
		
	}

}
