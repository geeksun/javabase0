package com.geeksun.algorithms;

/**
 * @author wave
 * @version 1.0 面向过程的数组
 *  app: application : 应用[计]
 *  2008-3-1
 */
public class ArraysApp {
	/**@comment : 数组实现了插入,查找,删除数据的功能
	 * @param args
	 */
	public static void main(String[] args) {
		long[] arr;
		arr = new long[100];
		int nElems = 0;					// number of items
		int j;							// loop counter
		long searchKey;					// key of item to search for
		
		arr[0] = 77;					//  insert intems
		arr[1] = 88;
		arr[2] = 22;
		arr[3] = 44;
		arr[4] = 55;
		arr[5] = 66;
		arr[6] = 11;
		arr[7] = 33;
		arr[8] = 99;
		arr[9] = 18;
		nElems = 10;
		
		for(j=0;j<nElems;j++)			//  display items
		{
			System.out.print(arr[j]+" ");
		}
			System.out.println(" ");	//  newline ^_^
		
		searchKey = 64;					//  find item with key 66
		for(j=0;j<nElems;j++)
		{
			if(arr[j]==searchKey)
				break;
		}
		
		System.out.print("j "+j);
		if(j==nElems)					//  judge
			System.out.println(" Can't find "+searchKey);
		else
			System.out.println(" Found "+searchKey);
		
		searchKey = 55;					//  delete item with key 55
		for(j=0;j<nElems;j++)
			if(arr[j]==searchKey)
				break;					//  operate
		
		//  先查找到特定的数据项,找到后,向前移动所有下标比它大的数据项来弥补删除后留下的"洞",并将 nElems 减一.
		for(int k=j;k<nElems;k++)		//  notice here condition : "k=j"
			arr[k] = arr[k+1];
		nElems--;
		
		for(j=0;j<nElems;j++)			//  display items
			System.out.print(arr[j]+" ");
		System.out.println(" ");
	}
}
