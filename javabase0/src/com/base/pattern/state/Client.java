package com.base.pattern.state;

/**
 * Description ״̬ģʽ�ͻ��˲���
 * @author Administrator
 * 2012-9-20
 */
public class Client {

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// ����״̬
		State state = new StateA();
		// ��������
		Context context = new Context();
		// ��״̬�赽������
		context.set_instance(state);
		// ����
		context.request();
	}

}
