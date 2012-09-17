package com.geeksun.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author ��־ǿ
 *  ������: �����л��Ķ���д���������ļ�
 *  2009-4-25
 */
public class Serialize1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileOutputStream fox = new FileOutputStream("G:/obj.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fox);
		
		Man m = new Man();
		m.name = "opera";
		m.age = 28;
		m.height = 83.8;
		
		oos.writeObject(m);		//������д����
		oos.close();
		System.err.print("�ѽ�����������ļ�");
	}

}
class Man implements Serializable{
	String name;
	int age;
	double height;
}