package com.base.algorithms;
class ArrayPar
{
	private long [] theArray;
	private int nElems;
	public ArrayPar(int max)
	{
		theArray = new long[max];
		nElems = 0;
	}
	public void insert(long value)
	{
		theArray[nElems] = value;
		nElems++;
	}
	public int size()
	{
		return nElems;
	}
	public void display()
	{
		System.out.print("A=");
		for(int j=0;j<nElems;j++)
			System.out.print(theArray[j]+ " ");
		System.out.println();
	}
	/**
	 * @param left:
	 * @param right
	 * @param pivot:枢轴
	 * @return 枢轴所在的位置
	 *  partition:划分
	 */
	public int partitionIt(int left,int right,long pivot)
	{
		int leftPtr = left - 1;			// 左指针
		int rightPtr = right + 1;		// 右指针
		while(true)
		{
			while(leftPtr<right&&theArray[++leftPtr]<pivot);		// 发现比枢轴大的数据时退出 
			
			while(rightPtr>left&&theArray[--rightPtr]>pivot);
			
			if(leftPtr>=rightPtr)
				break;
			else
				swap(leftPtr,rightPtr);
		}
		return leftPtr;
	}
	public void swap(int dex1,int dex2)
	{
		long temp;
		temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
}
/**
 *  划分：是快速排序的根本机制
 *  划分数据就是把数据分成两组,使所有关健字大于特定值的数据项在一组,小于特定值的数据项在第二组
 *  pivot:枢轴,支点
 */
public class Partition {
	public static void main(String[] args)
	{
		int maxSize = 16;
		ArrayPar arr;
		arr = new ArrayPar(maxSize);
		
		for(int j=0;j<maxSize;j++)
		{
			long n = (int)(java.lang.Math.random()*199);
			arr.insert(n);
		}
		arr.display();
		
		long pivot = 99;
		
		System.out.print("Pivot is "+pivot);
		
		int size = arr.size();
		
		int partDex = arr.partitionIt(0,size-1,pivot);
		
		System.out.println(",Partition is at index "+partDex);
		arr.display();
	}
}
