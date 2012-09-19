package com.base.awt.event;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ��־ǿ
 * @annotation: �رմ����¼��Ĵ���
 * @dispose() ���ڹرմ��ڣ������ͷŴ���ռ�õ���Դ��
 * @create at 2009-4-3
 */
public class CloseFrameDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 8379011275941699820L;
	
	Button yes = new Button("��");	//���ǡ���ť
	Button no = new Button("��");
	Frame owner;		//�����߶Ի���
	Label msgLabel;		//��ʾ��Ϣ�ı�ǩ
	
	/**
	 * @annotation: ���캯����owner�������ߣ�title���Ի�����⣬msg����Ϣ
	 */
	public CloseFrameDialog(Frame owner, String title, String msg) {
		//���ø��๹�캯����ָ�������߱�����ģʽ
		super(owner, title, true);
		
		this.owner = owner;		//������
		msgLabel = new Label(msg, Label.CENTER);	//ӵ��ָ����Ϣ�ı�ǩ
		
		//������壬��������ӡ��ǡ�������������ť
		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 2));
		p.add(yes);
		p.add(no);
		
		//��Ի�����ӱ�ǩ�����
		add(msgLabel, "Center");
		add(p, "South");
		
		//��ťע���¼�������
		yes.addActionListener(this);
		no.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		//��ȡ��ť�ϵ��ַ���
		String command = e.getActionCommand();
		
		if(command.equals("��")){	//��Ϊ���ǡ���ť
			owner.dispose();		//�ر������߶Ի����ڣ��Ի���Ҳ���رա�
		}else if(command.equals("��")){	//��Ϊ���񡱰�ť
			this.dispose();			//ֻ�жԻ��򱻹ر�
		}
	}

}
