package com.base.algorithms;
/**
 *   ����:�Ƚ��ȳ�(FIFO),��ȡ��������
 */
class Queue
{
	private int maxSize;
	private long[] queArray;
	private int front;			//  ��ͷ
	private int rear;			//  �����Ԫ��,��β
	private int nItems;			//  �����е�������ĸ���,��ʹinsert()��remove()���Ӷ�������ܿ���
	
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
	 *  ����һ��������,�������ݷ����β
	 *  �ڷ�����Ӧ�����ж϶����Ƿ���,
	 */
	public void insert(long j)
	{
		//  rear ָ����еĶ���
		if(rear == maxSize-1)				//  ѭ������:���廷,����ʽ����,Ϊ�˱�����в���ȴ���ܲ����������������,�ö�βָ��	
											//  �ƻص����鿪ʼ��λ��.Ҳ�ɳ�Ϊ"�۶ϵĶ���"
		rear = -1;
		queArray[++rear] = j;
		nItems++;
	}
	
	/**
	 * @return ��ͷ��Ԫ��
	 *  �Ƴ���ͷ��������,ǰ���Ƕ��в���
	 */
	public long remove()
	{
		long temp = queArray[front++];		//  �Ƴ���,��ͷָ������1,ʵ����ɾ�������ݻ������ڴ���,ֻ�ǲ��ܱ�������
		if(front == maxSize)				//  front ��ֵ�������еĶ���
			front = 0;
		nItems--;
		return temp;
	}
	
	/**
	 * @return �鿴��ͷ��Ԫ��ֵ(��һ�����������),�鿴Ҫ�Ƴ���ֵ
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
	 * @return ���еĴ�С
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
		qq.insert(829);		//  ��СΪ5�Ķ������ܲ���6��Ԫ��?
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
