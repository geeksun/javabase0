package com.base.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.TextArea;

public class Applet2 extends Applet {
	//��ʾ��������ʱ���������Ķ����ı���
	TextArea ta = new TextArea();
	
	//��¼�������õĴ���
	static int objectCount, initCount, startCount, stopCount, destoryCount;
	
	static String info = "";		//��ʾ��������˳����������ַ�������
	
	public Applet2(){
		setLayout(new BorderLayout());	//�趨 Applet ����
		add(ta);		//��Ӷ����ı���
		objectCount++;	//��¼ init()�������ô���
		info += "���󴴽�����: " + objectCount + "\n";
		ta.setText(info);
	}
	
	public void start(){	//���� Applet
		startCount++;
		info += "start()���ô�����" + startCount + "\n";
		ta.setText(info);
		
	}
	
	public void stop(){		//��ͣ Applet
		stopCount++;
		info += "stop()���ô�����" + stopCount + "\n";
		ta.setText(info);
		
	}
	
	public void destory(){		//��ͣ Applet
		destoryCount++; 
		info += "destory()���ô�����" + destoryCount + "\n";
		ta.setText(info);
		
	}
	
}
