package com.geeksun.object;

import java.io.Serializable;

/**
 * @author ��־ǿ
 *  transient: ˲��ֵ������Զ�̷������ã�RMI��Ӧ��ʱ�����ζ����в���Ҫ���ݵ����ԣ��������Խ�Լ���ö˵��ڴ���Դ��
 *  ��Լ����Ҫ�����翪�����ӿ촫���ٶȣ����ϵͳ���ܡ�
 *  2009-5-1
 */
public class TransientTest implements Serializable{
	int size;
	String name;
	transient String description;		//��Զ�̷�������ʱ�����ᴫ�������
	
	
}
