package com.geeksun.util2;

import java.util.Vector;

/**
 * @author Administrator
 * @category : ʵ�� List �ӿڵ���������,ArrayList,Vector,LinkedList
 * �����ڵ�Ԫ�������ظ�;�����ڵ��������ض���˳��  
 * Vector �ķ�����ͬ���������ǰ�ȫ��
 */
public class Vector1 {
	public static void main(String[] args){
		Vector vec = new Vector();
		vec.addElement("Hi");
		vec.addElement(new Integer(8));
		vec.addElement(new StringBuffer("abc"));
		
		for(int i=0;i<vec.size();i++){
			System.out.println(vec.elementAt(i));
		}
		System.out.println(vec.size());
		System.out.println(vec.capacity());					// ����
	}
}
