package com.base.algorithms;

/**
 * Description ��������
 * @author Administrator
 * 2012-9-15
 */
public class QuickSort4 {
	
	/**
	 * @param data Ҫ���������
	 * @param left ��������±�
	 * @param right �ұ������±�
	 */
	static void quickSort(int[] data, int left, int right){
		if(left<right){
			// һ�������㷨�� ������ťλ��
			int pivot = partition(data, left, right);
			// �������
			quickSort(data, left, pivot-1);
			// �ұ�����
			quickSort(data, pivot+1, right);
		}
	}
	
	/**
	 * һ�˿��������㷨
	 * ����¼����data�ֳ������֣�leftΪ��ʼ�±꣬rightΪ�����±� 
	 * @param data
	 * @param left
	 * @param rightt
	 * @return ��ťλ��
	 */
	static int partition(int[] data, int left, int right){
		int key = data[left];
		int temp;
		
		while(left < right){
			// ���ұ߿�ʼ����һ��С��Key��Ԫ����Key����λ��
			while(left<right && data[right]>=key)
				right--;
			
			//����Ԫ��λ��
			temp = data[right];
			data[right] = data[left];
			data[left] = temp;
			
			// ����߿�ʼ����һ������Key��Ԫ����Key����λ��
			while(left<right && data[left]<=key)
				left++;
			
			//����Ԫ��λ��
			temp = data[right];
			data[right] = data[left];
			data[left] = temp;
		}
		
		return left;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int data[] = {44,22,2,32,54,22,88,77,99,11,3,98,101,23,834,11,23,53,18};
		quickSort(data, 0, data.length-1);
		for(int i=0;i<data.length;i++){
			System.out.print(" "+data[i]);
		}
	}

}
