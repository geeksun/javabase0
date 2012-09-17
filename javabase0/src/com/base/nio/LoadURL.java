package com.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 姜志强
 *  http://workbench.cadenhead.org/book/java21pro/source/chapter17/LoadURL.java
 *  使用非阻断套接字通道加载一个URL, 接收一个命令行参数，如：http://www.google.cn/intl/zh-CN/ads/ads_1.html
 *  2009-4-27
 */
public class LoadURL {
	
	public LoadURL(String urlRequest) {
		//套接字通道，可建立非阻断连接
        SocketChannel sock = null;
        try {
            URL url = new URL(urlRequest);
            String host = url.getHost();
            String page = url.getPath();
            //要连接到的Internet 地址
            InetSocketAddress address = new InetSocketAddress(host, 80);
            Charset iso = Charset.forName("ISO-8859-1");
            //解码器
            CharsetDecoder decoder = iso.newDecoder();
            //编码器
            CharsetEncoder encoder = iso.newEncoder();

            ByteBuffer byteData = ByteBuffer.allocate(16384);
            CharBuffer charData = CharBuffer.allocate(16384);

            //创建套接字通道
            sock = SocketChannel.open();
            //设置为非阻断通道
            sock.configureBlocking(false);
            //连接到套接字
            sock.connect(address);

            //监视通道发生的事件，通道监听对象，跟踪套接字通道发生的事件
            Selector listen = Selector.open();
            //注册监听
            sock.register(listen, SelectionKey.OP_CONNECT +
                SelectionKey.OP_READ);

            //阻断方法，等待通道发生某种事件或过去某个指定的时间（500ms）
            while (listen.select(500) > 0) {
            	//了解事件的细节
                Set keys = listen.selectedKeys();
                Iterator i = keys.iterator();
                while (i.hasNext()) {
                	//通道正在发生的事件
                    SelectionKey key = (SelectionKey) i.next();
                    i.remove();
                    SocketChannel keySock = (SocketChannel) key.channel();
                    
                    //连接事件
                    if (key.isConnectable()) {
                        if (keySock.isConnectionPending()) {
                        	//尝试完成连接
                            keySock.finishConnect();
                        }
                        CharBuffer httpReq = CharBuffer.wrap(
                            "GET " + page + "\n\r\n\r");
                        ByteBuffer request = encoder.encode(httpReq);	//转换成byte缓冲区
                        keySock.write(request);		//通过套接字通道将请求发送出去
                    } else if (key.isReadable()) {		//读取事件
                    	//读入到缓冲区
                        keySock.read(byteData);
                        byteData.flip();
                        charData = decoder.decode(byteData);
                        charData.position(0);
                        System.out.print(charData);

                        //清空缓冲区，以便从套接字读取其他内容时能够重用
                        byteData.clear();
                        charData.clear();
                    }
                }
            }
            sock.close();
        } catch (MalformedURLException mue) {
            System.out.println(mue.getMessage());
        } catch (UnknownHostException uhe) {
            System.out.println(uhe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
       
    public static void main(String arguments[]) {
        LoadURL app = new LoadURL(arguments[0]);  
        
    }
}
