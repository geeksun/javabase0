package com.geeksun.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementTest {
	/**
	 *  @version 采用 JDBC的 PreparedStatement 操作数据库 -- 向数据库里增加一条新闻，新闻有新闻Id,新闻标题，新闻内容三个属性。
	 */
	public void saveNews(News news){ 
		Connection con = null;
		PreparedStatement pst = null;
		int newsId = news.getNewsId();
		String title = news.getTitle();
		String content = news.getContent();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/temp?useUnicode=true&amp;characterEncoding=gbk";
			con = DriverManager.getConnection(url,"root","");
			// 创建预编译的的 Statement
			pst = con.prepareStatement("insert into news_table values(?,?,?)");
			// 下面语句为预编译 Statement 传入参数
			pst.setInt(1,newsId);  
			pst.setString(2,title);
			pst.setString(3,content);
			// 执行更新
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				// 关闭预编译的 Statement
				if(pst!=null)
					pst.close();
				// 关闭连接
				if(con!=null)
					con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	 }
}
class News
{
	private int newsId;
	private String title;
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
