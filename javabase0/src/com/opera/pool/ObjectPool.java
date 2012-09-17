package com.opera.pool;

import java.sql.Connection;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author ��־ǿ
 *  ����أ�ObjectPool���ࣺ���õ��� Thread pool��JDBC Connection pool��Socket Connection pool
 *�����ڹ���Ҫ���ػ�����Ľ���͹黹����֪ͨPoolableObjectFactory�����Ӧ�Ĺ�������һ�������������������
 *	2009-5-1
 */
public class ObjectPool {
	private ParameterObject paraObj;	// �ö���ص����Բ�������
	private Class<?> clsType;			// �ö����������Ŷ��������
	private int currentNum = 0; 		// �ö���ص�ǰ�Ѵ����Ķ�����Ŀ
	private Object currentObj;			// �ö���ص�ǰ���Խ���Ķ���
	private Vector<Object> pool;		// ���ڴ�Ŷ���ĳ�
	// ����ʱ��
	private long expirationTime;
	// �����Ч������߳�
	CleanUpThread cleaner;

	public ObjectPool(ParameterObject paraObj, Class<?> clsType) {
		this.paraObj = paraObj;
		this.clsType = clsType;
		pool = new Vector<Object>(); 
		//������Ч���Ӷ�����̣߳��ڶ���صĹ������б���ʼ��������
		cleaner = new CleanUpThread(this, expirationTime);
		cleaner.start();
	}

	/**
	 *  ��ȡ����
	 */
	public Object getObject() {
		if (pool.size() <= paraObj.getMinCount()) {
			if (currentNum <= paraObj.getMaxCount()) {
				// �����ǰ�����޶�����ã������Ѵ����Ķ�����ĿС�������Ƶ����ֵ��������
				// PoolObjectFactory����һ���µĶ���
				PoolableObjectFactory objFactory =PoolableObjectFactory.getInstance();
				currentObj = objFactory.createObject (clsType);
				currentNum++;
			} else {
				// �����ǰ�����޶�����ã������������Ķ�����Ŀ�Ѵﵽ�����Ƶ����ֵ��
				// ��ֻ�ܵȴ������̷߳��ض��󵽳���
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
			// �����ǰ�����п��õĶ��󣬾�ֱ�Ӵӳ���ȡ������
			currentObj = pool.firstElement();
		}
		return currentObj;
	}

	/**
	 *  ���ض���
	 */
	public void returnObject(Object obj) {
		// ȷ�����������ȷ�����ͣ� instanceof ������Ķ�̬��Ч����
		if (((Class<?>) obj).isInstance(clsType)) {
			pool.addElement(obj);
			synchronized (this) { 
				notifyAll();
			}
		} else {
			throw new IllegalArgumentException("�ö���ز��ܴ��ָ���Ķ�������");
		}
	}
	
	/**
	 *  ������ӳ��е����𻵶���
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
				//�ͷŶԸö��������
				conn = null;
			}
		}*/
		
		int size = pool.size();
		for(Object obj:pool){
			//Object obj = pool.get(i);
			if(obj!=null){
				//�����ڶ����м���ʱ��������ں��ʹ��ʧЧ
				//if((currentTime - obj.getCreateTime())>=expirationTime){
					pool.remove(obj);
					obj = null;
					
				//}
			}
		}
		
		//ǿ��ϵͳ����������
		System.gc();
	}
	
	/**
	 * @author ��־ǿ
	 *  ��һ���߳�����������ӳ��е����𻵶���
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
