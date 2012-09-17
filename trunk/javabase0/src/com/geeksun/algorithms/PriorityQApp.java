package com.geeksun.algorithms;
/**
 *  �����ȼ�������,������ؽ��ֵ�ֵ����.
 *  ���ȼ�����ͨ���ö�ʵ��,����������ʵ��;��������ܶ�,���ٶȺ���Ҫʱ,���ö��Ǹ��õ�ѡ��
 *  �����мٶ�������С�ؽ���ֵ�������������ߵ����ȼ�
 */
class PriorityQ
{
	private int maxSize;
	private long[] queArray;
	private int nItems;				//  ������������ĸ���
	public PriorityQ(int s)
	{
		maxSize = s;
		queArray = new long [maxSize];
		nItems = 0;
	}
	/**
	 * @param item
	 *  �����ȼ�������,������ֵʱ���ؽ��ֵ�ֵ����,������ֵǰӦ���ж��¶����Ƿ�����
	 *  ��ʵ�ַ���ƽ����Ҫ�ƶ�һ���������,Ч�ʲ���
	 */
	public void insert(long item)
	{
		int j;
		
		if(nItems==0)				//  �ն���ʱ
		{
			queArray[nItems++] = item;
		}
		else
		{
			for(j=nItems-1;j>=0;j--)		//  start at end,�Ӷ�β��ʼ�Ƚ�
			{
				if(item>queArray[j])		//  if new item larger
					queArray[j+1] = queArray[j];		//  shift upward : ����Ȳ���ֵС,�򽻻�λ�� 		x1
				else
					break;
			}
			queArray[j+1] = item;			//  �˴��� j �� x1 ���� j С1,��Ϊ�� x1 �� j �� for ѭ�����Ѿ��� 1 ��  			
			// System.out.println(j+" "+queArray[j]);				
			nItems++;
		}
	}
	
	/**
	 * @return 
	 *  �Ƴ���ͷ��������
	 */
	public long remove()
	{
		return queArray[--nItems];
	}
	/**
	 * @return  ��ͷ��������
	 */
	public long peekMin()
	{
		return queArray[nItems-1];
	}
	public boolean isEmpty()
	{
		return (nItems==0);
	}
	public boolean isFull()
	{
		return (nItems==maxSize);
	}
}
/**  
 *   ���ȼ�����
 */
public class PriorityQApp {
	public static void main(String[] args) {
		PriorityQ pq = new PriorityQ(6);
		pq.insert(82);
		pq.insert(81);
		pq.insert(19);
		pq.insert(27);
		pq.insert(19);
		pq.insert(21);
		
		while(!pq.isEmpty())
		{
			long item = pq.remove();
			System.out.print(item + " ");
		}
		System.out.println("");
	}
}
