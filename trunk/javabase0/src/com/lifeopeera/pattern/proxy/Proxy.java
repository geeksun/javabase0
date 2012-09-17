package com.lifeopeera.pattern.proxy;

/**
 * @author ��־ǿ
 *  �����ɫ��: ���ж���ʵĿ������ã��Ӷ��������κ�ʱ�������ʵĿ�������������ɫ�ṩһ������ʵĿ���ɫ��ͬ�Ľӿڣ��Ա������
 *  �κ�ʱ�򶼿��������ʵĿ�꣬��δ����ɫ�����Կ��ƶ���ʵĿ������ã���������Ҫ��ʱ�򴴽�����ɾ����ʵĿ�������󣬴����ɫͨ��
 *  �ڽ��ͻ��˵��ô��ݸ���ʵ��Ŀ��֮ǰ����֮��Ҫִ��ĳ�������������ǵ����ؽ����ô��ݸ���ʵ���󣬵������ǰ�õĴ�����������Ǳ���ģ�
 *  ��ĳЩ������ǲ���Ҫ�ġ�
 *  ��������ʵĿ���ࡣ
 *  2009-5-19
 */
public class Proxy implements AbstractTarget {
	//������ʵĿ�����
    RealTarget realTarget = new RealTarget();
    
    public Proxy(){}
    
	/**
	 *  ������Ϊ������������ͻ������󷽷���
	 */
	public void handleRequest() {
		//���ô���ǰ����Ϊ����
		handlePreRequest();
		//������ʵĿ�귽��
		realTarget.handleRequest();
		//���ô����ƺ󷽷�
		handlePostRequest();
	}

	/**
	 *  ���ô���ǰ����Ϊ����
	 */
	private void handlePostRequest() {
		
	}

	/**
	 *  ���ô����ƺ󷽷�
	 */
	private void handlePreRequest() {
		
	}

}
