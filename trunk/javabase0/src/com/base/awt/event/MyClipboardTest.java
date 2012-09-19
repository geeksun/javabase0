package com.base.awt.event;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * @author 姜志强
 * @annotation: 提供了记事本的剪切，复制，粘贴功能。
 * @create at 2009-4-6
 */
class MyClipboard{
	private Clipboard cb;	//剪切板
	
	public MyClipboard(){	//构造函数，获取系统剪切板
		cb = Toolkit.getDefaultToolkit().getSystemClipboard();
	}
	
	public void setData(String data){	//将字符串存入剪贴板
		cb.setContents(new StringSelection(data), null);
	}
	
	public String getData(){	//从剪贴板读取数据，并将其返回
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
		System.err.println("将字符串存入剪贴板");
		mc.setData(str);
		System.err.println("从剪贴板读取字符串");
		System.err.println("内容："+mc.getData());
		
	}

}
