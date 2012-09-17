package com.opera.pool;

import java.sql.Connection;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author 姜志强
 *  对象池（ObjectPool）类：常用的有 Thread pool、JDBC Connection pool、Socket Connection pool
 *　用于管理要被池化对象的借出和归还，并通知PoolableObjectFactory完成相应的工作。它一般包含如下两个方法：
 *	2009-5-1
 */
public class ObjectPool {
	private ParameterObject paraObj;	// 该对象池的属性参数对象
	private Class<?> clsType;			// 该对象池中所存放对象的类型
	private int currentNum = 0; 		// 该对象池当前已创建的对象数目
	private Object currentObj;			// 该对象池当前可以借出的对象
	private Vector<Object> pool;		// 用于存放对象的池
	// 期满时间
	private long expirationTime;
	// 清除无效对象的线程
	CleanUpThread cleaner;

	public ObjectPool(ParameterObject paraObj, Class<?> clsType) {
		this.paraObj = paraObj;
		this.clsType = clsType;
		pool = new Vector<Object>(); 
		//清理无效连接对象的线程，在对象池的构造器中被初始化并启动
		cleaner = new CleanUpThread(this, expirationTime);
		cleaner.start();
	}

	/**
	 *  获取对象
	 */
	public Object getObject() {
		if (pool.size() <= paraObj.getMinCount()) {
			if (currentNum <= paraObj.getMaxCount()) {
				// 如果当前池中无对象可用，而且已创建的对象数目小于所限制的最大值，就利用
				// PoolObjectFactory创建一个新的对象
				PoolableObjectFactory objFactory =PoolableObjectFactory.getInstance();
				currentObj = objFactory.createObject (clsType);
				currentNum++;
			} else {
				// 如果当前池中无对象可用，而且所创建的对象数目已达到所限制的最大值，
				// 就只能等待其它线程返回对象到池中
				synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				currentObj = pool.firstElement();
				}
			}
		} else {
			// 如果当前池中有可用的对象，就直接从池中取出对象
			currentObj = pool.firstElement();
		}
		return currentObj;
	}

	/**
	 *  返回对象
	 */
	public void returnObject(Object obj) {
		// 确保对象具有正确的类型， instanceof 运算符的动态等效方法
		if (((Class<?>) obj).isInstance(clsType)) {
			pool.addElement(obj);
			synchronized (this) { 
				notifyAll();
			}
		} else {
			throw new IllegalArgumentException("该对象池不能存放指定的对象类型");
		}
	}
	
	/**
	 *  清除连接池中的已损坏对象
	 */
	synchronized void cleanUp(){
		Connection conn;
		long currentTime = System.currentTimeMillis();
		/*Enumeration emumeration = pool.elements();
		
		while(emumeration.hasMoreElements()){
			//conn = (Connection) emumeration.nextElement();
			
			if((currentTime-((Long) pool.get(index)).longValue())>expirationTime){
				unlocked.remove(conn);
				expire(conn);
				//释放对该对象的引用
				conn = null;
			}
		}*/
		
		int size = pool.size();
		for(Object obj:pool){
			//Object obj = pool.get(i);
			if(obj!=null){
				//可以在对象中加上时间戳，到期后可使它失效
				//if((currentTime - obj.getCreateTime())>=expirationTime){
					pool.remove(obj);
					obj = null;
					
				//}
			}
		}
		
		//强制系统做垃圾回收
		System.gc();
	}
	
	/**
	 * @author 姜志强
	 *  开一个线程用于清除连接池中的已损坏对象
	 */
	class CleanUpThread extends Thread {
		private ObjectPool pool;
		private long sleepTime;
		
		CleanUpThread(ObjectPool pool, long sleepTime){
			this.pool = pool;
			this.sleepTime = sleepTime;
		}
		
		public void run(){
			while(true){
				try{
					sleep(sleepTime);
				}catch(Exception e){
					e.printStackTrace();
				}
				pool.cleanUp();
			}
		}
	}
	
	
}
