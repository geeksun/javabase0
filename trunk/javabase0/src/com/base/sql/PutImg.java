package com.base.sql;
import java.io.*;
import java.sql.*;
public class PutImg {			 
/**
 *    java �����ݿ��ȡ������ͼƬ
 *    ��ζ�ȡ���ݿ�Ķ����Ƶ�ͼƬ��
 */
public void putimg() {
	  try {
	   Class.forName("org.gjt.mm.mysql.Driver").newInstance();
	   //String url = "jdbc:mysql://localhost/img?user=root&password=root&useUnicode=true&characterEncoding=gbk";
	   String url = "jdbc:mysql://localhost/img?user=root&password=&useUnicode=true&characterEncoding=gbk";
	   Connection conn = DriverManager.getConnection(url);
	   Statement stmt = conn.createStatement();
	   //stmt.execute("insert   into   imgt (id)   values   (5)");
	   stmt.close();
	   PreparedStatement pstmt = null;
	   String sql = "";
	   File file = new File("d:\\b1204.jpg");
	   InputStream photoStream = new FileInputStream(file);            //  ��ͼƬ�ļ�ת�����˶�������������Ҳ�����Ǳ���ļ�
	   //sql = "   UPDATE   imgt   SET   img   =   ?   ";
	     
	   sql = "INSERT INTO imgtable  (img) VALUES (?)";
	   
	   pstmt = conn.prepareStatement(sql);
	   pstmt.setBinaryStream(1, photoStream, (int) file.length());		//  ��ָ����������Ϊ����������
	   pstmt.executeUpdate();
	   pstmt.close();
	   conn.close();
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
 }
 public static void main(String args[]){
	  PutImg pi=new PutImg();
	  pi.putimg();
 }
}
