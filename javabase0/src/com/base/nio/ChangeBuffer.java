package com.base.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author 姜志强
 *  java.nio: 将一个小型的文件读入到 byte 缓冲区中，显示缓冲区的内容，将缓冲区转换成字符缓冲区，然后显示字符缓冲区的内容
 *  (将其显示为 byte 和字符)。 
 *  缓冲区能以快得多的速度操纵大量的数据
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
			//通道：将缓冲区和流连接起来的对象， 文件通道用来读写和修改文件中的数据
			FileChannel inChannel = inData.getChannel();
			long inSize = inChannel.size();
			//创建缓冲区， 还有一种方式，是:wrap()
			ByteBuffer source = ByteBuffer.allocate((int)inSize);
			//把通道中的字节读入到byteBuffer中
			inChannel.read(source, 0);
			//缓冲区的开头
			source.position(0);
			System.out.print("Original byte ata：\n");
			//显示前面创建的缓冲区的所有内容
			for(int i=0;source.remaining()>0;i++){
				System.out.print(source.get() + " ");
			}
			
			//convert byte data into character data
			source.position(0);
			//创建字符集
			Charset ascii = Charset.forName("US-ASCII");
			//将byte 转化为字符：解码器
			CharsetDecoder toAscii = ascii.newDecoder();
			CharBuffer destination = toAscii.decode(source);
			destination.position(0);
			System.out.print("\nNew character data：\n");
			for(int i=0;destination.remaining()>0;i++){
				System.out.print(destination.get());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
