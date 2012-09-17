package com.lifeopeera.pattern.proxy;

/**
 * @author 姜志强
 *  真实目标角色类：定义了代理角色所代理的真实对象，它是客户端真正想与之交流的对象。
 *  2009-5-19
 */
public class RealTarget implements AbstractTarget {

	public RealTarget() {
	}

	/**
	 *  处理客户端请求方法
	 */
	public void handleRequest() {
		//handle sth

	}

}
