package com.base.string;

import java.util.Arrays;

public class TestArray {
	public static void main(String args[])
	{
		int[] t = {2,8,88,1,92,10,32,19,81};
		//  sort()后的数组为升序排列,即从小到大,如:a[0]=1;a[1]=3---
		Arrays.sort(t);
	
		System.out.println("min:"+t[0]);
		System.out.println("max:"+t[t.length-1]);
		
	}
}
