package com.geeksun.awt.event;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author ��־ǿ
 * @annotation: ���±�
 * @create at 2009-4-6
 */
public class MyMemo extends Frame implements ActionListener {
	
	private TextArea editor = new TextArea();		//�ɱ༭�� TextArea
	private MyFile mf = new MyFile(this);			//MyFile ����
	private MyClipboard cb = new MyClipboard();		//MyClipboard ����
	private MyFindDialog findDlg = new MyFindDialog(this, editor);		//���ҶԻ���
	
	public MyMemo(String title){
		super(title);
		MyMenuBar mb = new MyMenuBar(this);			//���MyMenuBar����
		
		//�����Ҫ�Ĳ˵����˵���
		mb.addMenus(new String[]{"�ļ�","�༭","����","����"});
		mb.addMenuItems(0, new String[]{"�½�","��","����",null,"�˳�"});
		mb.addMenuItems(1, new String[]{"����","����","ճ��","���",null,"ȫѡ"});
		mb.addMenuItems(2, new String[]{"����",null,"�����滻"});
		mb.addMenuItems(3, new String[]{"�ҵļ��±���Ϣ"});
		
		add(editor);
		mb.addActionListener(this);		//Ϊ�˵���ע�ᶯ���¼�������
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				MyMemo.this.dispose();
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		String selected = e.getActionCommand();		//��ȡ�˵������
		
		if(selected.equals("�½�")){		//��ѡ�С��½����˵���
			editor.setText("");			//��� editor ������
			
		}else if(selected.equals("��")){
			try{
				editor.setText(mf.getData());	//��ȡ�ļ��Ի����б�ѡ�е��ļ�
			}catch(Exception ie){
				ie.printStackTrace();
			}
		}else if(selected.equals("����")){
			try{
				mf.setData(editor.getText());	//�������ļ��Ի����б�ѡ�е��ļ�
			}catch(Exception iie){
				iie.printStackTrace();
			}
		}else if(selected.equals("�˳�")){
			dispose();			
		}else if(selected.equals("����")){
			//��ѡ�е��ַ������Ƶ��������в�����ַ���
			cb.setData(editor.getSelectedText());
			
			editor.replaceRange("", editor.getSelectionStart(), editor.getSelectionEnd());
		}
		else if(selected.equals("����")){
			//��ѡ�е��ַ������Ƶ���������
			cb.setData(editor.getSelectedText());
		}else if(selected.equals("ճ��")){
			//�Ӽ������ȡ�ַ�������ճ�������λ��
			String str = cb.getData();
			
			editor.replaceRange(str, editor.getSelectionStart(), editor.getSelectionEnd());
		}
		else if(selected.equals("���")){
			//�����ѡ�е��ַ���
			editor.replaceRange("", editor.getSelectionStart(), editor.getSelectionEnd());
		}
		else if(selected.equals("ȫѡ")){
			//ѡ����ѡ����
			editor.setSelectionStart(0);
			editor.setSelectionEnd(editor.getText().length());
		}
		else if(selected.equals("����")){
			findDlg.showFind();			//��ʾ���ҶԻ���
		}
		else if(selected.equals("�����滻")){
			findDlg.showReplace();		//��ʾ�����滻�Ի���
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyMemo mm = new MyMemo("�ҵļ��±�");
		mm.setSize(200, 200);
		mm.setVisible(true);
		
	}

}
