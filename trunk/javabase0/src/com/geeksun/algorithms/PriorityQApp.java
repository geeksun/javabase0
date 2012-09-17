package com.geeksun.algorithms;
/**
 *  在优先级队列中,数据项按关健字的值排序.
 *  优先级队列通常用堆实现,本例用数组实现;当数据项很多,或速度很重要时,采用堆是更好的选择
 *  本例中假定具有最小关健字值的数据项具有最高的优先级
 */
class PriorityQ
{
	private int maxSize;
	private long[] queArray;
	private int nItems;				//  队列中数据项的个数
	public PriorityQ(int s)
	{
		maxSize = s;
		queArray = new long [maxSize];
		nItems = 0;
	}
	/**
	 * @param item
	 *  在优先级队列中,插入数值时按关健字的值排序,插入数值前应该判断下队列是否已满
	 *  此实现方法平均需要移动一半的数据项,效率不高
	 */
	public void insert(long item)
	{
		int j;
		
		if(nItems==0)				//  空队列时
		{
			queArray[nItems++] = item;
		}
		else
		{
			for(j=nItems-1;j>=0;j--)		//  start at end,从队尾开始比较
			{
				if(item>queArray[j])		//  if new item larger
					queArray[j+1] = queArray[j];		//  shift upward : 如果比插入值小,则交换位置 		x1
				else
					break;
			}
			queArray[j+1] = item;			//  此处的 j 比 x1 处的 j 小1,因为在 x1 的 j 在 for 循环里已经减 1 了  			
			// System.out.println(j+" "+queArray[j]);				
			nItems++;
		}
	}
	
	/**
	 * @return 
	 *  移除队头的数据项
	 */
	public long remove()
	{
		return queArray[--nItems];
	}
	/**
	 * @return  队头的数据项
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
 *   优先级队列
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
