package com.opera.pool;

/**
 * @author 姜志强
 *  对象池属性：（ParameterObject）
　　 该类主要用于封装对象池的一些属性参数，如池中可存放对象的数目的最大值（maxCount）、最小值（minCount）等。
	2009-5-1
 */
public class ParameterObject {
	//池中可存放对象的数目的最大值
	private int maxCount;
	//池中可存放对象的数目的最小值
	private int minCount;
	// 期满时间
	private long expirationTime;
	
	public long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(long expirationTime) {
		this.expirationTime = expirationTime;
	}

	public ParameterObject(int max, int min){
		this.maxCount = max;
		this.minCount = min;
	}
	
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public int getMinCount() {
		return minCount;
	}
	public void setMinCount(int minCount) {
		this.minCount = minCount;
	}

	
}
