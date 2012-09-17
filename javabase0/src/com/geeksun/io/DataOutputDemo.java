package com.geeksun.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ��־ǿ
 *  DataOutputStream �̳��� FilterOutputStream , ʵ���� DataOutput �ӿ�
 *  filter stream �������ڴ�������: char,int,double,String ������.InputStream �� OutputStream��
 *  byteΪ��λ��д����, �ܴ�����Щ��
 *  Demo ����ͼ�� ���� --> dos --> fos --> �ļ�
 *  2009-5-7
 */
public class DataOutputDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File f = new File("e://test.txt");
		FileOutputStream fos = new FileOutputStream(f);
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("��־ǿ");	//���ַ���"��־ǿ"��UTF��ʽд�������
		dos.writeInt(29);		//��int ������ 29 д�������
		dos.writeInt(130);
		dos.writeUTF("�й�");	
		
		dos.close();
		System.out.println("�ļ��Ѵ������");
	}

}
