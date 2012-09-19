package com.base.algorithms;
/**
 * @author geeksun
 * @comment : �� JAVA ʵ������,����ʹ�� util ������
 *  ʵ�ֲ���,�����ɾ���Ĳ���
 */
public class linkedList {
	// �Ե�һ�������������,ָ���һ�������
	private Link first;
	public linkedList()
	{
		first = null;
	}
	/** 
	 *  �ж������Ƿ�Ϊ�� 
	 */
	public boolean isEmpty()
	{
		return (first==null);
	}
	/** ������ı�ͷ����һ�������ӵ�
	 * @param id
	 * @param dd
	 */
	public void insertFirst(int id,double dd)
	{
		Link l = new Link(id,dd);
		l.next = this.first;				//  l --> old first : ʹԭ���� first ��ֵ������ Link ����� next ֵ 
											//  ʹԭ������ĵ�һ��������Ϊ��ǰ��������һ�������
		this.first = l;						//  first --> l : ʹ�� Link �����Ϊ����ָ��ĵ�һ������� 
	}
	/** ɾ������ͷ��һ������,��ɾ�������еĵ�һ�������
	 *  ͨ���� first ����ָ��ڶ��������,�Ͽ��˺͵�һ������������,�� insertFirst() �������
	 */
	public Link deleteFirst()
	{
		Link temp = this.first;
		first = first.next;
		return temp;
	}
	/**
	 * @param key
	 * @return ���Ұ����ؽ��ֵ������
	 */
	public Link find(int key)
	{
		Link current = first;					//  ��ǰ�����,��ʼʱָ�� first,
		while(current.iData!=key)
		{
			if(current.next==null)
				return null;
			else
				current = current.next;			//  ���ϰ��Լ���ֵΪ current.next,����������ǰ�ƶ�
		}
		return current;
	}
	/**
	 * @param key
	 * @return ɾ��ָ���������(����ָ��ֵ)
	 *  ɾ��������,�����ǰһ�������ͺ�һ�����������һ��,�����Ҫ֪��֪��ǰһ��������λ��.
	 */
	public Link delete(int key)
	{
		Link current = first;				//  ��ǰ�����
		Link previous = first;				//  previous ָ��ǰ������ǰһ�������
		while(current.iData!=key)
		{
			if(current.next==null)
				return null;
			else
			{
				//  �� current ��ֵΪ current.next ֮ǰ���Ȱ� previous ��ֵΪ current����֤�� previous ����ָ�� current ��
				//  ǰһ�������
				previous = current;			
				current = current.next;
			}
		}
		if(current == first)				//  �������:Ҫɾ����������ǵ�һ�������
			first = first.next;
		else
			previous.next = current.next;
		return current;	
	}
	/**
	 *  ��ʾ�б�
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
 * @comment : Link - ��������,������Link���,ÿ��Link�����ж���һ������һ��Link���õ��ֶ�next
 *  ������� �������ÿ��������������������(Link)��
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