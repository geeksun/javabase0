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
 * �������ļ����Զ��رյ�¿
 * @author Y 
 * 2010/04/01 23:39 
 */
public class ShutDown {
	// easyMule��downloads.txt�ļ���·�� 
	public static final String FILEPATH = "D:\\Program Files\\easyMule\\downloads.txt";

	// �������ؼ�¼���Ĺؼ��� 
	public static final String KEYWORD = "ed2k://|file|";

	// ˢ�¶���downloads.txt��ʱ��(��) 
	int second = 5;

	// ������ɺ�ػ����ӳ�ʱ��(��) 
	int times = 60;

	// ��Ҫ���ӵ��ļ�id�� 
	int id;

	// ���ӵ��ļ����� 
	String fileName;

	public ShutDown() {
		  System.out.println("��ǰ�������ļ���ϢΪ:"); 
		  System.out.println("�����������������������������������������C"); 
		  showFile(readText(FILEPATH, KEYWORD)); 
		  System.out.println("�����������������������������������������C"); 
		  System.out.println("Ҫ���ĸ��ļ�������ɹرռ����?"); 
		  Scanner scan = new Scanner(System.in); 
		  id = scan.nextInt() - 1; 
		  fileName = (String) readText(FILEPATH, KEYWORD).get(id); 
		  System.out.println("���ӵ��ļ���:" + fileName); 
		  while (countDown(second)) { 
		
		   if (readText(FILEPATH, fileName).size() == 0) { 
		    shutDownComputer(times); 
		    System.out.println("���������" + times + "���ڹر�"); 
		    System.out.println("�����������ݿ�ȡ���رռ����"); 
		    if (null != scan.next()) { 
		     unShutDownComputer(); 
		    } 
		    break; 
		   } 
		  }
	}	
	
	// �����߳����߽��е���ʱ 
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
	// ��ȡ�ļ�,�������ص���Ŀ,����List���� 
	public List readText(String filePath, String searchWord) {
	  List list = new ArrayList(); 
	  File file = new File(filePath); 
	  InputStreamReader reader = null; 
	  BufferedReader br = null; 
	  try {
	   // downloads.txt�ļ�����Unicode����,��Ҫת�� 
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
	// �鿴��ǰ���صļ�¼�� 
	public void showFile(List list) {
		Iterator iter = list.iterator();
		int count = 1;
		while (iter.hasNext()) {
			System.out.println(count + "=>" + iter.next());
			count++;
		}
	}

	// �رռ���� 
	public void shutDownComputer(int times) {
		Runtime run = Runtime.getRuntime();
		try {
			run.exec("shutdown -s -t" + " " + times);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ȡ���رռ���� 
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
