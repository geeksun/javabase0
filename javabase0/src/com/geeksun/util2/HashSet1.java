package com.geeksun.util2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Administrator
 * @category : ʵ�� Set �ӿڵ���������,HashSet,TreeSet
 * �����ڵ�Ԫ�ز������ظ�;�����ڵ�����û��˳��  
 */
public class HashSet1 {
	public static void main(String[] args){
		Set<String> hs = new HashSet<String>();
		System.out.println("�������Ԫ��"); 
		hs.add("���");
		hs.add("Hello");
		hs.add("glad");
		hs.add("���");								//   Set�в��������ظ���Ԫ�ش���,�˴������Ч
		System.out.println("Ԫ�ظ���:"+hs.size());
		
		Iterator it = hs.iterator();
		while(it.hasNext()){							// ���� Set �е�Ԫ��
			String s = (String) it.next();
			System.out.println(s);
		}

		System.out.println("ɾ��һ��Ԫ��");
		System.out.println("Set���Ƿ����'���':"+hs.contains("���"));
		hs.remove("���");
		System.out.println("Ԫ�ظ�����"+hs.size());
	}
}
