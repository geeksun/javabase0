package com.geeksun.object;

import java.io.Serializable;

/**
 * @author 姜志强
 *  transient: 瞬间值，用于远程方法调用（RMI）应用时，修饰对象中不需要传递的属性，这样可以节约调用端的内存资源，
 *  节约不必要的网络开销，加快传输速度，提高系统性能。
 *  2009-5-1
 */
public class TransientTest implements Serializable{
	int size;
	String name;
	transient String description;		//在远程方法调用时，不会传输该属性
	
	
}
