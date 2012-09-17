package com.geeksun.awt.event;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author ��־ǿ
 * @annotation: �ṩ���� TextArea ���ض��ַ����Ĺ���;Ҳ���Բ��Ҳ��滻�ַ�����
 * @create at 2009-4-6
 */
class MyFindDialog extends Dialog implements ActionListener{
	
	//�����Ի�����ʹ�õ����
	private Label lFind = new Label("�����ַ���");
	private Label lReplace = new Label("�滻�ַ���");
	private TextField tFind = new TextField(10);	//���մ����ַ�����TextField
	private TextField tReplace = new TextField(10);	//����Ҫ�滻�ַ����� TextField
	private Button bFind = new Button("����");
	private Button bReplace = new Button("�滻");	//�滻��ť
	
	private TextArea ta;					//ta Ϊ���д����ַ����� TextField
	
	public MyFindDialog(Frame owner, TextArea ta){
		super(owner,"����",false);		//��ģʽ�Ի���
		this.ta = ta;
		setLayout(null);
		
		//�趨�����λ�ô�С
		lFind.setBounds(10, 30, 80, 20);
		lReplace.setBounds(10, 70, 80, 20);
		tFind.setBounds(90, 30, 90, 20);
		tReplace.setBounds(90, 70, 90, 20);
		bFind.setBounds(190, 30, 80, 20);
		bReplace.setBounds(190, 70, 80, 20);
		
		//������
		add(lFind);	add(tFind);	add(bFind);	add(lReplace);
		add(tReplace);	add(bReplace);
		
		//��ֹ�û������Ի���Ĵ�С
		setResizable(false);
		
		//Ϊ������ťע�ᶯ���¼�������
		bFind.addActionListener(this);
		bReplace.addActionListener(this);
		
		//Ϊ�Ի���ע��رմ����¼�������
		addWindowListener(new WindowAdapter(){
			//ʹ���ڲ���
			public void WindowClosing(WindowEvent e){
				MyFindDialog.this.dispose();
			}
		});
	}
	
	public void showFind(){
		setTitle("����");		//���Ի��������Ϊ�����ҡ�
		setSize(280, 60);		//���Ի����С�趨Ϊ���ʴ�С
		setVisible(true);
	}
		
	public void showReplace(){
		setTitle("�����滻");
		setSize(280, 110);
		setVisible(true);
	}
	
	/**
	 *  ����
	 */
	private void find(){
		String text = ta.getText();		//��ta �л�ȡ�ַ����������� text ��
		String str = tFind.getText();	//��ȡ tFind �ַ����������� str ��
		int end = text.length();	//��ȡta �ַ����ĳ���
		int len = str.length();		//��ȡ tFind �ַ����ĳ���
		int start = ta.getSelectionEnd();	//�ӹ��λ�ÿ�ʼ�����ַ���
		if(start == end)	start = 0;		//�����λ��ĩβ�����ͷ��ʼ����
		//System.err.println("search value:"+text);
		for(;start<=end-len;start++){
			if(text.substring(start, start + len).equals(str)){		//���ҵ������ַ���
				ta.setSelectionStart(start);		//ѡ�в���ʾ�ַ���
				ta.setSelectionEnd(start + len);
				//System.err.println("start value:"+start);
				return;			//�˳�����
			}
		}
		//System.err.println("no search value");
		//���Ҳ��������ַ������򽫹������ĩβ
		ta.setSelectionStart(end);
		ta.setSelectionEnd(end);
	}
	
	/**
	 *  �滻
	 */
	private void replace(){
		String str = tReplace.getText();		//��ȡ�����ַ���
		
		//��ѡ�е��ַ���������ַ���һ�£������滻Ϊ�滻�ַ���
		//��ѡ�е��ַ���������ַ�����һ�£� ���������
		if(ta.getSelectedText().equals(tFind.getText()))
			ta.replaceRange(str, ta.getSelectionStart(), ta.getSelectionEnd());
		else
			find();
			
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bFind){			//���²��Ұ�ť������find()����
			//System.err.println("search");
			find();
		}
		else if(e.getSource() == bReplace)	//�����滻��ť������ replace() ����
			replace();
	}
}

public class MyFindDialogTest {
	public static void main(String[] args) {
		Frame f = new Frame("MyFindDialog Test");
		TextArea ta = new TextArea();
		
		f.add(ta);
		MyFindDialog fDlg = new MyFindDialog(f, ta);	//���ң��滻�Ի���
		f.setSize(300, 300);
		f.setVisible(true);
		fDlg.showReplace();								//��ʾ�����滻�Ի���
	}

}
