package com.base.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  用栈判断分隔符是否匹配
 *  通用栈类
 */
class StackY
{
	private int maxSize;
	private char[] stackArray;
	private int top;				//  栈顶元素的下标
	
	public StackY(int max)
	{
		maxSize = max;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	public void push(char j)
	{
		stackArray[++top] = j;
	}
	
	public char pop()
	{
		return stackArray[top--];
	}
	
	public char peek()
	{
		return stackArray[top];
	}
	
	public boolean isEmpty()
	{
		return top==-1;
	}
}

public class BracketStack {
	private String input;
	
	public BracketStack(String in)
	{
		input = in;
	}
	
	/**
	 *  检查分隔符是否匹配,不匹配则指出错误的位置
	 *  原理：从字符串中不断读取字符,每次读取一个字符.若发现它是左分隔符,将它压入栈中,从程序中读取一个右分隔符时,
	 *  弹出栈顶的左分隔符,并且检查它是否和右分隔符相匹配.
	 */
	public void check()
	{
		int stackSize = input.length();
		StackY stk = new StackY(stackSize);
		
		for(int j=0;j<input.length();j++)
		{
			char ch = input.charAt(j);
			switch(ch)
			{
				case '{':				//  opening  symbols 打开符号
				case '[':
				case '(':
					stk.push(ch);
					break;				
					
				case '}': 				//  closeint symbols 关闭符号
				case ']':  
				case ')':				//  ！· ！牢记要细心
					if(!stk.isEmpty())
					{
						char chx = stk.pop();
						if((ch=='}'&&chx!='{')||(ch==']'&&chx!='[')||(ch==')'&&chx!='('))
							System.out.println("Error : "+ch+" at "+j);
					}
					else				//  prematurely  empty
						System.out.println(" Error : "+ch+" at "+j);
					break;
				default:
					break;
			}
		}
		if(!stk.isEmpty())
		{
			System.out.println("Error:missing right delimiter");
		}
	}
	
	/**
	 * @return 输入的字符串
	 * @throws IOException
	 */
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String input;
		while(true)
		{
			System.out.print("Enter string containg delimiters: ");
			System.out.flush();
			input = getString();
			if(input.equals("")) 
				break;
			
			BracketStack bs = new BracketStack(input);
			bs.check();
		}
	}
	
	
}
