package com.geeksun.algorithms;
/**
 *  栈:FILO 先进后出的方式存取,存取其它项慢
 */
public class Stack {
	private int maxSize;
	private long[] stackArray;
	private int top;			//  栈顶元素的下标
	public Stack(int s)
	{
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	/**
	 * @param j,入栈-向栈中插入一个数据项,top是在插入数据项前递增的
	 * push()和pop()方法里可以加入出错处理的代码,如:入栈时判断栈不满,if(!stack.isFull())  insert(item);
	 */
	public void push(long j)
	{
		stackArray[++top] = j;
	}
	/**
	 * @return 栈顶的元素,出栈-移除栈顶的数据项,top在移除数据项后减一
	 */
	public long pop()
	{
		return stackArray[top--];
	}
	/**
	 * @return 栈顶的元素,查看栈顶的元素而不做操作
	 */
	public long peek()
	{
		return stackArray[top];
	}
	/**
	 * @return boolean,判断栈是否为空
	 */
	public boolean isEmpty()
	{
		return top==-1;
	}
	/**
	 * @return boolean,判断栈是否已满
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
