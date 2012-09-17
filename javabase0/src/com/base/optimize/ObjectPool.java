package com.base.optimize;

import java.util.Hashtable;

/**
 * @author 姜志强 对象池：缓存对象，可以提高应用的速度，减少内存需要。如JDBC连接池或EJB实例池,线程池。
 *         提升系统性能，节约系统内存开销，通过对其所保存对象的共享和重用，缩减了应用线程反复重建、装载对象的过程所需要的时间，
 *         并且也有效避免了频繁垃圾回收带来的巨大系统开销。 
 * 2009-4-30
 */
public abstract class ObjectPool {
	// 锁定，未锁定
	private Hashtable locked, unlocked;
	// 期满时间
	private long expirationTime;

	// 创建对象
	abstract Object create();

	// 对象过期
	abstract void expire(Object o);

	// 对象有效性验证
	abstract void validate(Object o);

	// 获取对象
	synchronized Object getObject() {
		return null;
	}

	// 对象释放: 抽象方法不能声明为同步, 因为连方法的具体实现还不清楚，何来同步的需求？可以在子类的实现方法里面实现
	synchronized void freeObject(Object o) {
		o = null;
	}
	
	// 清除无效对象
	synchronized  void cleanUp(){
		
	}
}
