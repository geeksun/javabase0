package com.geeksun.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementTest {
	/**
	 *  @version ���� JDBC�� PreparedStatement �������ݿ� -- �����ݿ�������һ�����ţ�����������Id,���ű��⣬���������������ԡ�
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
			// ����Ԥ����ĵ� Statement
			pst = con.prepareStatement("insert into news_table values(?,?,?)");
			// �������ΪԤ���� Statement �������
			pst.setInt(1,newsId);  
			pst.setString(2,title);
			pst.setString(3,content);
			// ִ�и���
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				// �ر�Ԥ����� Statement
				if(pst!=null)
					pst.close();
				// �ر�����
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
