package com.base.awt;

import java.awt.Frame;
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ��־ǿ
 * @annotation: ����List �����ʵ����ӣ�ɾ�����ܡ���ĿӦ����ʾ��List ����ϡ� �����ϵ�276ҳ��
 */
public class ListExercise {

	public static void main(String[] args) throws IOException {
		Frame f = new Frame("List Experience");
		List list = new List(8);
		
		System.out.println("����List��������ӻ�ɾ����Ŀ��Item������ʽΪ��add apple��remove apple");
		
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
			String aline;
			String[] str;
			label:while((aline=br.readLine())!=null){ 
				str = aline.split(" ");
				if(str[0].equals("add")){
					list.add(str[1]);
					f.add(list);
					f.pack();		//�Զ�����Frame�Ĵ�С,ʹ�������ʾ�������е����
					f.setVisible(true);
					System.err.println(str[1]+"�����ϣ�");
					System.err.println("��������в�����");
					continue label;
					/*break;*/
				}
				else if(str[0].equals("remove")){
					list.remove(str[1]);
					f.add(list);
					f.pack();
					f.setVisible(true);
					System.err.println(str[1]+"ɾ�����");
					System.err.println("��������в�����");
					continue label;
					//break;
				}
				else{
					System.err.println("��ʽ����ȷ��");
					break;
				}
			}
			
			System.err.println("xun��");
		
	}

}
