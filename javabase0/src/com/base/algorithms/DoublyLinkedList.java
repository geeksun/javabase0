package com.base.algorithms;
/**
 *  双向链表:每个链结点有两个指向其它结点的引用
 *  @comment : Link - 链结点对象,链表由Link组成,每个Link对象中都有一个对下一个Link引用的字段next
 *                  - 和一个对上一个Link引用的字段previous
 *  链结点类 ：链表的每个数据项都被包含在链结点(Link)中
 */
class DLink
{
	public long dData;
	public DLink next;
	public DLink previous;
	public DLink(long d)
	{
		dData = d;
	}
	/**
	 * display DLink data
	 */
	public void displayLink()
	{
		System.out.print(dData+" ");
	}
}
/**
 *  双向链表:每个链结点有两个指向其它结点的引用
 *  双向链表的元素排列没有顺序,next为null意味着链表的结尾
 *  在用删除方法和 insertAfter() 时,应该用 isEmpty() 判断链表是否为空
 */
public class DoublyLinkedList {
	private DLink first;
	private DLink last;				//  对最后一个链结点的引用
	public DoublyLinkedList()
	{
		first = null;
		last = null;
	}
	/**
	 *  @判断链表是否为空,return 布尔值 
	 */
	public boolean isEmpty()
	{
		return first==null;
	}
	/**
	 * @param dd
	 *  在表头插入一个链结点
	 */
	public void insertFirst(long dd)
	{
		DLink newLink = new DLink(dd);
		
		if(isEmpty())			// 如果链表为空
			last = newLink;		// newLink <-- last
		else 
			first.previous = newLink;	// newLink <-- old first 下游结点连接上游结点
		newLink.next = first;			// newLink <-- old first 下游结点连接上游结点
		first = newLink;				// first --> newLink 上游结点连接下游结点
	}
	/**
	 * @param dd
	 *  在链表尾插入一个链结点
	 */
	public void insertLast(long dd)
	{
		DLink newLink = new DLink(dd);
		
		if(isEmpty())
			first = newLink;	//  first --> newLink
		else
		{
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}
	/**
	 * @删除第一个链结点 return 第一个链结点的值
	 */
	public DLink deleteFirst()
	{
		DLink temp = first;
		if(first.next==null)	// if only one item
			last = null;
		else
			first.next.previous = null;	// null <-- old next
		first = first.next;		// first --> old first
		return temp;
	}
	/**
	 * @删除最后一个链结点,return 最后一个链结点
	 */
	public DLink deleteLast()
	{
		DLink temp = last;
		if(first.next==null)	// if only one item
			first = null;		// first --> null
		else
			last.previous.next = null;	// old previous --> null
		last = last.previous;			// old previous <-- last
		return temp;
	}
	/**
	 * @param key
	 * @param dd
	 * @插入 dd 在 key 的后面,在某个特定值的链结点的后面插入一个新的链结点
	 *  如果 key 值不存在,将不会插入 dd 
	 */
	public boolean insertAfter(long key,long dd)
	{
		DLink current = first;
		while(current.dData!=key)	// until match is found,直到找到匹配值为止
		{
			current = current.next;
			if(current==null)
				return false;		// didn't find it
		}
		DLink newLink = new DLink(dd);
		
		if(current==last)			// if last link
		{
			newLink.next = null;
			last = newLink;
		}
		else						// not last link
		{
			newLink.next = current.next;	// newLink --> old next
											// newLink <-- old next
			current.next.previous = newLink;
		}
		newLink.previous = current;		// old current <-- newLink
		current.next = newLink;			// old current --> newLink
		
		return true;
	}
	/**
	 * @param key
	 * @删除指定值的链结点,return被删除的链结点 
	 */
	public DLink deleteKey(long key)
	{
		DLink current = first;
		while(current.dData!=key)
		{
			current = current.next;
			if(current==null)
				return null;
		}
		if(current==first)
			first = current.next;
		else
			current.previous.next = current.next;
		
		if(current==last)
			last = current.previous;
		else
			current.next.previous = current.previous;
		return current;
	}
	/**
	 *  从表头开始的遍历,依次到表尾
	 */
	public void displayForward()
	{
		System.out.print("List (first-->last): ");
		DLink current = first;
		while(current!=null)
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
	/**
	 *  从表尾开始的遍历,依次到表头
	 */
	public void displayBackward()
	{
		System.out.print("List (last-->first): ");
		DLink current = last;
		while(current!=null)
		{
			current.displayLink();
			current = current.previous;
		}
		System.out.println(" ");
	}
	public static void main(String[] args)
	{
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.insertFirst(12);
		dl.insertFirst(82);
		dl.insertFirst(88);
		
		dl.insertLast(81);
		dl.insertLast(18);
		dl.insertLast(92);
		
		dl.displayForward();
		dl.displayBackward();
		
		dl.deleteFirst();
		dl.deleteLast();
		dl.deleteKey(82);
		
		dl.displayForward();
		
		dl.insertAfter(81,23);
		dl.insertAfter(19,34);		//  不会被插入,因为 19 不存在
		
		dl.displayForward();
	}
}
