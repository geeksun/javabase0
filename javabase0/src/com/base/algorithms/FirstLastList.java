package com.base.algorithms;

/**
 * @comment : Link - ��������,������Link���,ÿ��Link�����ж���һ������һ��Link���õ��ֶ�next
 *  ������� �������ÿ��������������������(Link)��
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
 *  ˫������:����������,����һ������,�����һ������������
 */
public class FirstLastList {
	private FLink first;
	private FLink last;			//  �����һ���ڵ������
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
	 *  ��˫������ͷ����һ�����ڵ�
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
	 *  ��˫������β����һ�����ڵ�
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
	 *  ɾ��˫������ĵ�һ�������
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
	 *  ��ʾ����
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
