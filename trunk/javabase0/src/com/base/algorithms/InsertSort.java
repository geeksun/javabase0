package com.base.algorithms;
/**
 *  ��������:�ھֲ���������в�������,���� out �������� work-flow
 */
public class InsertSort {
	private long[] a;
	private int nElems;
	public InsertSort(int max)
	{
		a = new long[max];
		nElems = 0;
	}
	/**
	 * @param searchKey,�����ؽ�ֵ
	 */
	public boolean find(long searchKey)
	{
		int j;
		for(j=0;j<nElems;j++)
			if(a[j]==searchKey)
				break;
		if(j==nElems)		// can't find searchKey
			return false;
		else
			return true;
	}
	public void insert(long value)
	{
		a[nElems] = value;
		nElems++;
	}
	/**
	 * @param value,ɾ�������е�ָ��ֵ
	 * @return boolean ��ֵ
	 */
	public boolean delete(long value)
	{
		int j;
		for(j=0;j<nElems;j++)
			if(a[j]==value)
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
	public void display()
	{
		for(int j=0;j<nElems;j++)
		{
			System.out.print(a[j]+" ");
		}
		System.out.println();
	}
	/**
	 *  out:��������ֵ�����,��out��߶������������,�ұ������������,��out��δ���򲿷�����˵�����
	 *  out �ұߵ����ݽ��𲽲��뵽���������������
	 *  out ��Ϊ��Ǵ�1��nElems-1������
	 */
	public void insertSort()
	{
		int in,out;
		for(out=1;out<nElems;out++)
		{
			long temp = a[out];			//  �Ƴ�����ǵ�����(����)
			in = out;					//  ��ʼ�ƶ� out 
			while(in>0&&a[in-1]>=temp)	//  ֱ���ҵ�һ����С��Ϊֹ����ѭ��,���� out �����λ��
			{
				a[in] = a[in-1];		//  �ƶ����ݵ��ұ�
				--in;					//  �����һλ��λ��
			}
			a[in] = temp;				//  insert marked data
		}
	}
	public static void main(String[] args) {
		int maxSize = 81;
		InsertSort is = new InsertSort(maxSize);
		
		is.insert(892);
		is.insert(29);
		is.insert(190);
		is.insert(11);
		is.insert(92);
		
		is.display();
		is.insertSort();
		is.display();
	}
}
