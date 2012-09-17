package com.opera.pool;

/**
 * @author 姜志强
 *  客户端调用对象池: 通用对象池使用起来还是很方便的，不仅可以方便地避免频繁创建对象的开销，而且通用程度高。
 *  但遗憾的是，由于需要使用大量的类型定型 （cast）操作，再加上一些对Vector类的同步操作，使得它在某些情况下对性能的改进非常有限，
 *  尤其对那些创建周期比较短的对象。
 *  2009-5-1
 */
public class TestObjectPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建对象池工厂
		ObjectPoolFactory poolFactory = ObjectPoolFactory. getInstance ();
		//定义所创建对象池的属性
		ParameterObject paraObj = new ParameterObject(10,2);
		
		//利用对象池工厂, 创建一个存放 StringBuffer 类型对象的对象池
		//ObjectPool pool = poolFactory.createPool(paraObj, StringBuffer.class);
		/*//从池中取出一个StringBuffer对象
		StringBuffer buffer = (StringBuffer)pool.getObject();
		
		//使用从池中取出的StringBuffer对象
		buffer.append("hello");
		System.out.println(buffer.toString()); */
		
		//利用对象池工厂, 创建一个存放 Man 类型实例的对象池
		ObjectPool pool = poolFactory.createPool(paraObj, Man.class);
		Man man = (Man) pool.getObject();
		man.setAge(18);
		System.out.print(man.getAge());
		
	}

}
