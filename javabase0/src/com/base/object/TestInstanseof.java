package com.base.object;

/**
 * @author 姜志强
 * @comment: a instanceof b :  判断 a 对象的类型,是否为 b 类的对象
 * @create at 2009-4-24
 */
public class TestInstanseof {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[] obj = new Object[6];
		obj[0] = 8;
		obj[1] = "Abc";
		obj[2] = 'k';
		obj[3] = 82828;
		obj[4] = 8383920;
		obj[5] = false;
		if(obj[0] instanceof Integer){
			System.err.println("Integer");
		}
		if(obj[1] instanceof String){
			System.err.println("instanceof");
		}
	}

}
