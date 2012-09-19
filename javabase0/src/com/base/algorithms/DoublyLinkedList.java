package com.base.algorithms;
/**
 *  ˫������:ÿ�������������ָ��������������
 *  @comment : Link - ��������,������Link���,ÿ��Link�����ж���һ������һ��Link���õ��ֶ�next
 *                  - ��һ������һ��Link���õ��ֶ�previous
 *  ������� �������ÿ��������������������(Link)��
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
 *  ˫������:ÿ�������������ָ��������������
 *  ˫�������Ԫ������û��˳��,nextΪnull��ζ������Ľ�β
 *  ����ɾ�������� insertAfter() ʱ,Ӧ���� isEmpty() �ж������Ƿ�Ϊ��
 */
public class DoublyLinkedList {
	private DLink first;
	private DLink last;				//  �����һ������������
	public DoublyLinkedList()
	{
		first = null;
		last = null;
	}
	/**
	 *  @�ж������Ƿ�Ϊ��,return ����ֵ 
	 */
	public boolean isEmpty()
	{
		return first==null;
	}
	/**
	 * @param dd
	 *  �ڱ�ͷ����һ�������
	 */
	public void insertFirst(long dd)
	{
		DLink newLink = new DLink(dd);
		
		if(isEmpty())			// �������Ϊ��
			last = newLink;		// newLink <-- last
		else 
			first.previous = newLink;	// newLink <-- old first ���ν���������ν��
		newLink.next = first;			// newLink <-- old first ���ν���������ν��
		first = newLink;				// first --> newLink ���ν���������ν��
	}
	/**
	 * @param dd
	 *  ������β����һ�������
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
	 * @ɾ����һ������� return ��һ��������ֵ
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
	 * @ɾ�����һ�������,return ���һ�������
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
	 * @���� dd �� key �ĺ���,��ĳ���ض�ֵ�������ĺ������һ���µ������
	 *  ��� key ֵ������,��������� dd 
	 */
	public boolean insertAfter(long key,long dd)
	{
		DLink current = first;
		while(current.dData!=key)	// until match is found,ֱ���ҵ�ƥ��ֵΪֹ
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
	 * @ɾ��ָ��ֵ�������,return��ɾ��������� 
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
	 *  �ӱ�ͷ��ʼ�ı���,���ε���β
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
	 *  �ӱ�β��ʼ�ı���,���ε���ͷ
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
		dl.insertAfter(19,34);		//  ���ᱻ����,��Ϊ 19 ������
		
		dl.displayForward();
	}
}
