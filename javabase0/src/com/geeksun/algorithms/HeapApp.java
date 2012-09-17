package com.geeksun.algorithms;
/**
 *  �ѵĽڵ���
 */
class HNode
{
	private int iData;
	public HNode(int key)
	{
		iData = key;
	}
	public int getKey()
	{
		return iData;
	}
	public void setKey(int id)
	{
		iData = id;
	}
}
/**
 *  ��:ʵ�����ȼ����е�һ�ֳ������ݽṹ,���ٶȷǳ���Ҫ,���кܶ�������ʱ,����ѡ�����ʵ�����ȼ�����.
 *  �����"��"��һ������Ķ�����,��JAVA�����еĶѲ�һ��,����ָ����Ա��new�ܵõ��ļ�����ڴ�Ŀ��ò���.
 */
class Heap
{
	private HNode[] heapArray;
	private int maxSize;
	private int currentSize;
	public Heap(int max)
	{
		maxSize = max;
		currentSize = 0;
		heapArray = new HNode[maxSize];
	}
	public boolean isEmpty()
	{
		return currentSize==0;
	}
	public boolean insert(int key)
	{
		if(currentSize==maxSize)
			return false;
		heapArray[currentSize] = new HNode(key);
		trickleUp(currentSize++);
		return true;
	}
	/**
	 * @param index:�²������������±�
	 * ����ɸѡ�㷨:�ҵ����λ�õĸ��ڵ�,Ȼ�������ڵ㱣����һ����Ϊbottom�ı�����,
	 * bottom:�ײ�,ĩ��
	 */
	public void trickleUp(int index)
	{
		int parent = (index-1)/2;
		HNode bottom = heapArray[index];
		while(index>0&&heapArray[parent].getKey()<bottom.getKey())
		{
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heapArray[index] = bottom;
	}
	/**
	 * @return
	 * �Ƴ��ڵ㣺����ɸѡ���㷨
	 */
	public HNode remove()
	{
		HNode hn = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return hn;
	}
	/**
	 * @param index
	 * ����ɸѡ�㷨
	 */
	public void trickleDown(int index)
	{
		int largerChild;
		HNode top = heapArray[index];		// save root
		while(index<currentSize/2)
		{
			int leftChild = 2*index+1;
			int rightChild = leftChild+1;
			
			if(rightChild<currentSize&&heapArray[leftChild].getKey()<heapArray[rightChild].getKey())
				largerChild = rightChild;
			else
				largerChild = leftChild;
			
			if(top.getKey()>=heapArray[largerChild].getKey())
				break;
			
			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}
		heapArray[index] = top;
	}
	/**
	 * @param index
	 * @param newValue
	 * @return  
	 *  �ı����ȼ�
	 */
	public boolean change(int index,int newValue)
	{
		if(index<0||index>=currentSize)
			return false;
		int oldValue = heapArray[index].getKey();
		heapArray[index].setKey(newValue);
		
		if(oldValue<newValue)
			trickleUp(index);
		else
			trickleUp(index);
		return true;
	}
	public void displayHeap()
	{
		System.out.print("heapArray:");
		for(int m=0;m<currentSize;m++)
			if(heapArray[m]!=null)
				System.out.print(heapArray[m].getKey()+" ");
			else
				System.out.print("--");
		System.out.println();
		
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		String dots = "------------------------";
		System.out.println(dots+dots);
		
		while(currentSize>0)
		{
			if(column==0)
			{
				for(int k=0;k<nBlanks;k++)
					System.out.print(' ');
				System.out.print(heapArray[j].getKey());
			}
			if(++j==currentSize)
				break;
			
			if(++column==itemsPerRow)
			{
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			}
			else
				for(int k=0;k<nBlanks*2-2;k++)
					System.out.print(' ');
		}
		System.out.println("\n"+dots+dots);
	}
}
public class HeapApp {
	static public int getChar()
	{
		int i = 22;
		return i;
	}
	public static void main(String[] args) {
		int value,value2;
		Heap theHeap = new Heap(31);
		boolean success;
		
		theHeap.insert(70);
		theHeap.insert(82);
		theHeap.insert(90);
		theHeap.insert(68);
		theHeap.insert(68);
		theHeap.insert(60);
		
		while(true)
		{
			System.out.print("Enter first letter of ");
			System.out.print("show,insert,remove,change: ");
			int choice = getChar();
			
		}
	}
}
