package com.base.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author ��־ǿ
 *  ���ļ��ж�ȡ�����������л�����
 *  2009-4-25
 */
public class Serialize2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("G://obj.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Man m;
		
		m = (Man) ois.readObject();		//����������ж����� ��Ҫǿ������ת��
		
		ois.close();
		System.err.print("age:" + m.age);
		System.out.print("\nname:" + m.name);
		System.err.print("\nheight:" + m.height);
	}

}
