package com.base.pool;

/**
 * @author 姜志强
 *  池化对象工厂（PoolableObjectFactory）类
　　该类主要负责管理池化对象的生命周期，就简单来说，一般包括对象的创建及销毁。该类同ObjectPoolFactory一样，也可将其实现为单实例。
	2009-5-1
	工作中注重结果，生活中享受过程。
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
	 *  新对象实例的创建
	 */
	public Object createObject(Class<?> clsType) {
		Object obj = null; 
		try {
			//生成类的新实例
			obj = clsType.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
