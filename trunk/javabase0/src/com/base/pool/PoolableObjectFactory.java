package com.base.pool;

/**
 * @author ��־ǿ
 *  �ػ����󹤳���PoolableObjectFactory����
����������Ҫ�������ػ�������������ڣ��ͼ���˵��һ���������Ĵ��������١�����ͬObjectPoolFactoryһ����Ҳ�ɽ���ʵ��Ϊ��ʵ����
	2009-5-1
	������ע�ؽ�������������ܹ��̡�
 */
public class PoolableObjectFactory {
	private static PoolableObjectFactory poolableObjectFactory;

	private PoolableObjectFactory(){}
	
	public static PoolableObjectFactory getInstance() {
		if(poolableObjectFactory==null){
			poolableObjectFactory = new PoolableObjectFactory();
		}
		return poolableObjectFactory;
	}

	/**
	 *  �¶���ʵ���Ĵ���
	 */
	public Object createObject(Class<?> clsType) {
		Object obj = null; 
		try {
			//���������ʵ��
			obj = clsType.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
