package com.base.pattern.proxy;

/**
 * @author 姜志强
 *  抽象目标接口：声明真实目标和代理的共同接口, 这样在任何可以使用真实目标的地方都可以使用使用代理目标。
 *  2009-5-19
 */
public interface AbstractTarget {
	
	//处理客户端请求方法
	public void handleRequest();
	
}
