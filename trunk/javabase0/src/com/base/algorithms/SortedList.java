package com.base.algorithms;
/**
 *  ��������:�����е���������˳���
 *  @comment : Link - ��������,������Link���,ÿ��Link�����ж���һ������һ��Link���õ��ֶ�next
 *  ������� �������ÿ��������������������(Link)��
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
	 *  ��ʾ�����
	 */
	public void displayLink()
	{
		System.out.print(dData+" ");
	}
}
/**
 * @author Administrator
 *  ��������,�����ǰ��ؽ�ֵ�������е�
 */
public class SortedList {
	private SLink first;
	public SortedList()
	{
		first = null;
	}
	/**
	 *  �ж������Ƿ�Ϊ�� 
	 */
	public boolean isEmpty()
	{
		return first==null;
	}
	/**
	 * @param key
	 *  �����������в��������,����˳���������
	 *  �����㷨������������,ֱ���ҵ����ʵ�λ��;��ǡ���ڵ�һ����������������ǰ��.
	 */
	public void insert(long key)
	{
		SLink newLink = new SLink(key);
		SLink previous = null;		  
		SLink current = first;		//  �� first ��ʼ����,�ڸýڵ�֮ǰ����:�ýڵ�Ϊ��һ����Ҫ����ڵ��������Ľ��
		
		while(current!=null&&key>current.dData)		//  Ѱ��Ҫ�����������λ��
		{
			previous = current;
			current = current.next;
		}
		if(previous==null)					//  �������ڱ�ͷ
			first = newLink;
		else
			previous.next = newLink;
		newLink.next = current;
	}
	/**
	 * @return Ҫɾ���������
	 *  ɾ����һ�������
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
