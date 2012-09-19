package com.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**@category FileInputStream: 可以从文件中读取数据的流
 * @author Administrator
 * @see
 */
public class InStream {
	public static void main(String[] args) throws IOException{
		File f = new File("G:\\sun.txt");
		FileInputStream fi = new FileInputStream(f);
		char a;
		
		/*for(int i = 0;i<f.length();i++){		// 读取所有数据
			a = (char)fi.read();
			System.out.print(a);
		}
		fi.close();						// close FileInputStream,释放内存*/
		int len = (int) f.length();
		byte[] b = new byte[len]; 		// 创建容纳文件大小的字节数组
		
		fi.read(b);						//  从文件中读取所有数据,并放入字节数组中
		fi.close();
		
		for(int i=0;i<b.length;i++){
			System.out.print((char)b[i]);			// 需将int型数据转化为char型
		}
	}
}
