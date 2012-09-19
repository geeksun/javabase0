package com.base.math;

import java.math.BigDecimal;

/**
 * @author 姜志强
 * 大实数的用法
 */
public class BigDecimal1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimal bc = new BigDecimal("12345678.133456");
		BigDecimal bd = bc.movePointLeft(3);		// 小数点左移3位
		System.out.println(bd);
		
		BigDecimal c = bc.divide(bd,BigDecimal.ROUND_DOWN);		// 相除,不四舍五入
		System.out.println(c);
		BigDecimal ct = bc.divide(bd,5,BigDecimal.ROUND_DOWN);	//  5位有效数字
		System.out.println(ct);
	}

}
