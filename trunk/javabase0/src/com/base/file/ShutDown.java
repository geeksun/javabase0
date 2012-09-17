package com.base.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/** 
 * 下载完文件后自动关闭电驴
 * @author Y 
 * 2010/04/01 23:39 
 */
public class ShutDown {
	// easyMule下downloads.txt文件的路径 
	public static final String FILEPATH = "D:\\Program Files\\easyMule\\downloads.txt";

	// 查找下载记录数的关键字 
	public static final String KEYWORD = "ed2k://|file|";

	// 刷新读入downloads.txt的时间(秒) 
	int second = 5;

	// 下载完成后关机的延迟时间(秒) 
	int times = 60;

	// 需要监视的文件id号 
	int id;

	// 监视的文件名称 
	String fileName;

	public ShutDown() {
		  System.out.println("当前的下载文件信息为:"); 
		  System.out.println("————————————————————–"); 
		  showFile(readText(FILEPATH, KEYWORD)); 
		  System.out.println("————————————————————–"); 
		  System.out.println("要等哪个文件下载完成关闭计算机?"); 
		  Scanner scan = new Scanner(System.in); 
		  id = scan.nextInt() - 1; 
		  fileName = (String) readText(FILEPATH, KEYWORD).get(id); 
		  System.out.println("监视的文件是:" + fileName); 
		  while (countDown(second)) { 
		
		   if (readText(FILEPATH, fileName).size() == 0) { 
		    shutDownComputer(times); 
		    System.out.println("计算机将在" + times + "秒内关闭"); 
		    System.out.println("输入任意内容可取消关闭计算机"); 
		    if (null != scan.next()) { 
		     unShutDownComputer(); 
		    } 
		    break; 
		   } 
		  }
	}	
	
	// 利用线程休眠进行倒计时 
	public boolean countDown(int second) {
		  for (int i = second; i >= 0; i--) {
		   try { 
		    Thread.sleep(1000); 
		    if (i == 0) { 
		     return true; 
		    } 
		   } catch (InterruptedException e) { 
		    e.printStackTrace(); 
		   } 
		  } 
		  return false; 
	}
	// 读取文件,查找下载的条目,返回List集合 
	public List readText(String filePath, String searchWord) {
	  List list = new ArrayList(); 
	  File file = new File(filePath); 
	  InputStreamReader reader = null; 
	  BufferedReader br = null; 
	  try {
	   // downloads.txt文件采用Unicode编码,需要转码 
	   reader = new InputStreamReader(new FileInputStream(file),"utf-16");
	   br = new BufferedReader(reader); 
	   String s1 = null; 
	   while ((s1 = br.readLine()) != null) { 
	    int position = s1.indexOf(searchWord); 
	    if (position != -1) { 
	     s1 = s1.substring(0, position).trim(); 
	     list.add(s1); 
	
	    } 
	   } 
	  } catch (UnsupportedEncodingException e) { 
	   e.printStackTrace(); 
	  } catch (FileNotFoundException e) { 
	   e.printStackTrace(); 
	  } catch (IOException e) { 
	   e.printStackTrace(); 
	  } finally { 
	   try { 
	    br.close(); 
	    reader.close(); 
	   } catch (IOException e) { 
	    e.printStackTrace(); 
	   } 
	
	  } 
	  return list;
	}
	// 查看当前下载的记录数 
	public void showFile(List list) {
		Iterator iter = list.iterator();
		int count = 1;
		while (iter.hasNext()) {
			System.out.println(count + "=>" + iter.next());
			count++;
		}
	}

	// 关闭计算机 
	public void shutDownComputer(int times) {
		Runtime run = Runtime.getRuntime();
		try {
			run.exec("shutdown -s -t" + " " + times);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 取消关闭计算机 
	public void unShutDownComputer() {
		Runtime run = Runtime.getRuntime();
		try {
			run.exec("shutdown -a");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ShutDown();

	}

}
