package com.base.pool;

/**
 * @author ��־ǿ
 *  ����ع���:������Ҫ���ڹ�����ͬ���ͺ����õĶ���أ�ObjectPool��, ʹ�õ���ģʽ
 *  2009-5-1
 */
public class ObjectPoolFactory {
	private static ObjectPoolFactory poolFactory;

	private ObjectPoolFactory(){}
	
	/**
	 *  ��ȡ����ع���ʵ��
	 */
	public static ObjectPoolFactory getInstance() {
		if (poolFactory == null) {
			poolFactory = new ObjectPoolFactory();
		}
		return poolFactory;
	}

	/**
	 *  ���ڴ����ض����ͺ����õĶ����, ��ObjectPoolFactory�ഴ�������ʱ����ָ̬���ö�������ػ������Class����
	 */
	public ObjectPool createPool(ParameterObject paraObj,Class<?> clsType) {
		return new ObjectPool(paraObj, clsType);
	}

	/** 
	 *  �����ͷ�ָ���Ķ����
	 */
	public void destroyPool(ObjectPool pool) {
		
		pool = null;
	}
	
}
