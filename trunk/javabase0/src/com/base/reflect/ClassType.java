package com.base.reflect;

/**
 * @author 姜志强
 *  类型测试
 *  2009-4-25
 */
public class ClassType {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class<?> c = String.class;
		try{
			Object o = c.newInstance();
			if(o instanceof String){
				System.out.print("True");
			}else{
				System.out.print("False");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
