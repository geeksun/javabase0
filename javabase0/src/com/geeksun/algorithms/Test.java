package com.geeksun.algorithms;

public class Test {
	
	public static void main(String[] args)
	{
		Test t = new Test();
		System.out.println(t.delete(2));
		System.out.println("abcd".compareTo("aaa"));
		System.out.println("abd".compareTo("adfd"));
		//  "a"<"b"
		System.out.println("a".compareTo("b"));
	}
	
	public boolean delete(int a)
	{
		int j;
		for(j=0;j<19;j++)
			if(j==a)
				break;
		System.out.println("continue execute");
		System.out.println(j);
		if(j==19)
			return false;
		else
			return true;
	}
	
}
