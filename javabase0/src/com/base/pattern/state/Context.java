package com.base.pattern.state;

/**
 * Description ������ɫ�� ����һ��State����
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
