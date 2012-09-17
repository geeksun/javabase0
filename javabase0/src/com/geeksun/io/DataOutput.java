package com.geeksun.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author geeksun
 * @category DataOutputStream:�̳���Filter Stream,������������������͵�����
 * 2009-5-6
 */
public class DataOutput {
	public static void main(String[] args) throws IOException{
		File f = new File("G:\\moon.txt");
		FileOutputStream fo = new FileOutputStream(f);
		DataOutputStream dop = new DataOutputStream(fo);
		
		dop.writeUTF("�й��ӱ�����");
		dop.writeInt(33);
		dop.writeInt(332);
		dop.writeUTF("����");
		
		dop.close();
		System.out.println("file create OK");
	}
}
