package com.base.test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jzq
 * read是一个很好的读取器，对流，如应用于下载中是一个不错的算法!
 * 2009-5-7
 */
public abstract class ReadTest { 

	public static final int INITIAL_SIZE = 100000;
    private byte buffer[] = new byte[INITIAL_SIZE];
    private int index = 0;
	private int l; 
	
	public abstract int read() throws IOException;
	
   private int capacity() {
        return (buffer.length - index);
    }

   public void read(InputStream in, int max) throws IOException {
        long k= 0;

        do {
            int size;

            // only read up to the max size, if the max size was
            // specified
            if (max != -1) {
                size = Math.min(capacity(), max);
            } else {
                size = capacity();
            }

            // actually read the block
            k= in.read(buffer, index, capacity());

            // quit if we hit EOF
            if (k< 0) {
                break;
            }

            // adjust capacity if needed
            index += k;

            if (capacity() < 10) {
                expand();
            }

            // see if we hit the max length
            if (max != -1) {
                max -= l;
                if (max <= 0) {
                    break;
                }
            }
        } while (k!= 0);
    }
	
	private void expand() {
		
	}

	/**
	 * InputStream 中方法方法方法
	 */
	public int read(byte b[], int off, int len) throws IOException {
		if (b == null) {
		    throw new NullPointerException();
		} else if ((off < 0) || (off > b.length) || (len < 0) ||
			   ((off + len) > b.length) || ((off + len) < 0)) {
		    throw new IndexOutOfBoundsException();
		} else if (len == 0) {
		    return 0;
		}

		int c = read();
		if (c == -1) {
		    return -1;
		}
		b[off] = (byte)c;

		int i = 1;
		try {
		    for (; i < len ; i++) {
			c = read();
			if (c == -1) {
			    break;
			}
			if (b != null) {
			    b[off + i] = (byte)c;
			}
		    }
		} catch (IOException ee) {
		}
		return i;
	    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] b = new byte[1024*2];
		int off = 0;
		int len = 2000;
		
		
	}

}
