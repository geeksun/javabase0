package com.geeksun.io;
import java.io.*;
/**
 * @author wave
 * @category File 类提供与文件或目录相关的信息
 */
public class FileTest {
	public static void main(String[] args){
		File file = new File("G:\\"); 
		File ff = new File("G:\\SUN\\name.txt");
		System.out.println(file.canRead());
		if(ff.exists()){   
			System.out.println("文件已存在");
		}
		else{
			try {
				ff.createNewFile();
				/*ff.createTempFile("name",".txt"); */
				System.out.println("文件已创建");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/*System.out.println(ff.deleteOnExit());*/   
		System.out.println(ff.delete());		// 删除当前对象所指文件
	}
}  
