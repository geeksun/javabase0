package com.base.util;

/**
 * @author geeksun
 * @version �ݹ����:����������������� -- recursive call
 * �ݹ�ʹ���˶�ջ����������ʱ������"�Ƚ����"��ԭ�����
 */
public class DiGui {
	void hi(int n){
		if(n<=0){
			return;
		}
		hi(n-1);								// recursive call
		System.out.println("��� " + n);
	}
	/**
	 * @param n
	 * @return for ѭ����׳�
	 */
	long factorial(int n){
		long f = 1;
		for(int i=2;i<=n;i++){
			f *= i;
		}
		return f;
	}
	/**
	 * @param n
	 * @return �ݹ���׳�
	 */
	long factorial2(int n){
		if(n<=1) return 1;
		return factorial2(n-1)*n;
	}
	/**@version �ݹ���������,forѭ����������
	 * @param n
	 * @return �ݹ���1-n�ĺ�
	 */
	long sum(int n){
		if(n<=1) return 1;
		return sum(n-1)+n;															
	}
	public static void main(String[] args){
		DiGui dg = new DiGui();
		dg.hi(3);
		System.out.println(dg.factorial(3));
		System.out.println(dg.factorial2(3));
		System.out.println("sum(10)="+dg.sum(10));
	}
}
