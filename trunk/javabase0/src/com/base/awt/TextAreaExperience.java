package com.base.awt;

import java.awt.Frame;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ��־ǿ
 * @annotation: ʵ����DOS ���������ַ���������TextArea��ʾ�����Ĺ��ܡ������ϵ�277ҳ��
 * create at 2009-4-2
 */
public class TextAreaExperience {
	public static void main(String[] args) throws IOException {
		Frame f = new Frame("TextAreaExperience");
		TextArea ta = new TextArea(20, 60);
		
		String aline;
		
		System.out.println("����һ������,����Enter����");
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		label:while((aline = br.readLine())!=null){
			System.out.println("�������������,����Enter����");
			if(aline.equals("stop")){
				System.out.println("����");
				br.close();
				System.exit(1);		//��ֹ��ǰ���е����������0��ʾ�쳣��ֹ
				break;
			}
			ta.append(aline+'\n');
			//br.close();
			
			f.add(ta);
			f.pack();	//�Զ�����Frame�Ĵ�С,ʹ�������ʾ�������е����
			f.setVisible(true);
			
			continue label;
		}
		
		//br.close();
	}

}
