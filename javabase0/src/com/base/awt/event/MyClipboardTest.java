package com.base.awt.event;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * @author ��־ǿ
 * @annotation: �ṩ�˼��±��ļ��У����ƣ�ճ�����ܡ�
 * @create at 2009-4-6
 */
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

public class MyClipboardTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClipboard mc = new MyClipboard();
		String str = new String("ABC");
		System.err.println("���ַ������������");
		mc.setData(str);
		System.err.println("�Ӽ������ȡ�ַ���");
		System.err.println("���ݣ�"+mc.getData());
		
	}

}
