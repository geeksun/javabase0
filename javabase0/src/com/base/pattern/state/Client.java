package com.base.pattern.state;

/**
 * Description 状态模式客户端测试
 * @author Administrator
 * 2012-9-20
 */
public class Client {

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// 创建状态
		State state = new StateA();
		// 创建环境
		Context context = new Context();
		// 把状态设到环境中
		context.set_instance(state);
		// 请求
		context.request();
	}

}
