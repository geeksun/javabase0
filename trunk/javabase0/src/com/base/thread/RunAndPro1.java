package com.base.thread;

import java.io.IOException;

/**
 * @author 姜志强
 * 运行时类的测试,Runtime类对象负责JVM运行平台的基本程序（非JAVA类）,也提供有关运行平台的信息。 
 * runtime object是一个只有在JAVA程序运行时才产生的对象，所以不能用NEW方法来创建，只能用Runtime类的getRuntime()来获取它
 * 2008-3-1
 */
public class RunAndPro1 {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec("c:\\windows\\notepad.exe");
		
		// 返回JVM可用的最大内存
		System.out.println("max memory: "+rt.maxMemory()+"bytes");
		// 返回JVM正在使用的全部内存
		System.out.println("total memory: "+rt.totalMemory()+"bytes");
		// 返回JVM可用的内存大小
		System.out.println("free memory: "+rt.freeMemory()+"bytes");
	}
}
