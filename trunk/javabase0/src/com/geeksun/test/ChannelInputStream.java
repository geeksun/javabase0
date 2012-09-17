package com.geeksun.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/**
 * @author jzq
 *  管道输入流
 *  非阻塞式	IO
 *  2009-5-7
 */
public class ChannelInputStream {
	private ReadableByteChannel channel;

	   public ChannelInputStream(ReadableByteChannel channel) throws IllegalArgumentException {
	     if (channel == null) {
	       throw new IllegalArgumentException("The readable byte channel is null");
	     }

	     this.channel = channel;
	   }

	   public int read() throws IOException {
	     ByteBuffer buffer = ByteBuffer.allocate(1);
	     int result = channel.read(buffer);
	     if (result != -1) {
	       buffer.flip();
	       result = (int) buffer.get();
	       buffer.clear();
	     }
	     return result;
	   }

	   public int read(byte b[]) throws IOException {
	     ByteBuffer buffer = ByteBuffer.allocate(b.length);
	     int result = channel.read(buffer);
	     if (result != -1) {
	       buffer.flip();
	       buffer.get(b, 0, result);
	       buffer.clear();
	     }
	     return result;
	   }

	   public int read(byte b[], int off, int len) throws IOException {
	     ByteBuffer buffer = ByteBuffer.allocate(b.length);
	     int result = channel.read(buffer);
	     if (result != -1) {
	       buffer.flip();
	       buffer.get(b, off, len<result ? result : len);
	       buffer.clear();
	     }
	     return result;
	   }

	   public void close() throws IOException {
	     channel.close();
	   }
}
