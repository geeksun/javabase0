package com.base.test;

/**
 * @author jzq
 * 整型值在机器中正是以二进制补码存放，在JAVA中，用print函数输出的是其十进制形式。&运算符会将两边的操作数按其二进制形式逐个bit 求与，
 * 并最终生成一个整型值(不同于逻辑与，生成的是boolean)。这样，可利用比特1去逐位测试，结果不为0，说明待测试位为1，否则为0。
 * 将一个整型值的每一 bit 都确定了，其二进制补码也就确定了。
 *  2009-5-8
 */
public class Bcode {
	
	public static void main(String[] args) {
		pBcode(-1);
	}

	/**
	 *  给定任一整型值，输出其二进制补码(即机器码) --》计算机中存储数据以补码来存储。
	 */
	static void pBcode(int i) {
		System.out.print(i + "的二进制补码是:");

		for (int j = 31; j >= 0; j--) {

			if (((1 << j) & i) != 0) 	//用 00000000000000000000000000000001移位实现比特"1"测试
				System.out.print("1");
			else
				System.out.print("0");
		}
		
	}
	
	
}
