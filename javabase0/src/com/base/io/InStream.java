package com.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**@category FileInputStream: ���Դ��ļ��ж�ȡ���ݵ���
 * @author Administrator
 * @see
 */
public class InStream {
	public static void main(String[] args) throws IOException{
		File f = new File("G:\\sun.txt");
		FileInputStream fi = new FileInputStream(f);
		char a;
		
		/*for(int i = 0;i<f.length();i++){		// ��ȡ��������
			a = (char)fi.read();
			System.out.print(a);
		}
		fi.close();						// close FileInputStream,�ͷ��ڴ�*/
		int len = (int) f.length();
		byte[] b = new byte[len]; 		// ���������ļ���С���ֽ�����
		
		fi.read(b);						//  ���ļ��ж�ȡ��������,�������ֽ�������
		fi.close();
		
		for(int i=0;i<b.length;i++){
			System.out.print((char)b[i]);			// �轫int������ת��Ϊchar��
		}
	}
}
