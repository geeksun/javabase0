package com.geeksun.io;

public class WebPath {

	
	/**
	 *  get true path
	 */
	public static void realPath(){
		/*request.getRealPath("")
		����ȡ���㵱ǰ�����ļ��ڷ������ϵľ���·��.
		request.getRealPath("/")
		ȡ�õ�ǰվ��ĸ�Ŀ¼.*/
		//D:\newWork\ms  ��ǰӦ�õĸ�Ŀ¼, ֻ������ JAVA �ļ���, ����·��
		System.out.println(System.getProperties().getProperty("user.dir"));
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		realPath();
		
		
		
		
	}

}
