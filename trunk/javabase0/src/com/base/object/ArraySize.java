package com.base.object;

/**
 * @author ��־ǿ
 *  ����Ĵ�С: 
 *  2009-4-27
 */
public class ArraySize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] sites = new String[10];
		String[] place = {"alibaba", "taobao", "zfb"};
		sites = place;
		System.err.print(sites.length);
	}

}
