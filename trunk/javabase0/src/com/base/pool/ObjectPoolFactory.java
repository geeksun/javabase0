package com.base.pool;

/**
 * @author 姜志强
 *  对象池工厂:该类主要用于管理相同类型和设置的对象池（ObjectPool）, 使用单例模式
 *  2009-5-1
 */
public class ObjectPoolFactory {
	private static ObjectPoolFactory poolFactory;

	private ObjectPoolFactory(){}
	
	/**
	 *  获取对象池工厂实例
	 */
	public static ObjectPoolFactory getInstance() {
		if (poolFactory == null) {
			poolFactory = new ObjectPoolFactory();
		}
		return poolFactory;
	}

	/**
	 *  用于创建特定类型和设置的对象池, 在ObjectPoolFactory类创建对象池时，动态指定该对象池所池化对象的Class类型
	 */
	public ObjectPool createPool(ParameterObject paraObj,Class<?> clsType) {
		return new ObjectPool(paraObj, clsType);
	}

	/** 
	 *  用于释放指定的对象池
	 */
	public void destroyPool(ObjectPool pool) {
		
		pool = null;
	}
	
}
