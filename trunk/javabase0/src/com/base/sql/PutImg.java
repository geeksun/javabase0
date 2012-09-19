package com.base.sql;
import java.io.*;
import java.sql.*;
public class PutImg {			 
/**
 *    java 向数据库存取二进制图片
 *    如何读取数据库的二进制的图片？
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
	   InputStream photoStream = new FileInputStream(file);            //  把图片文件转化成了二进制输入流，也可以是别的文件
	   //sql = "   UPDATE   imgt   SET   img   =   ?   ";
	     
	   sql = "INSERT INTO imgtable  (img) VALUES (?)";
	   
	   pstmt = conn.prepareStatement(sql);
	   pstmt.setBinaryStream(1, photoStream, (int) file.length());		//  将指定参数设置为给定输入流
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
