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
 * @author ��־ǿ
 *  http://workbench.cadenhead.org/book/java21pro/source/chapter17/LoadURL.java
 *  ʹ�÷�����׽���ͨ������һ��URL, ����һ�������в������磺http://www.google.cn/intl/zh-CN/ads/ads_1.html
 *  2009-4-27
 */
public class LoadURL {
	
	public LoadURL(String urlRequest) {
		//�׽���ͨ�����ɽ������������
        SocketChannel sock = null;
        try {
            URL url = new URL(urlRequest);
            String host = url.getHost();
            String page = url.getPath();
            //Ҫ���ӵ���Internet ��ַ
            InetSocketAddress address = new InetSocketAddress(host, 80);
            Charset iso = Charset.forName("ISO-8859-1");
            //������
            CharsetDecoder decoder = iso.newDecoder();
            //������
            CharsetEncoder encoder = iso.newEncoder();

            ByteBuffer byteData = ByteBuffer.allocate(16384);
            CharBuffer charData = CharBuffer.allocate(16384);

            //�����׽���ͨ��
            sock = SocketChannel.open();
            //����Ϊ�����ͨ��
            sock.configureBlocking(false);
            //���ӵ��׽���
            sock.connect(address);

            //����ͨ���������¼���ͨ���������󣬸����׽���ͨ���������¼�
            Selector listen = Selector.open();
            //ע�����
            sock.register(listen, SelectionKey.OP_CONNECT +
                SelectionKey.OP_READ);

            //��Ϸ������ȴ�ͨ������ĳ���¼����ȥĳ��ָ����ʱ�䣨500ms��
            while (listen.select(500) > 0) {
            	//�˽��¼���ϸ��
                Set keys = listen.selectedKeys();
                Iterator i = keys.iterator();
                while (i.hasNext()) {
                	//ͨ�����ڷ������¼�
                    SelectionKey key = (SelectionKey) i.next();
                    i.remove();
                    SocketChannel keySock = (SocketChannel) key.channel();
                    
                    //�����¼�
                    if (key.isConnectable()) {
                        if (keySock.isConnectionPending()) {
                        	//�����������
                            keySock.finishConnect();
                        }
                        CharBuffer httpReq = CharBuffer.wrap(
                            "GET " + page + "\n\r\n\r");
                        ByteBuffer request = encoder.encode(httpReq);	//ת����byte������
                        keySock.write(request);		//ͨ���׽���ͨ���������ͳ�ȥ
                    } else if (key.isReadable()) {		//��ȡ�¼�
                    	//���뵽������
                        keySock.read(byteData);
                        byteData.flip();
                        charData = decoder.decode(byteData);
                        charData.position(0);
                        System.out.print(charData);

                        //��ջ��������Ա���׽��ֶ�ȡ��������ʱ�ܹ�����
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
