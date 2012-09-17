package com.base.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author ��־ǿ
 *  java.nio: ��һ��С�͵��ļ����뵽 byte �������У���ʾ�����������ݣ���������ת�����ַ���������Ȼ����ʾ�ַ�������������
 *  (������ʾΪ byte ���ַ�)�� 
 *  ���������Կ�ö���ٶȲ��ݴ���������
 *  2009-4-27
 */
public class ChangeBuffer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//read byte data into a byte buffer
			String data = "friends.dat";
			FileInputStream inData = new FileInputStream(data);
			//ͨ�������������������������Ķ��� �ļ�ͨ��������д���޸��ļ��е�����
			FileChannel inChannel = inData.getChannel();
			long inSize = inChannel.size();
			//������������ ����һ�ַ�ʽ����:wrap()
			ByteBuffer source = ByteBuffer.allocate((int)inSize);
			//��ͨ���е��ֽڶ��뵽byteBuffer��
			inChannel.read(source, 0);
			//�������Ŀ�ͷ
			source.position(0);
			System.out.print("Original byte ata��\n");
			//��ʾǰ�洴���Ļ���������������
			for(int i=0;source.remaining()>0;i++){
				System.out.print(source.get() + " ");
			}
			
			//convert byte data into character data
			source.position(0);
			//�����ַ���
			Charset ascii = Charset.forName("US-ASCII");
			//��byte ת��Ϊ�ַ���������
			CharsetDecoder toAscii = ascii.newDecoder();
			CharBuffer destination = toAscii.decode(source);
			destination.position(0);
			System.out.print("\nNew character data��\n");
			for(int i=0;destination.remaining()>0;i++){
				System.out.print(destination.get());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
