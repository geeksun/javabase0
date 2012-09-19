package com.base.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  用栈实现单词的逆序操作
 *  通用栈类
 */
class StackX
{
	private int maxSize;
	private char[] stackArray;
	private int top;				//  栈顶元素的下标
	public StackX(int max)
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
public class ReverseStack {
	private String input;
	private String output;
	public ReverseStack(String in)
	{
		input = in;
	}
	/**
	 * @return 逆序的单词,用栈实现单词的逆序操作,根据输入字符串的长度作为栈的大小
	 */
	public String doRev()
	{
		int stackSize = input.length();
		StackX stk = new StackX(stackSize);
		
		for(int j=0;j<input.length();j++)
		{
			char ch = input.charAt(j);
			stk.push(ch);
		}
		output = "";
		while(!stk.isEmpty())
		{
			char ch = stk.pop();
			output = output + ch;
		}
		return output;
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
	public static void main(String[] args) throws IOException {
		String input,output;
		while(true)
		{
			System.out.println("Enter a string");
			System.out.flush();
			input = getString();
			if(input.equals("")) 
				break;
			
			ReverseStack rs = new ReverseStack(input);
			output = rs.doRev();
			System.out.println("Reversed: "+output);
			
		}
	}

}
