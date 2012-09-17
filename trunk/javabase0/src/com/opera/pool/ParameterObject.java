package com.opera.pool;

/**
 * @author ��־ǿ
 *  ��������ԣ���ParameterObject��
���� ������Ҫ���ڷ�װ����ص�һЩ���Բ���������пɴ�Ŷ������Ŀ�����ֵ��maxCount������Сֵ��minCount���ȡ�
	2009-5-1
 */
public class ParameterObject {
	//���пɴ�Ŷ������Ŀ�����ֵ
	private int maxCount;
	//���пɴ�Ŷ������Ŀ����Сֵ
	private int minCount;
	// ����ʱ��
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
