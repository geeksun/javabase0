package com.base.algorithms;
/**
 * @author geeksun
 * @comment : 用 JAVA 实现链表,不能使用 util 包的类
 *  实现查找,插入和删除的操作
 */
public class linkedList {
	// 对第一个链表结点的引用,指向第一个链结点
	private Link first;
	public linkedList()
	{
		first = null;
	}
	/** 
	 *  判断链表是否为空 
	 */
	public boolean isEmpty()
	{
		return (first==null);
	}
	/** 在链表的表头增加一个新链接点
	 * @param id
	 * @param dd
	 */
	public void insertFirst(int id,double dd)
	{
		Link l = new Link(id,dd);
		l.next = this.first;				//  l --> old first : 使原来的 first 的值等于新 Link 对象的 next 值 
											//  使原来链表的第一个链结点成为当前链结点的下一个链结点
		this.first = l;						//  first --> l : 使新 Link 对象成为链表指向的第一个链结点 
	}
	/** 删除链表头的一个数据,即删除链表中的第一个链结点
	 *  通过把 first 重新指向第二个链结点,断开了和第一个链结点的链接,是 insertFirst() 的逆操作
	 */
	public Link deleteFirst()
	{
		Link temp = this.first;
		first = first.next;
		return temp;
	}
	/**
	 * @param key
	 * @return 查找包含关健字的链结点
	 */
	public Link find(int key)
	{
		Link current = first;					//  当前链结点,开始时指向 first,
		while(current.iData!=key)
		{
			if(current.next==null)
				return null;
			else
				current = current.next;			//  不断把自己赋值为 current.next,沿着链表向前移动
		}
		return current;
	}
	/**
	 * @param key
	 * @return 删除指定的链结点(包含指定值)
	 *  删除链结点后,必须把前一个链结点和后一个链结点连在一起,因此需要知道知道前一个链结点的位置.
	 */
	public Link delete(int key)
	{
		Link current = first;				//  当前链结点
		Link previous = first;				//  previous 指向当前链结点的前一个链结点
		while(current.iData!=key)
		{
			if(current.next==null)
				return null;
			else
			{
				//  在 current 赋值为 current.next 之前，先把 previous 赋值为 current，保证了 previous 总是指向 current 的
				//  前一个链结点
				previous = current;			
				current = current.next;
			}
		}
		if(current == first)				//  特殊情况:要删除的链结点是第一个链结点
			first = first.next;
		else
			previous.next = current.next;
		return current;	
	}
	/**
	 *  显示列表
	 */ 
	public void displayList()
	{
		System.out.print("List (first-->last): ");
		Link current = first;
		while(current!=null)
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
	public static void main(String[] args)
	{
		linkedList list = new linkedList();
		list.insertFirst(11,12.1);
		list.insertFirst(23,23.89);
		list.insertFirst(34, 38.9);
		
		list.displayList();
		
		while(!list.isEmpty())
		{
			Link fLink = list.deleteFirst();
			System.out.print("Deleted.. ");
			
			fLink.displayLink();
			System.out.println(" ");
		}
		
		list.displayList();
	}
}
/**
 * @author geeksun
 * @comment : Link - 链结点对象,链表由Link组成,每个Link对象中都有一个对下一个Link引用的字段next
 *  链结点类 ：链表的每个数据项都被包含在链结点(Link)中
 */
class Link{
	public int iData;
	public double dData;
	public Link next;
	public Link(int id,double dd)
	{
		iData = id;
		dData = dd;
	}
	/**
	 *  show Link property
	 */
	public void displayLink()
	{
		System.out.print("{" + iData +"," + dData + "}");
	}
}