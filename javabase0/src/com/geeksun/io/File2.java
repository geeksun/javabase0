package com.geeksun.io;

import java.io.File;

public class File2 {
	public static void main(String[] args){
		File f = new File("G:\\SUN\\struts2.pdf");		// change to "G:\\SUN"
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());			// 是否目录
		System.out.println("名称:"+f.getName()+"目录:"+f.getParent()+"路径:"+f.getPath()+"大小:"+f.length());
		System.out.println("------------File 测试2--------------");
		File t = new File("D:\\");
		File[] tt = t.listFiles();					// 读出文件目录
		for(int i=0;i<tt.length;i++){
			if(tt[i].isDirectory()){
				System.out.print("目录:");
				System.out.println(tt[i]);
			} 
			else{ 
				System.out.print("文件:");
				System.out.println(tt[i]+" 大小:"+tt[i].length()+"bytes 隐藏性:"+tt[i].isHidden());
			}
		}
	}
}
