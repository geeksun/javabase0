package com.base.algorithms;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *   �õݹ���������������
 */
public class TriangleApp {
	static int theNumber;
	/**
	 * @param n
	 * @return �ݹ��������ķ������������������
	 */
	public static int triangle(int n)
	{
		System.out.println("Entering:n="+n);
		if(n==1)
		{
			System.out.println("Returning 1");
			return 1;
		}
		else
		{
			int temp = n + triangle(n-1);
			System.out.println("Returning "+temp);
			return temp;
		}
	}
	/**
	 * @param n
	 * @return  �õݹ����׳�
	 */
	public static int factorial(int n)
	{
		if(n==0)
			return 1;
		else
			return (n*factorial(n-1));
	}
	/**
	 * @return ��ȡ�Ӽ���������ַ�
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
	 * @return ���ַ�ת��Ϊ����
	 * @throws IOException
	 */
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
	public static void main(String[] args) throws IOException {
		System.out.println("Enter a number: ");
		theNumber = getInt();
		int theAnswer = triangle(theNumber);
		System.out.println("Triangle="+theAnswer);
	}
}
