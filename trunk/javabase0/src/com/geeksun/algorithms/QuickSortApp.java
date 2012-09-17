package com.geeksun.algorithms;
/**
 *  ��1�ֿ�������(ԭʼ��)
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
	 *  ������theArray���п�������
	 */
	public void quickSort()
	{
		recQuickSort(0,nElems-1);
	}
	/**
	 * @param left
	 * @param right
	 *  ѡ�����Ҷ˵���������Ϊ��Ŧ,����������������е�,���ܻ�����;�������������Ļ������,���ܾͻ�ܲ�
	 */
	public void recQuickSort(int left,int right)
	{
		if(right-left<=0)
			return;
		else
		{
			//  ѡ������ֵ���������������Ҷ˵�������Ϊ��Ŧ
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
	 * @return pivot��λ��:����
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
 *  ��������:�����ϰ�һ������ֳ���������,Ȼ��ݹ�ص�������Ϊÿһ����������п���������ʵ�ֵ�.
 *  �ֳƻ������򷨣���һ���ݹ�Ĺ��̡�
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
