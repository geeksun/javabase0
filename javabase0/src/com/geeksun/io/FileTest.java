package com.geeksun.io;
import java.io.*;
/**
 * @author wave
 * @category File ���ṩ���ļ���Ŀ¼��ص���Ϣ
 */
public class FileTest {
	public static void main(String[] args){
		File file = new File("G:\\"); 
		File ff = new File("G:\\SUN\\name.txt");
		System.out.println(file.canRead());
		if(ff.exists()){   
			System.out.println("�ļ��Ѵ���");
		}
		else{
			try {
				ff.createNewFile();
				/*ff.createTempFile("name",".txt"); */
				System.out.println("�ļ��Ѵ���");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/*System.out.println(ff.deleteOnExit());*/   
		System.out.println(ff.delete());		// ɾ����ǰ������ָ�ļ�
	}
}  
