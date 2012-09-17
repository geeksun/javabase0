package com.geeksun.algorithms;

/**
 * @author geeksun
 *  �߼�������,�������������õķ�װ,��������,���Բ��ң�linear search
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
	 * @�����ؽ�ֵ,return true or false,���Բ���
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
	 * @param value,������ֵ��������
	 */
	public void insert(long value)
	{
		a[nElems] = value;		//  Ϊ������±긳ֵ
		nElems++;
	}
	/**
	 * @param value
	 *  ɾ��ָ��ֵ
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
	 *  ��ʾ�����Ԫ��
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
