package com.geeksun.algorithms;

/**
 * @author geeksun
 *  高级数组类,对数组做了良好的封装,无序数组,线性查找：linear search
 *  2008-3-11
 */
public class HighArray {
	private long[] a;
	private int nElems;
	public HighArray(int max)
	{
		a = new long[max];
		nElems = 0;				//  no items yet
	}
	/**
	 * @param searchKey
	 * @搜索关健值,return true or false,线性查找
	 */
	public boolean find(long searchKey)
	{
		int j;
		for(j=0;j<nElems;j++)
			if(a[j]==searchKey)
				break;			//  exit loop before end
		// continue execute
		if(j==nElems)			//  can't find it
			return false;
		else
			return true;
	}
	/**
	 * @param value,插入数值到数组中
	 */
	public void insert(long value)
	{
		a[nElems] = value;		//  为数组的下标赋值
		nElems++;
	}
	/**
	 * @param value
	 *  删除指定值
	 */
	public boolean delete(long value)
	{
		int j;
		for(j=0;j<nElems;j++)	//  look for it
			if(value==a[j])
				break;
		if(j==nElems)
			return false;
		else
		{
			for(int k=j;k<nElems;k++)
				a[k] = a[k+1];
			nElems--;
			return true;
		}
	}
	/**
	 *  显示数组的元素
	 */
	public void display()
	{
		for(int j=0;j<nElems;j++)
			System.out.print(a[j]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		int maxSize = 100;
		HighArray oa = new HighArray(maxSize);
		
		oa.insert(19);
		oa.insert(83);
		oa.insert(43);
		oa.insert(290);
		
		int searchKey = 93;
		if(oa.find(searchKey))
			System.out.println("Found "+searchKey);
		else
			System.out.println("Can't find "+searchKey);
		
		oa.display();
		
		oa.delete(19);
		oa.delete(290);
		
		oa.display();
	}
}
