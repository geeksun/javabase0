package com.base.pattern.factory;

/**
 *  Person 工厂类,负责生成大量 Person,前提是实现了Person接口
 */
public class PersonFactory {
	/**
	 * 获得 Person 实例的实例工厂方法
	 * @param ethnic
	 * @return  
	 */
	public Person getPerson(String ethnic)
	{
		// 根据参数返回 Person 接口的实例
		if(ethnic.equalsIgnoreCase("chinese"))
		{
			return new Chinese();
		}
		else
		{
			return new American();
		}
	}

}
