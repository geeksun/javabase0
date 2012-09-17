package com.base.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 统计Random随机数据的分布的理想性: 使用Map
 * @author 姜志强
 * 2009-12-12
 */
public class Statistics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random(47);
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(int i=0;i<10000;i++){
			int r = rand.nextInt(20);
			Integer freq = m.get(r);
			m.put(r, freq == null? 1 : freq + 1);
		}
		System.out.println(m);
		
	}

}
