package com.base.socket;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.geeksun.awt.event.CloseFrameDialog;

/**
 * @author ��־ǿ
 * @annotation: ���� URL ����ȡURL�е����ݣ�URL����protocal,port,host,file name��
 * @create at 2009-4-20
 */
public class PageViewer extends Frame {
	
	private TextField tURL = new TextField("");		//������ URL ���ı������ı���
	
	//��ʾ Web ��ҳԴ����Ķ����ı���
	private TextArea tPage = new TextArea();
	
	private BufferedReader reader;		//������
	
	public PageViewer(String title){
		super(title);
		tPage.setEditable(false);
		add(tURL, "North");
		add(tPage, "Center");
		
		//ע�ᶯ���¼�������
		tURL.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					//��ȡ web ��ҳ
					readPage(new URL(tURL.getText()));
				}catch(Exception e){
					tPage.setText("URL����");
				}
			}
		});
		
		//ʹ���������������¼��������� WindowListener ����
		WindowListener winHandler = new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			//thisָWindowEvent3�Ķ��󣬼���ܶ���
			CloseFrameDialog d = new CloseFrameDialog(PageViewer.this, "�ر�", "ȷʵҪ�ر���");
			
			d.setSize(200, 100);
			d.setVisible(true);
			}
		};

		addWindowListener(winHandler);		//ע���¼�������
	}
	
	/**
	 * @param url
	 * ��ȡ url ���������õ� web ��ҳ����
	 */
	void readPage(URL url){
		tPage.setText("");
		String line;
		try{
			//��ȡ url ������
			reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			
			//��ȡһ�У�������� tPage ��
			while((line=reader.readLine())!=null){
				tPage.append(line + "\n");
			}
		
		}catch(Exception e){
			tPage.setText("������������쳣");
			e.printStackTrace();
		}finally{
			try{
				if(reader!=null)
					reader.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PageViewer me = new PageViewer("Page Viewer");
		me.setSize(400, 400);
		me.setVisible(true);
		
	}

}
