package com.geeksun.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 姜志强
 *  无意识的递归
 *  2009-12-12
 */
public class InfiniteRecursion {

	/**
	 * @see java.lang.Object#toString()
	 * 打印对象的内存地址：不能用this, 因为在this的地方发生了自动类型转换, 因为编译器看到一个String对象后面跟着一个“+”, 而后面的对象（this）不是String, 于是编译器试着将this转换成一个
	 * String, 转换方法是调用this的toString(), 这样就发生了递归调用。正确方法是调用 Object.toString();
	 */
	public String toString(){
		//return "InfiniteRecursion address:" + this + "\n";		// 错误
		return super.toString();									// 正确
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for(int i=0;i<10;i++){
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);

	}

}
