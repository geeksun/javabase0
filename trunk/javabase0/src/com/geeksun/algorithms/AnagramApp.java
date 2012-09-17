package com.geeksun.algorithms;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**					
 *   变位字  
 */
public class AnagramApp {	
	static int size;						//  大小  
	static int count;						//  计数  
	static char[] arrChar = new char[100];
	/**
	 * @param newSize
	 *  用递归实现变位字
	 */
	public static void doAnagram(int newSize)
	{
		if(newSize==1)
			return;
		for(int j=0;j<newSize;j++)			//  for each position
		{
			doAnagram(newSize-1);			//  anagram remaining
			if(newSize==2)					//  if innermost:如果在最里面
				displayWord();
			rotate(newSize);				//  rotate word
		}
	}
	/**
	 * @param newSize
	 *  rotate left all chars from position to end
	 *  rotate:旋转字符
	 */
	public static void rotate(int newSize)
	{
		int j;
		int position = size - newSize;
		char temp = arrChar[position];		//  save first letter
		
		for(j=position+1;j<size;j++)		//  shift others left
		{
			arrChar[j-1] = arrChar[j];
		}
		arrChar[j-1] = temp;				//  put first on right
	}
	/**
	 *  显示单词
	 */
	public static void displayWord()
	{
		if(count<99)
			System.out.print(" ");
		if(count<9)
			System.out.print(" ");
		System.out.print(++count+" ");
		for(int j=0;j<size;j++)
		{
			System.out.print(arrChar[j]);
		}
		System.out.print(" ");
		System.out.flush();
		if(count%6==0)
			System.out.println(" ");
	}
	/**
	 * @return  从键盘读取输入的字符
	 * @throws IOException
	 */
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		
		return s;
	}
	public static void main(String[] args) throws IOException {
		System.out.print("Enter a word: ");
		String input = getString(); 
		
		size = input.length();
		count = 0;
		for(int j=0;j<size;j++)
		{
			arrChar[j] = input.charAt(j);				//  put it in array
		}
		doAnagram(size);
	}
}
