package com.geeksun.algorithms;
/**
 * @author geeksun
 * @version: ��������,���� find() Ϊ���ֲ����㷨:binary search
 * 2010-4-20
 */
public class OrdArray {
	private long[] a;				//  ���������˽�б���
	private int nElems;				//  number of data items
	
	/**
	 * @param max : Ϊ����ĳ���
	 */
	public OrdArray(int max)
	{
		a = new long[max];
		nElems = 0;
	}
	
	/**
	 * @return ����ĳ���
	 */
	
	public int size()
	{
		return nElems;
	}
	
	/** ���ֲ���:
	 * @param searchKey
	 * @return �����ض�ֵ����������±�
	 */
	public int find(long searchKey)
	{
		int lowerBound = 0;							// ������±���½�
		int upperBound = nElems - 1;				// �Ͻ�
		int curIn;									// ��ǰ���±�ֵ
		
		while(true)
		{
			curIn = (lowerBound+upperBound)/2;
			if(a[curIn]==searchKey)
				return curIn;						//  find it
			else if(lowerBound>upperBound)
				return nElems;						//  can't find 
			else
			{
				if(a[curIn]<searchKey)				//  �Ƚ��м�ֵ������ֵ
					lowerBound = curIn + 1;
				else
					upperBound = curIn - 1;
			}
		}
	}
	
	/** ���������ݵ�������:���Բ���
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
	 * @ɾ��ָ��ֵ��Ԫ��return
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
	 *  ��ʾarray contents
	 */
	public void display()
	{
		for(int j=0;j<nElems;j++)			
			System.out.print(a[j]+" ");
		System.out.println();
		//  JDK1.5��������,��ǿ��ForEachѭ��,ר���ڱ�������,�����.������ʱ��������ʽʹ�ü���������ȡԪ��,ForEachѭ���Զ�
		//  ����ȫ��Ԫ��
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
