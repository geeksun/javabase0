package com.geeksun.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author geeksun
 * @category DataOutputStream:继承了Filter Stream,可以输入基本数据类型的数据
 * 2009-5-6
 */
public class DataOutput {
	public static void main(String[] args) throws IOException{
		File f = new File("G:\\moon.txt");
		FileOutputStream fo = new FileOutputStream(f);
		DataOutputStream dop = new DataOutputStream(fo);
		
		dop.writeUTF("中国河北邯郸");
		dop.writeInt(33);
		dop.writeInt(332);
		dop.writeUTF("北京");
		
		dop.close();
		System.out.println("file create OK");
	}
}
