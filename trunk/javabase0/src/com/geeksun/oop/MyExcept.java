package com.geeksun.oop;

/**
 * @author Administrator
 * @see 自定义异常类应当继承Exception类
 */
class MyException extends Exception{
	private static final long serialVersionUID = 1L;
	MyException(String ErrorMessage){
		super(ErrorMessage);
	}
}
public class MyExcept {
	static int avg(int a,int b) throws MyException{
		if(a<0||b<0){
			throw new MyException("负值不可");
		}
		else if(a>100||b>100){
			throw new MyException("数值过大");
		}
		return (a+b)/2;
	}
	public static void main(String args[]){
		try {
			System.out.println(avg(-22,33));
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
