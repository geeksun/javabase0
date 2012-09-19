package com.base.awt;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ��־ǿ
 * @annotation: ���±����μ�com.geeksun.awt.event.MyMemo.java.
 * @create at 2009-4-8
 */
public class Notepad extends Frame implements ActionListener {
	
	private TextArea editor = new TextArea();		//�ɱ༭�� TextArea
	private MyFile mf = new MyFile(this);			//MyFile ����
	private MyClipboard cb = new MyClipboard();		//MyClipboard ����
	private MyFindDialog findDlg = new MyFindDialog(this, editor);		//���ҶԻ���
	
	public Notepad(String title){
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
				Notepad.this.dispose();
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
		Notepad pad = new Notepad("�ҵļ��±�");
		pad.setSize(200, 200);
		pad.setVisible(true);
	}

}

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

class MyClipboard{ 
	private Clipboard cb;	//���а�
	
	public MyClipboard(){	//���캯������ȡϵͳ���а�
		cb = Toolkit.getDefaultToolkit().getSystemClipboard();
	}
	
	public void setData(String data){	//���ַ������������
		cb.setContents(new StringSelection(data), null);
	}
	
	public String getData(){	//�Ӽ������ȡ���ݣ������䷵��
		Transferable content = cb.getContents(null);
		
		try{
			return (String)content.getTransferData(DataFlavor.stringFlavor);
		}catch(Exception e){
			return null;
		}
	}
}

class MyFile{
	private FileDialog fDlg;	//�ļ��Ի���
	
	public MyFile(Frame parent){
		fDlg = new FileDialog(parent, "", FileDialog.LOAD);		//��ʼ���ļ��Ի���
	}
	
	private String getPath(){
		return fDlg.getDirectory() + "\\" + fDlg.getFile();		//����ѡ���ļ���·��
	}
	
	public String getData() throws IOException{
		fDlg.setTitle("��");		//�趨�ļ��Ի���ı���Ϊ���򿪡�
		fDlg.setMode(FileDialog.LOAD);	//���ļ��Ի����ģʽ�趨Ϊ��ģʽ
		fDlg.setVisible(true);		//��ʾ�ļ��Ի���
		
		//��ȡ�ļ��Ի���ѡ���ļ������ݲ����䷵��
		BufferedReader br = new BufferedReader(new FileReader(getPath()));
		StringBuffer sb = new StringBuffer();
		String aline;
		while((aline = br.readLine()) != null){
			sb.append(aline + '\n');
		}
		br.close();
		return sb.toString();
	}
	
	public void setData(String data) throws IOException{
		//��ʾ����ģʽ�Ի��򣬲������� data ����ѡ�е��ļ���
		fDlg.setTitle("����");
		fDlg.setMode(FileDialog.SAVE);	
		fDlg.setVisible(true);
		BufferedWriter bw = new BufferedWriter(new FileWriter(getPath()));
		bw.write(data);
		bw.close();
	}
}

class MyMenuBar extends MenuBar{
	private static final long serialVersionUID = -6509201141315415912L;
	
	public MyMenuBar(Frame parent){
		parent.setMenuBar(this);			//��parent�������
	}
	
	public void addMenus(String[] menus){
		for(int i=0;i<menus.length;i++){	//ѭ��0 �� menus.length-1��
			add(new Menu(menus[i]));		//�����menus[i]Ϊ����Ĳ˵�
		}
	}
	
	public void addMenuItems(int menuNumber, String[] items){
		for(int i=0;i<items.length;i++){
			//���ַ�Ϊnull�������Separator,������Ӳ˵���
			if(items[i] != null)
				getMenu(menuNumber).add(new MenuItem(items[i]));
			else
				getMenu(menuNumber).addSeparator();
		}
	}
	
	public void addActionListener(ActionListener al){
		//ѭ���õ��˵��ĸ���
		for(int i=0;i<getMenuCount();i++){
			//ѭ������i�˵��ĸ���
			for(int j=0;j<getMenu(i).getItemCount();j++){
				//���i�˵��ĵ�j����Ŀע�ᶯ���¼�������
				getMenu(i).getItem(j).addActionListener(al);
			}
		}
	}
}