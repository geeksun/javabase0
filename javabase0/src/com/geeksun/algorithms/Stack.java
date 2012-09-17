package com.geeksun.algorithms;
/**
 *  ջ:FILO �Ƚ�����ķ�ʽ��ȡ,��ȡ��������
 */
public class Stack {
	private int maxSize;
	private long[] stackArray;
	private int top;			//  ջ��Ԫ�ص��±�
	public Stack(int s)
	{
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	/**
	 * @param j,��ջ-��ջ�в���һ��������,top���ڲ���������ǰ������
	 * push()��pop()��������Լ��������Ĵ���,��:��ջʱ�ж�ջ����,if(!stack.isFull())  insert(item);
	 */
	public void push(long j)
	{
		stackArray[++top] = j;
	}
	/**
	 * @return ջ����Ԫ��,��ջ-�Ƴ�ջ����������,top���Ƴ���������һ
	 */
	public long pop()
	{
		return stackArray[top--];
	}
	/**
	 * @return ջ����Ԫ��,�鿴ջ����Ԫ�ض���������
	 */
	public long peek()
	{
		return stackArray[top];
	}
	/**
	 * @return boolean,�ж�ջ�Ƿ�Ϊ��
	 */
	public boolean isEmpty()
	{
		return top==-1;
	}
	/**
	 * @return boolean,�ж�ջ�Ƿ�����
	 */
	public boolean isFull()
	{
		return top==maxSize;
	}
	public static void main(String[] args) {
		Stack sta = new Stack(10);
		sta.push(19);
		sta.push(83);
		sta.push(82);
		
		while(!sta.isEmpty())
		{
			long value = sta.pop();
			System.out.print(value+" ");
		}
		System.out.println();
	}
}
