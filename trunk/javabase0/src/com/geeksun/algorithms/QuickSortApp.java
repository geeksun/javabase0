package com.geeksun.algorithms;
/**
 *  第1种快速排序(原始版)
 */
class ArrayIns
{
	private long[] theArray;
	private int nElems;
	public ArrayIns(int max)
	{
		theArray = new long[max];
		nElems = 0;
	}
	public void insert(long value)
	{
		theArray[nElems] = value;
		nElems++;
	}
	public void display()
	{
		System.out.print("A=");
		for(int j=0;j<nElems;j++)
		{
			System.out.print(theArray[j]+" ");
		}
		System.out.println();
	}
	/**
	 *  对数组theArray进行快速排序
	 */
	public void quickSort()
	{
		recQuickSort(0,nElems-1);
	}
	/**
	 * @param left
	 * @param right
	 *  选择最右端的数据项作为枢纽,如果数据是任意排列的,性能还可以;如果数据是有序的或逆序的,性能就会很差
	 */
	public void recQuickSort(int left,int right)
	{
		if(right-left<=0)
			return;
		else
		{
			//  选择待划分的数组的子数组最右端的数据作为枢纽
			long pivot = theArray[right];
			
			int partition = partitionIt(left,right,pivot);	// partition range
			recQuickSort(left,partition-1);		// sort left side
			recQuickSort(partition+1,right);	// sort right side
		}
	}
	/**
	 * @param left
	 * @param right
	 * @param pivot
	 * @return pivot的位置:枢轴
	 */
	public int partitionIt(int left,int right,long pivot)
	{
		int leftPtr = left - 1;
		int rightPtr = right;
		while(true)
		{
			while(theArray[++leftPtr]<pivot);
			while(rightPtr>0&&theArray[--rightPtr]>pivot);
			if(leftPtr>=rightPtr)
				break;
			else
				swap(leftPtr,rightPtr);
		}
		swap(leftPtr,right);
		return leftPtr;
	}
	public void swap(int dex1,int dex2)
	{
		long temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
}
/**
 *  快速排序:本质上把一个数组分成两个数组,然后递归地调用自身为每一个子数组进行快速排序来实现滴.
 *  又称划分排序法，是一个递归的过程。
 */
public class QuickSortApp {
	public static void main(String[] args) {
		int maxSize = 16;
		ArrayIns arr;
		arr = new ArrayIns(maxSize);
		
		for(int j=0;j<maxSize;j++)
		{
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}
		arr.display();
		arr.quickSort();
		arr.display();
	}
}
