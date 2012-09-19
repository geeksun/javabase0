package com.base.algorithms;

/**
 * @comment : Link - 链结点对象,链表由Link组成,每个Link对象中都有一个对下一个Link引用的字段next
 *  链结点类 ：链表的每个数据项都被包含在链结点(Link)中
 */
class FLink
{
	public long dData;
	public FLink next;
	public FLink(long d)
	{
		dData = d;
	}
	public void displayLink()
	{
		System.out.print(dData+" ");
	}
}
/**
 * @author Administrator
 *  双端链表:与链表相似,新增一个特性,对最后一个链结点的引用
 */
public class FirstLastList {
	private FLink first;
	private FLink last;			//  对最后一个节点的引用
	public FirstLastList()
	{
		first = null;
		last = null;
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	/**
	 * @param dd
	 *  在双端链表头插入一个链节点
	 */
	public void insertFirst(long dd)
	{
		FLink newLink = new FLink(dd);
		if(isEmpty())
			last = newLink;
		newLink.next = first;
		first = newLink;
	}
	/**
	 * @param dd
	 *  在双端链表尾插入一个链节点
	 */
	public void insertLast(long dd)
	{
		FLink newLink = new FLink(dd);
		if(isEmpty())
			first = newLink;
		else
			last.next = newLink;
		last = newLink;
	}
	/**
	 * @return
	 *  删除双端链表的第一个链结点
	 */
	public long deleteFirst()
	{
		long temp = first.dData;
		if(first.next==null)
			last = null;
		first = first.next;
		return temp;
	}
	/**
	 *  显示链表
	 */
	public void displayList()
	{
		System.out.println("List (first-->last):");
		FLink current = first;
		while(current != null)
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
	public static void main(String[] args)
	{
		FirstLastList fl = new FirstLastList();
		
		fl.insertFirst(33);
		fl.insertFirst(87);
		fl.insertFirst(91);
		
		fl.insertLast(22);
		fl.insertLast(12);
		fl.insertLast(82);
		
		fl.displayList();
		
		fl.deleteFirst();
		fl.deleteFirst();
		
		fl.displayList();
	}
}
