package com.base.object;

/**
 * @author ��־ǿ
 *  static block �����н���ʼ��һ��, ������������ǰִ��
 *  ����Ϊstatic�ı���ʵ���Ͼ���ȫ�ֱ�����������һ������ʱ����������static�����Ŀ��������Ǹ������е�ʵ����������ͬһ��static������
 *  2009-6-13  
 */
public class StaticBlockTest {
private static StaticBlockTest instance;
	
	private StaticBlockTest(){}
	
	/**
	 *	static����������౻װ��(ʹ��)��ʱ��ʼִ��, �������ڴ��������ʱ��ִ��
	 */
	static {
		System.err.print("static block loading\n");
		/* reflect appcation: ����Ч�ʱȽϵ�
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
