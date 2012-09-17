package com.base.optimize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ��־ǿ
 *  ArrayList �� LinkedList �����ܶԱȣ�������������: ArrayList���ҿ죬�����ɾ����; LinkedList�������������ɾ���졣
 *  ��ΪArrayList�ǻ������飬LinkedList�ǻ�������
 *  2009-5-8
 */
public class ArrayListPKLinkedList {
	final static int M = 25000;
	final static int N = 25000;
	static long startTime;
	static long endTime;
	
	/**
	 *  ����Ԫ�ز���
	 */
	public static void insertElementToList(){
		//ʹ�� ArrayList ���������Ԫ��
		List al = new ArrayList();
		startTime = System.currentTimeMillis();
		for(int i=1;i<M;i++){
			al.add(0, new Integer(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println("Use ArrayList Insert:" + (endTime-startTime)+"ms");
		//ʹ�� LinkedList ���������Ԫ��
		List ll = new LinkedList();
		startTime = System.currentTimeMillis();
		for(int i=1;i<M;i++){
			ll.add(0, new Integer(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println("Use LinkedList Insert:" + (endTime-startTime)+"ms");
		
	}
	
	/**
	 *  ����Ԫ�ز���
	 */
	static void lookUpElement(){
		Object o;
		//�� ArrayList ���������Ԫ��
		List al = new ArrayList();
		for(int i=0;i<N;i++){
			al.add(new Integer(i));
		}
		startTime = System.currentTimeMillis();
		for(int i=0;i<N;i++){
			o = al.get(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Use ArrayList lookUp:" + (endTime-startTime)+"ms");
		//�� LinkedList �������������Ԫ��
		List ll = new LinkedList();
		for(int i=0;i<N;i++){
			ll.add(new Integer(i));
		}
		startTime = System.currentTimeMillis();
		for(int i=0;i<N;i++){
			o = ll.get(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Use LinkedList lookUp:" + (endTime-startTime)+"ms");
	}
	
	public static void main(String[] args) {
		insertElementToList();
		lookUpElement();

	}

}
