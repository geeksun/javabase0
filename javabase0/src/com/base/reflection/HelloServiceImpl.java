package com.base.reflection;

import java.util.Date;

public class HelloServiceImpl implements HelloService{

	public String echo(String msg) {
		return "echo:"+msg;
	}

	public Date getTime() {
		return new Date();
	}
	
}
