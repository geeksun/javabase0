package com.base.pool;

import java.util.Vector;

/**
 * @author ��־ǿ ר�ö���ص�ʵ��
 *         ����ͨ�ö���صĹ������Ƚϴ�ĳ�̶ֳ��ϵ��������ö����������Ĵ󲿷����ơ�Ϊ��������⣬���Բ���ר�ö���صķ����� ����������ػ������
 *         Class���Ͳ��Ƕ�ָ̬���ģ�����Ԥ�Ⱦ���ָ��������������ʵ����Ҳ���ͨ�ö���ؼ�Щ�� ���Բ�ҪObjectPoolFactory��
 *         PoolableObjectFactory�࣬�������ǵĹ���ֱ���ںϵ�ObjectPool�� 2009-5-1
 */
public class SpecialObjectPool {
	private ParameterObject paraObj;// �ö���ص����Բ�������
	private int currentNum = 0; // �ö���ص�ǰ�Ѵ����Ķ�����Ŀ
	private StringBuffer currentObj;// �ö���ص�ǰ���Խ���Ķ���
	private Vector pool;// ���ڴ�Ŷ���ĳ�

	public SpecialObjectPool(ParameterObject paraObj) {
		this.paraObj = paraObj;
		pool = new Vector();
	}

	public StringBuffer getObject() {
		if (pool.size() <= paraObj.getMinCount()) {
			if (currentNum <= paraObj.getMaxCount()) {
				currentObj = new StringBuffer();
				currentNum++;
			}else {
				// �����ǰ�����޶�����ã������������Ķ�����Ŀ�Ѵﵽ�����Ƶ����ֵ��
				// ��ֻ�ܵȴ������̷߳��ض��󵽳���
				synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				currentObj = (StringBuffer) pool.firstElement();
				}
			}
		}else {
			// �����ǰ�����п��õĶ��󣬾�ֱ�Ӵӳ���ȡ������
			currentObj = (StringBuffer) pool.firstElement();
		}
		
		return currentObj;
	}

	public void returnObject(Object obj) {
		// ȷ�����������ȷ������
		if (StringBuffer.class.isInstance(obj)) { 
			pool.addElement(obj);
			synchronized (this) { 
				notifyAll();
			}
		}else {
			throw new IllegalArgumentException("�ö���ز��ܴ�� StringBuffer ���Ͷ���");
		}
	}
	
	
}
