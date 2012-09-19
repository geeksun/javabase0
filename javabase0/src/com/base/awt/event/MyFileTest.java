package com.base.awt.event;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ��־ǿ
 * @annotation: Ϊ�ļ��Ĵ��뱣���ṩ�˼���ķ��㣬������ӵ���ļ��Ի����Ա��
 * @create at 2009-4-6
 */
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

public class MyFileTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("MyFile Test");
		TextArea ta = new TextArea();
		f.add(ta);
		f.setSize(300, 300);
		f.setVisible(true);
		MyFile file = new MyFile(f);		//����ָ��f Ϊ�������ߵ� MyFile �����
		
		try{
			ta.setText(file.getData());		//���ļ��ж�ȡ���� ta,����ʾ�� ta ��
			file.setData(ta.getText());		//�� ta �е����ݴ洢���ļ���
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
