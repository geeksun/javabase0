package com.geeksun.util;

/**
 * @author geeksun
 * @version 回调函数：就是由程序员编写的，由WINDOWS系统调用的函数,主要用于异步通信,如在AJAX里
 * JAVA 中回调函数一般是通过接口实现的
 */
public class CallBack {
	   public static void main(String[] args){
	     FooBar foo=new FooBar();
	     foo.setCallBack(new ICallBack(){
	        public void postExec(){System.out.println("method executed.");}
	     });
	   }
	}

	