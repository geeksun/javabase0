package com.base.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author 姜志强
 *  从文件中读取对象流：串行化对象
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
		
		m = (Man) ois.readObject();		//将对象从流中读出， 需要强制类型转换
		
		ois.close();
		System.err.print("age:" + m.age);
		System.out.print("\nname:" + m.name);
		System.err.print("\nheight:" + m.height);
	}

}
