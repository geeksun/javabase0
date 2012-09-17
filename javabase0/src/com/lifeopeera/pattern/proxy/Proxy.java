package com.lifeopeera.pattern.proxy;

/**
 * @author 姜志强
 *  代理角色类: 含有对真实目标的引用，从而可以在任何时候操作真实目标对象，另外代理角色提供一个与真实目标角色相同的接口，以便可以在
 *  任何时候都可以替代真实目标，其次代理角色还可以控制对真实目标的引用，负责在需要的时候创建或者删除真实目标对象。最后，代理角色通常
 *  在将客户端调用传递给真实的目标之前或者之后都要执行某个操作，而不是单纯地将调用传递给真实对象，但是这个前置的处理操作并不是必须的，
 *  在某些情况下是不需要的。
 *  依赖于真实目标类。
 *  2009-5-19
 */
public class Proxy implements AbstractTarget {
	//引用真实目标对象
    RealTarget realTarget = new RealTarget();
    
    public Proxy(){}
    
	/**
	 *  代理行为方法：（处理客户端请求方法）
	 */
	public void handleRequest() {
		//调用代理前置行为方法
		handlePreRequest();
		//调用真实目标方法
		realTarget.handleRequest();
		//调用代理善后方法
		handlePostRequest();
	}

	/**
	 *  调用代理前置行为方法
	 */
	private void handlePostRequest() {
		
	}

	/**
	 *  调用代理善后方法
	 */
	private void handlePreRequest() {
		
	}

}
