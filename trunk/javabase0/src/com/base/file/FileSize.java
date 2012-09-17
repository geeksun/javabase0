package com.base.file;

import java.io.File;

public class FileSize {
	public static void main(String [] i){
		File idr = new File("D:\\work\\abbcc\\WebRoot\\FCKeditor\\editor\\dialog\\fck_image\\fck_image.js");
		//File idr = new File("G:\\OracleSQL.txt");
		//File idr = new File("E:\\backup\\01-08-07_2028.jpg");//文件62.5k，实际占用空间64k
		System.out.println(idr.exists());
		//返回文件的字节数bytes
		System.out.println(idr.length()); 
	}
	
}
