package com.base.algorithms;
/**
 *  插入排序:在局部有序的组中插入数据,利用 out 标记来完成 work-flow
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
	 * @param searchKey,搜索关健值
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
	 * @param value,删除数组中的指定值
	 * @return boolean 数值
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
	 *  out:被标记区分的数据,在out左边都是有序的数据,右边是无序的数据,即out是未排序部分最左端的数据
	 *  out 右边的数据将逐步插入到左面的有序数组区
	 *  out 作为标记从1到nElems-1逐渐增加
	 */
	public void insertSort()
	{
		int in,out;
		for(out=1;out<nElems;out++)
		{
			long temp = a[out];			//  移除被标记的数据(复制)
			in = out;					//  开始移动 out 
			while(in>0&&a[in-1]>=temp)	//  直到找到一个较小的为止不再循环,就是 out 插入的位置
			{
				a[in] = a[in-1];		//  移动数据到右边
				--in;					//  到左边一位的位置
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
