package com.lifeopera.optimize;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

/**
 * @author 姜志强
 *  对象池：缓存对象，可以提高应用的速度，减少内存需要。此例为 JDBC 连接池.
 *  提升系统性能，节约系统内存开销，通过对其所保存对象的共享和重用，缩减了应用线程反复重建、装载对象的过程所需要的时间，
 *  并且也有效避免了频繁垃圾回收带来的巨大系统开销。
 *  
 *  对象池就是以”空间换时间”的 一种常用缓存机制, 这里的”时间”特指创建时间,因此这也给出了对象池的适用范围:
 *  如果一种对象的创建过程非常耗时的话, 那么请使用对象池. 内部原理简单的说, 就是将创建的对象放到一个容器中, 
 *  用完之后不是销毁而是再放回该容器, 让其他的对象调用, 对象池中还涉及到一些高级的技术, 比如过期销毁, 被破坏时销毁, 
 *  对象数超过池大小销毁, 对象池中没有可用空闲对象时等待等等.
 *  2009-5-1
 */
public class JdbcPool extends ObjectPool{
	// 锁定，未锁定
	private Hashtable locked, unlocked;
	// 用于存放对象的池
	private List<Connection> pool;
	// 期满时间
	private long expirationTime;
	// 清除无效对象的线程
	ConnectionCleanUpThread cleaner;
	
	public JdbcPool(){
		unlocked = new Hashtable();
		//初始化对象池
		//pool = new Vector<Connection>(); 
		
		//清理无效连接对象的线程，在对象池的构造器中被初始化并启动
		cleaner = new ConnectionCleanUpThread(this, expirationTime);
		cleaner.start();
	}
	
	/* 
	 *  创建对象
	 */
	Connection create(){
		try {
			/*return (DriverManager.getConnection(String url, String usr, String pwd));*/
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/abbcc?useUnicode=true&amp;characterEncoding=gbk",
					"root",
					""
			);
			//将对象实例保存到哈希表对象或 Vector 中
			unlocked.put(conn, conn);
			//pool.add(conn);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* 
	 * 对象过期
	 */
	void expire(Object o){
		
	}
	
	/* 
	 * 对象有效性验证
	 */
	void validate(Object o){
		
	}
	
	/* 
	 * 获取对象
	 */
	synchronized Connection getObject(){
		try{
			return (Connection) super.getObject();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null; 
	}
	
	/* 
	 * 对象释放
	 */
	synchronized void freeObject(Object o){
		o = null;
	}
	
	/**
	 * @return 获取数据库连接
	 */
	public Connection getConnection(){
		try{
			return (Connection) super.getObject();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null; 
	}
	
	public static void main(String[] args) {
		JdbcPool pool = new JdbcPool();
		long currentTime = System.currentTimeMillis();
		Connection conn = pool.create();
		Enumeration emumeration = pool.unlocked.keys();
		while(emumeration.hasMoreElements()){
			Connection con = (Connection) emumeration.nextElement();
			System.out.println(con);
			System.out.println(pool.unlocked.get(con));
			System.out.println(currentTime-((Long)pool.unlocked.get(con)).longValue());
			/*if((currentTime-((Long) unlocked.get(con)).longValue())>expirationTime){
				unlocked.remove(conn);
				expire(conn);
				//释放对该对象的引用
				conn = null;
			}*/
		}
		
	}
	

	/**
	 * @author 姜志强
	 *  开一个线程用于清除连接池中的已损坏连接对象
	 */
	class ConnectionCleanUpThread extends Thread {
		private ObjectPool pool;
		private long sleepTime;
		
		ConnectionCleanUpThread(ObjectPool pool, long sleepTime){
			this.pool = pool;
			this.sleepTime = sleepTime;
		}
		
		public void run(){
			while(true){
				try{
					sleep(sleepTime);
				}catch(Exception e){
					e.printStackTrace();
				}
				pool.cleanUp();
			}
		}
		
		/**
		 *  
		 */
		synchronized void cleanUp(){
			Connection conn;
			long currentTime = System.currentTimeMillis();
			Enumeration emumeration = unlocked.keys();
			
			while(emumeration.hasMoreElements()){
				conn = (Connection) emumeration.nextElement();
				
				if((currentTime-((Long) unlocked.get(conn)).longValue())>expirationTime){
					unlocked.remove(conn);
					expire(conn);
					//释放对该对象的引用
					conn = null;
				}
			}
			//强制系统做垃圾回收
			System.gc();
		}
		
	}

}

