package com.sun.poolman;

import java.sql.*;

import javax.sql.DataSource;
import com.codestudio.sql.PoolMan;

/**
 * @author ��־ǿ
 * poolman:һ����Դ�����ӳؽ������
 */
public class PoolmanTest {
	//  ˽�о�̬����
	private static Connection con; 
	private static Statement st; 
	public Connection getConnection() throws ClassNotFoundException, SQLException { 
		con = null; 
		// �ҵ��� poolman.xml �ж��������Դ,poolman.xml ��λ���� src ��,classpath ��
		DataSource ds = PoolMan.findDataSource("sipo");  
		con = ds.getConnection(); 		
		// TYPE_SCROLL_INSENSITIVE:˫�����,������ʱ����;CONCUR_UPDATABLE:���ý�����������ݿ��еı�
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); 
		return con;
	} 
	public Connection getConnectionBySingle() throws SQLException
	{
		con = DriverManager.getConnection("jdbc:poolman://SIPO");
		return con; 
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		PoolmanTest pool = new PoolmanTest();
		con = pool.getConnectionBySingle();  		
		String sql = "select * from test";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			System.out.println("id: "+rs.getInt(1)+"-- name: "+rs.getString(2));
			
		}
		
	}
}
