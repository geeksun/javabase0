package com.base.pattern.adapter;

/**
 * @author ��־ǿ
 *  ����������(��̳�������ģʽ): ������(Adapter)����һ����Ľӿ�ת���ɵ��÷�ϣ��������һ���ӿڣ��Ӷ�����������нӿ�֮�䲻���ݵ����⡣
 *  ʹ��ԭ�����ڽӿڲ����ݶ�����һ��������Щ�����һ������
 *  2009-5-18
 */
public class AdapterTest {

	public static void main(String[] args) {
		Adapter adapter = new Adapter();
		//����Ŀ��ӿ��еķ���
		adapter.targetMethod();
		
		//���ñ����������еķ���
		adapter.adapteeMethod();
		
	}

}
