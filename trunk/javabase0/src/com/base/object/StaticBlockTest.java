package com.base.object;

/**
 * @author 姜志强
 *  static block 在类中仅初始化一次, 并且在类生成前执行
 *  声明为static的变量实质上就是全局变量。当声明一个对象时，并不产生static变量的拷贝，而是该类所有的实例变量共用同一个static变量。
 *  2009-6-13  
 */
public class StaticBlockTest {
private static StaticBlockTest instance;
	
	private StaticBlockTest(){}
	
	/**
	 *	static块程序是在类被装载(使用)的时候开始执行, 而不是在创建对象的时候执行
	 */
	static {
		System.err.print("static block loading\n");
		/* reflect appcation: 反射效率比较低
		 * String className = "modifier.Session";
		try {
			instance = (Session) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
	}

	public static StaticBlockTest getInstance() {
		if(instance==null)
			return new StaticBlockTest();
		return instance;
	}

	public void show(String name) {
		System.err.println(name);
	}
	
	public static void main(String[] args) {
		StaticBlockTest session = StaticBlockTest.getInstance();
		session.show("name");
		StaticBlockTest session2 = StaticBlockTest.getInstance();
		session2.show("name2");
	}

}
