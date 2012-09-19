package com.base.math;

import java.math.BigDecimal;

/**
 * @author ��־ǿ
 * ��ʵ�����÷�
 */
public class BigDecimal1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimal bc = new BigDecimal("12345678.133456");
		BigDecimal bd = bc.movePointLeft(3);		// С��������3λ
		System.out.println(bd);
		
		BigDecimal c = bc.divide(bd,BigDecimal.ROUND_DOWN);		// ���,����������
		System.out.println(c);
		BigDecimal ct = bc.divide(bd,5,BigDecimal.ROUND_DOWN);	//  5λ��Ч����
		System.out.println(ct);
	}

}
