package com.geeksun.algorithms;
/**
 * @author geeksun
 * @version: 有序数组,方法 find() 为二分查找算法:binary search
 * 2010-4-20
 */
public class OrdArray {
	private long[] a;				//  数组可以是私有变量
	private int nElems;				//  number of data items
	
	/**
	 * @param max : 为数组的长度
	 */
	public OrdArray(int max)
	{
		a = new long[max];
		nElems = 0;
	}
	
	/**
	 * @return 数组的长度
	 */
	
	public int size()
	{
		return nElems;
	}
	
	/** 二分查找:
	 * @param searchKey
	 * @return 包含特定值的数据项的下标
	 */
	public int find(long searchKey)
	{
		int lowerBound = 0;							// 数组的下标的下界
		int upperBound = nElems - 1;				// 上界
		int curIn;									// 当前的下标值
		
		while(true)
		{
			curIn = (lowerBound+upperBound)/2;
			if(a[curIn]==searchKey)
				return curIn;						//  find it
			else if(lowerBound>upperBound)
				return nElems;						//  can't find 
			else
			{
				if(a[curIn]<searchKey)				//  比较中间值与搜索值
					lowerBound = curIn + 1;
				else
					upperBound = curIn - 1;
			}
		}
	}
	
	/** 插入新数据到数组中:线性查找
	 * @param value
	 */
	public void insert(long value)
	{
		int j;
		for(j=0;j<nElems;j++)
			if(a[j] > value)						//  linear search
				break;
		for(int k=nElems;k>j;k--)
			a[k] = a[k-1];
		a[j] = value;
		nElems++;
	}
	
	/**
	 * @param value
	 * @删除指定值的元素return
	 */
	public boolean delete(long value)
	{
		int j = find(value);
		if(j==nElems)			//  can't find it
			return false;
		else					//  found it
		{
			for(int k=j;k<nElems;k++)	// from index k,move bigger ones down
				a[k] = a[k+1];
			nElems--;
			return true;
		}
	}
	
	/**
	 *  显示array contents
	 */
	public void display()
	{
		for(int j=0;j<nElems;j++)			
			System.out.print(a[j]+" ");
		System.out.println();
		//  JDK1.5的新特性,增强的ForEach循环,专用于遍历集合,数组等.遍历的时候无须显式使用集合索引获取元素,ForEach循环自动
		//  访问全部元素
		//for(long i:a)
			//System.out.print(" "+i);
	}
	
	public static void main(String[] args) {
		int maxSize = 100;
		OrdArray oa = new OrdArray(maxSize);
		
		oa.insert(19);
		oa.insert(83);
		oa.insert(93);
		oa.insert(290);
		
		int searchKey = 93;
		if(oa.find(searchKey)!=oa.size())
			System.out.println("Found "+searchKey);
		else
			System.out.println("Can't find "+searchKey);
		
		oa.display();
		
		oa.delete(19);
		oa.delete(290);
		
		oa.display();
	}
}
