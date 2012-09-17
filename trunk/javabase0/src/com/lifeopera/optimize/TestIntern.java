package com.lifeopera.optimize;

/**
 * @author 姜志强
 *  intern(): 字符串驻留，将字符串添加到驻留字符串池中; 在不必须要求采用 equals()做字符串比较时，可以采用字符串驻留的方法，
 *  以提高系统性能。因为equals() 代价比调用 "==" 高.
 *  驻留池的主要作用就是: 已驻留的字符串彼此之间可以通过"=="做比较操作,比equals()更廉价速度更快. 
 *  2009-5-1
 */
public class TestIntern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = new String("姜志强");
		//String str = "姜志强";
		//没有做驻留处理
		if(str == "姜志强"){
			System.out.println("相同");
		}else{
			System.out.println("不同");
		}
		
		//做了驻留处理， 将字符串添加到驻留池中
		str = str.intern();
		if(str == "姜志强"){
			System.out.println("相同");
		}else{
			System.out.println("不同");
		}
	}

}
