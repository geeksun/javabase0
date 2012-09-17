package com.geeksun.oop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author geeksun
 * @version Java调用可执行文件(exe,com)和批处理命令(cmd,bat)
 *  Java 创建文本文件
 */
public class BatTest {
	public static void main(String args[])
	{
		System.out.println("args : " + java.util.Arrays.asList(args)); 
		     try 
		     { 
		         String command = args.length == 0 ? "notepad" : args[0]; 
		         Process child = Runtime.getRuntime().exec(command);  
		         
		         String line = null;
		         BufferedReader reader = new BufferedReader(new InputStreamReader(child.getInputStream())); 
		         while((line = reader.readLine()) != null) 
		         {   
		             System.out.println(line); 
		         }   
		      } 
		      catch (Exception ex)
		      { 
		          ex.printStackTrace(); 
		       }
		} 
	}
	

