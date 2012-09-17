package com.geeksun.io;

public class WebPath {

	
	/**
	 *  get true path
	 */
	public static void realPath(){
		/*request.getRealPath("")
		就是取得你当前运行文件在服务器上的绝对路径.
		request.getRealPath("/")
		取得当前站点的根目录.*/
		//D:\newWork\ms  当前应用的根目录, 只能用在 JAVA 文件里, 绝对路径
		System.out.println(System.getProperties().getProperty("user.dir"));
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		realPath();
		
		
		
		
	}

}
