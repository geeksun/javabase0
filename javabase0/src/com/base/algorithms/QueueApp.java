package com.base.algorithms;
/**
 *   队列:先进先出(FIFO),存取其它项慢
 */
class Queue
{
	private int maxSize;
	private long[] queArray;
	private int front;			//  队头
	private int rear;			//  后面的元素,队尾
	private int nItems;			//  队列中的数据项的个数,会使insert()和remove()增加额外的性能开销
	
	public Queue(int s)
	{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	/**
	 * @param j,put item at rear of queue
	 *  插入一个数据项,即把数据放入队尾
	 *  在方法中应该先判断队列是否不满,
	 */
	public void insert(long j)
	{
		//  rear 指向队列的顶端
		if(rear == maxSize-1)				//  循环队列:缓冲环,环绕式处理,为了避免队列不满却不能插入新数据项的问题,让队尾指针	
											//  绕回到数组开始的位置.也可称为"折断的队列"
		rear = -1;
		queArray[++rear] = j;
		nItems++;
	}
	
	/**
	 * @return 队头的元素
	 *  移除队头的数据项,前提是队列不空
	 */
	public long remove()
	{
		long temp = queArray[front++];		//  移除后,队头指针增加1,实际上删除的数据还留在内存里,只是不能被访问了
		if(front == maxSize)				//  front 的值超过队列的顶端
			front = 0;
		nItems--;
		return temp;
	}
	
	/**
	 * @return 查看队头的元素值(第一个插入的数据),查看要移除的值
	 */
	public long peekFront()
	{
		return queArray[front];
	}
	
	public boolean isEmpty()
	{
		return (nItems==0);
	}
	
	public boolean isFull()
	{
		return (nItems==maxSize);
	}
	
	/**
	 * @return 队列的大小
	 */
	public int size()
	{
		return nItems;
	}
}

public class QueueApp {
	public static void main(String[] args) {
		Queue qq = new Queue(5);
		
		qq.insert(8);
		qq.insert(83);
		qq.insert(3);
		qq.insert(893);
		qq.insert(82);
		qq.insert(829);		//  大小为5的队列里能插入6个元素?
		//893 82 892 89 92
		
		/*qq.remove();
		qq.remove();
		qq.remove();
		
		qq.insert(892);
		qq.insert(89);
		qq.insert(92);*/
		
		while(!qq.isEmpty())
		{
			long n = qq.remove();
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println("");
	}
}
