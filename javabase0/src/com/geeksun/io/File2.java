package com.geeksun.io;

import java.io.File;

public class File2 {
	public static void main(String[] args){
		File f = new File("G:\\SUN\\struts2.pdf");		// change to "G:\\SUN"
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());			// �Ƿ�Ŀ¼
		System.out.println("����:"+f.getName()+"Ŀ¼:"+f.getParent()+"·��:"+f.getPath()+"��С:"+f.length());
		System.out.println("------------File ����2--------------");
		File t = new File("D:\\");
		File[] tt = t.listFiles();					// �����ļ�Ŀ¼
		for(int i=0;i<tt.length;i++){
			if(tt[i].isDirectory()){
				System.out.print("Ŀ¼:");
				System.out.println(tt[i]);
			} 
			else{ 
				System.out.print("�ļ�:");
				System.out.println(tt[i]+" ��С:"+tt[i].length()+"bytes ������:"+tt[i].isHidden());
			}
		}
	}
}
