package com.base.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  ��ջ�жϷָ����Ƿ�ƥ��
 *  ͨ��ջ��
 */
class StackY
{
	private int maxSize;
	private char[] stackArray;
	private int top;				//  ջ��Ԫ�ص��±�
	
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
	 *  ���ָ����Ƿ�ƥ��,��ƥ����ָ�������λ��
	 *  ԭ�����ַ����в��϶�ȡ�ַ�,ÿ�ζ�ȡһ���ַ�.������������ָ���,����ѹ��ջ��,�ӳ����ж�ȡһ���ҷָ���ʱ,
	 *  ����ջ������ָ���,���Ҽ�����Ƿ���ҷָ�����ƥ��.
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
				case '{':				//  opening  symbols �򿪷���
				case '[':
				case '(':
					stk.push(ch);
					break;				
					
				case '}': 				//  closeint symbols �رշ���
				case ']':  
				case ')':				//  ���� ���μ�Ҫϸ��
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
	 * @return ������ַ���
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
