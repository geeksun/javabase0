package com.geeksun.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author ��־ǿ
 *  byte ������ Demo����һ�������һ����������ͨ��������ָ���ģ��磺 java BufferDemo 7 64 or 4 18
 *  2009-4-25
 */
public class BufferDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int start = 0;
		int finish = 255;
		if(args.length>1){
			start = Integer.parseInt(args[0]);
			finish = Integer.parseInt(args[1]);
		}else if(args.length>0){
			start = Integer.parseInt(args[0]);
		}
		ArgStream ar = new ArgStream(start, finish);
		System.err.print("\nwriting:");
		boolean success = ar.writeStream();
		System.out.print("\nreading:");
		boolean readSuccess = ar.readStream();
	}

}

/**
 * @author ��־ǿ
 *  ����������
 */
class ArgStream{
	int start = 0;
	int finish = 255;
	
	public ArgStream(int start2, int finish2) {
		start = start2;
		finish = finish2;
	}
	
	/**
	 * ���ֽ�д�������������
	 * @return
	 */
	boolean writeStream(){
		try{
			FileOutputStream file = new FileOutputStream("op.txt");
			BufferedOutputStream buf = new BufferedOutputStream(file);
			
			for(int out = start;out<=finish;out++){
				buf.write(out);
				System.out.print(" " + out);
			}
			//�رջ�����
			buf.close();
			return true;
			
		}catch(Exception e){
			System.out.print("\nException:" + e.getMessage());
			return false;
		}
	}
	
	/**
	 * ��ȡ�����������е��ֽ�
	 */
	boolean readStream(){
		try{
			FileInputStream file = new FileInputStream("op.txt");
			BufferedInputStream buf = new BufferedInputStream(file);
			
			int in = 0;
			do{
				in = buf.read();
				if(in!=-1){
					System.out.print(" " + in);
				}
			}while(in!=-1);
			//�رջ�����
			buf.close();
			return true;
			
		}catch(Exception e){
			System.out.print("\nException:" + e.getMessage());
			return false;
		}
	}
}