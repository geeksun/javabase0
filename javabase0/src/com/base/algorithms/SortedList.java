package com.base.algorithms;
/**
 *  有序链表:链表中的数据是有顺序的
 *  @comment : Link - 链结点对象,链表由Link组成,每个Link对象中都有一个对下一个Link引用的字段next
 *  链结点类 ：链表的每个数据项都被包含在链结点(Link)中
 */
class SLink
{
	public long dData;
	public SLink next;
	public SLink(long dd)
	{
		dData = dd;
	}
	/**
	 *  显示链结点
	 */
	public void displayLink()
	{
		System.out.print(dData+" ");
	}
}
/**
 * @author Administrator
 *  有序链表,链表是按关健值有序排列的
 */
public class SortedList {
	private SLink first;
	public SortedList()
	{
		first = null;
	}
	/**
	 *  判断链表是否为空 
	 */
	public boolean isEmpty()
	{
		return first==null;
	}
	/**
	 * @param key
	 *  在有序链表中插入链结点,将按顺序插入数据
	 *  插入算法首先搜索链表,直到找到合适的位置;它恰好在第一个比它大的数据项的前面.
	 */
	public void insert(long key)
	{
		SLink newLink = new SLink(key);
		SLink previous = null;		  
		SLink current = first;		//  从 first 开始遍历,在该节点之前插入:该节点为第一个比要插入节点的链结点大的结点
		
		while(current!=null&&key>current.dData)		//  寻找要插入的链结点的位置
		{
			previous = current;
			current = current.next;
		}
		if(previous==null)					//  链结点插在表头
			first = newLink;
		else
			previous.next = newLink;
		newLink.next = current;
	}
	/**
	 * @return 要删除的链结点
	 *  删除第一个链结点
	 */
	public SLink remove()
	{
		SLink temp = first;
		first = first.next;
		return temp;
	}
	public void displayList()
	{
		System.out.println("List (first-->last): ");
		SLink current = first;
		while(current!=null)
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
	public static void main(String[] args) {
		SortedList sl = new SortedList();
		sl.insert(19);
		sl.insert(92);
		
		sl.displayList();
		
		sl.insert(10);
		sl.insert(20);
		sl.insert(30);
		
		sl.displayList();
		
		sl.remove();
		
		sl.displayList();
	}
}
