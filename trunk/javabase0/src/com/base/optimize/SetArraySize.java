package com.base.optimize;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ��־ǿ 
 *  �����һ���ܴ�����飬������Ԥ��������齫�����쳣�Ӵ��������һ���취������������Ԫ�ص��ٶȣ��Ż�ϵͳ���ܡ�
 *  ʹ�� ArrayList ����� ensureCapacity() ����Ԥ����������Ĵ�С����ǰ����ϵͳ�����������������ó�ʼ������.
 *  2009-5-7
 */
public class SetArraySize {
	
	/**
	 * @param list
	 * @return �̰߳�ȫ(thread-safe)�� ArrayList �������ܲ��� Vector
	 */
	List<?> synArrayList(ArrayList<?> list){
		//�� ArrayList ���ʶΪ�̰߳�ȫ(thread-safe)�Ķ���
		List<?> rlist = Collections.synchronizedList(list);
		return rlist;  
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int N = 1000000;
		Object obj = new Object();
		//û�е���ensureCapacity() ������ʼ�� ArrayList ����
		List<Object> list = new ArrayList<Object>();
		long startTime = System.currentTimeMillis();
		for(int i=1;i<N;i++){
			list.add(obj);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("û�е��� ensurecapatity ����:" + (endTime-startTime)+"ms");
		
		list = new ArrayList<Object>();
		startTime = System.currentTimeMillis();
		//���� ensureCapacity() ������ʼ�� ArrayList ����
		((ArrayList<Object>) list).ensureCapacity(N);
		 for(int i=1;i<N;i++){
			 list.add(obj);
		 }
		endTime = System.currentTimeMillis();
		System.out.println("����ensurecapatity ����:" + (endTime-startTime)+"ms");
		
		/* �����
		 * û�е��� ensurecapatity ����:156ms
		   ����ensurecapatity ����:63ms
		 */
	}

}
