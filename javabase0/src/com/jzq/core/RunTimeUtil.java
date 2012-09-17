package com.jzq.core;

import java.io.IOException;

/**
 * @author 姜志强
 *  运行时工具类
 */
public class RunTimeUtil {
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime rt = Runtime.getRuntime();
		System.out.println("运行记事本程序");
		Process pr = rt.exec("c:\\windows\\notepad.exe");
		
		// 等待进程中止,进程中止后,返回终止值。如果为0，则表明正常中止。
		int exitValue = pr.waitFor();
		
		System.out.println("记事本程序终止.");
		//  关闭记事本程序时,执行下面命令
		System.out.println("终止值: "+exitValue);

	}

}
