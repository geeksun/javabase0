package com.base.pool;

import java.util.Vector;

/**
 * @author 姜志强 专用对象池的实现
 *         由于通用对象池的管理开销比较大，某种程度上抵消了重用对象所带来的大部分优势。为解决该问题，可以采用专用对象池的方法。 即对象池所池化对象的
 *         Class类型不是动态指定的，而是预先就已指定。这样，它在实现上也会较通用对象池简单些， 可以不要ObjectPoolFactory和
 *         PoolableObjectFactory类，而将它们的功能直接融合到ObjectPool类 2009-5-1
 */
public class SpecialObjectPool {
	private ParameterObject paraObj;// 该对象池的属性参数对象
	private int currentNum = 0; // 该对象池当前已创建的对象数目
	private StringBuffer currentObj;// 该对象池当前可以借出的对象
	private Vector pool;// 用于存放对象的池

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
				// 如果当前池中无对象可用，而且所创建的对象数目已达到所限制的最大值，
				// 就只能等待其它线程返回对象到池中
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
			// 如果当前池中有可用的对象，就直接从池中取出对象
			currentObj = (StringBuffer) pool.firstElement();
		}
		
		return currentObj;
	}

	public void returnObject(Object obj) {
		// 确保对象具有正确的类型
		if (StringBuffer.class.isInstance(obj)) { 
			pool.addElement(obj);
			synchronized (this) { 
				notifyAll();
			}
		}else {
			throw new IllegalArgumentException("该对象池不能存放 StringBuffer 类型对象");
		}
	}
	
	
}
