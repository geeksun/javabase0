package com.base.file;

import java.io.File;

public class FileSize {
	public static void main(String [] i){
		File idr = new File("D:\\work\\abbcc\\WebRoot\\FCKeditor\\editor\\dialog\\fck_image\\fck_image.js");
		//File idr = new File("G:\\OracleSQL.txt");
		//File idr = new File("E:\\backup\\01-08-07_2028.jpg");//�ļ�62.5k��ʵ��ռ�ÿռ�64k
		System.out.println(idr.exists());
		//�����ļ����ֽ���bytes
		System.out.println(idr.length()); 
	}
	
}
