package com.lifeopera.optimize;

/**
 * @author ��־ǿ
 *  final ���÷�������������final������������ϵͳ����, �ӿ촦���ٶȣ����У�
 *  2009-5-1
 */
public final class FinalDemo {		//��������Ϊfinal, Ҳ��������������, �ӿ�Ӧ���ٶ�, ���ϵͳ����.
	//��ĳ���
	public static final String USER_NAME = "root";
	
	/**
	 *  �����ĳ���������Ϊ��ֹ�������������е������ġ�
	 *  �Ա����𱣻����ã���ֹ���������⸳ֵ��
	 */
	public void showMessage(final String userName){
		//userName = "test";  can not operate
		System.out.println("userName: " + userName);
	}
	
	/**
	 *  ���ɱ����ǣ�override���ķ���, ���һ����Լӿ�Ӧ�õ������ٶȡ����ϵͳ���ܡ������� c++ �������������
	 *  �����������ǵ���������ʱ�Ϳ���ȷ���ú����Ĵ��룬���ҿ��Խ������Ĵ���չ�����뵽�����ߴ��봦��
	 */
	public final void showPrivacyMessage(){
		System.out.println("showPrivacyMessage: Toms address is ...");
	}
	
	/**
	 *  final ��������Ч����������������(inline), ����������ʱ�Ϳ���ȷ���ú����Ĵ��룬
	 *  ���ҿ��Խ������Ĵ���չ�����뵽�����ߴ��봦, ��������Ӧ�õ������ٶ�, �����ϵͳЧ�ʡ�
	 */
	public final static int inline(int a, int b){
		return (a > b ? a: b);
	}
	
	/**
	 *  �������ֵ
	 */
	public static int max(int a, int b){
		return (a > b ? a : b);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int N = 10000000;
		int a = 5;
		int b = 17;
		int c;
		
		
		//ʹ���� max ������ͬ����������
		long start = System.currentTimeMillis();
		for(int i=1;i<N;i++){
			c = (a > b ? a : b);
		}
		long end = System.currentTimeMillis();
		// run result: 32��31 
		System.err.print("\nʹ���������룺" + (end - start));
		
		//������ͨ������ ����������ʱ����
		long startTime = System.currentTimeMillis();
		for(int i=1;i<N;i++){
			c = max(a, b);
		}
		long endTime = System.currentTimeMillis();
		// run result: 32��31 or 47
		System.err.print("\n������ͨ����: " + (endTime-startTime));
		
		//ʹ���� inline ����
		long begin = System.currentTimeMillis();
		for(int i=1;i<N;i++){
			c = inline(a, b);
		}
		long last = System.currentTimeMillis();
		//32��31
		System.err.print("\nʹ������������" + (last - begin));
	}

}
