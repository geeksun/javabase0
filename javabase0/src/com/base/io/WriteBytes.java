package com.base.io;

import java.io.FileOutputStream;

/**
 * @author 姜志强
 *  在文件中写入字节
 *  2009-4-25
 */
public class WriteBytes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = {71, 73, 70, 56, 92, 92, 83, 19, 102, 298, 259, 0, 134, 92};
		try{
			//在原文件中追加数据而不覆盖
			FileOutputStream file = new FileOutputStream("op.txt", true);
			for(int i=0;i<data.length;i++){
				file.write(data[i]);
			}
			file.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
