package com.geeksun.math;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] temp = {"dream1dream","charles298","longge","qiuqiu","cherrylily"};
		List list = new ArrayList();
		for(int i=0;i<temp.length;i++)
		{
			list.add(temp[i]);
		}
		for(int x=0;x<list.size();x++)
		{
			System.out.println(list.get(x));
		}
		StringBuffer sb = new StringBuffer();
		sb.append("select * from ...");
		sb.append("+");
		sb.append(")");
		System.out.println(sb);
	}

}
