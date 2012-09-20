package com.base.pattern.state;

/**
 * Description 环境角色， 持有一个State对象
 * @author Administrator
 * 2012-9-19
 */
public class Context {
	private State _instance;

	public State get_instance() {
		return _instance;
	}

	public void set_instance(State _instance) {
		this._instance = _instance;
	}
	
	void request(){
		_instance.handle();
	}
	
}
