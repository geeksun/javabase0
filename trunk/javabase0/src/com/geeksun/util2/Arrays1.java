package com.geeksun.util2;

import java.util.Arrays;

/**
 * @category Arrays���ṩ�����������Ƚϼ���������,���з������Ǿ�̬����
 * @author geeksun
 * 2010-4-20
 */
public class Arrays1 {
	
	/**
	 * Arrays���ֲ����㷨����: �ö��ֲ��ҷ��ҳ�����int a[]���Ƿ����key��ֵ(int ��)
	 * @param a
	 * @param key
	 * @return
	 * @see #sort(int[] a)
	 */
	public static int binarySearch(int[] a, int key) {
		Arrays.sort(a);
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) >> 1;
			int midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}
	
	/**
	 * �ö��ֲ��ҷ��ҳ�����int a[]���Ƿ����key��ֵ(int ��)
	 * @param a
	 * @param value
	 * @return value ������λ�ã����򷵻ظ���
	 */
	public static int binarySearch3(int[] a, int value){
		Arrays.sort(a);		//	���������򣬷����޷���Ч����
		int low = 0;	//	��λ����
		int high = a.length - 1;	// ��������Ԫ�ص��±�λ�ã���λ����
		
		while(low<=high){
			int mid = (low + high)>>1;
			int midVal = a[mid];	//	�����м�Ԫ�ص��±�λ��
			if(value>midVal){	
				low = mid + 1;	//	��λ�±�����һλ������������Ŀ��Value
			}else if(value<midVal){
				low = mid - 1;
			}else{
				return mid;
			}
		}
		return -(low + 1);	// û�ҵ�value,low�ҵ��±�λ��
	}
	
	public static void main(String [] args){
		int[] a = new int[]{22,82,19,98,11,12,27};
		Arrays.sort(a);
		
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]+" ");
		}
		// binary search
		binarySearch(a,27);
		System.out.println("27 place:"+Arrays.binarySearch(a,27));
	}
	
}
