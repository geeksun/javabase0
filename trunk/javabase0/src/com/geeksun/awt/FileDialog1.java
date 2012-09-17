package com.geeksun.awt;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ��־ǿ
 *  �ļ��Ի��򣺼̳���Dialog�࣬�ڴ򿪻򱣴��ļ�ʱʹ�á��Զ��趨Ϊģʽ�Ի��򣬷�Ϊ�򿪶Ի�������Ϊ�Ի���
 */
public class FileDialog1 extends Frame {	//�̳��� Frame ��
	FileDialog fopen;			//�ļ��Ի���
	TextArea ta;				//��ʾ�ļ����ݵ�TextArea
	
	public FileDialog1(String title){
		super(title);	//�趨���ڱ���
		ta = new TextArea();
		add(ta);
		setSize(300, 300);	//�趨��С
	}
	
	//��ʾ�ļ��Ի��򣬲���ȡѡ���ļ�������
	public String showLoad(){
		fopen = new FileDialog(this, "���ļ�", FileDialog.LOAD);	//��ģʽ
		fopen.setVisible(true);		//��ʾ�ļ��Ի���this���ڵȴ�״̬
		//�ر��ļ��Ի��򣬲ż���ִ��
		String fileName = fopen.getFile();	//fileName ����ѡ���ļ�������
		String fileDir = fopen.getDirectory();	//fileDir ����ѡ���ļ���Ŀ¼
		
		if(fileName==null){
			return null;
		}
		
		return fileDir+"\\"+fileName;	//��ȡ�ļ��ľ���Ŀ¼
		
	}
	
	//��ȡ�ļ����ݣ�����ʾ�� ta ��
	public void loadFile(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String aline;
		while((aline = br.readLine())!=null){
			ta.append(aline+'\n');
		}
		br.close();
	}
	
	/**
	 *   ��ʾ�����Ϊ���Ի���
	 */
	public void showSave(){		
		fopen = new FileDialog(this, "�����ļ�", FileDialog.SAVE);	//��ģʽΪ���Ϊ
		fopen.setVisible(true);
		//�ر��ļ��Ի��򣬲ż���ִ��
		String fileName = fopen.getFile();	//fileName ����ѡ���ļ�������
		String fileDir = fopen.getDirectory();	//fileDir ����ѡ���ļ���Ŀ¼
		
		if(fileName==null){
			return;
		}

	}
	
	/**
	 *  �ν⣿
	 */
	public void saveFile(){
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileDialog1 fd = new FileDialog1("�ļ�");
		String fileName;
		
		//���ļ��������ڣ���������Ӧ����ʾ��Ϣ
		if((fileName=fd.showLoad())==null)
			System.out.println("��δѡȡ�ļ�");
		else{
			//��ȡ�ļ�
			try{
				fd.loadFile(fileName);
			}catch(IOException e){
				System.err.println(e);
			}
		}
		fd.setVisible(true);		//��ʾ����
	}

}
