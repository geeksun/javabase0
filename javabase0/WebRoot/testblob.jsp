<%@ page language="java"  pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>测试操作二进制数据</title>
    
  </head>
  
  <body>
      <jsp:useBean id="blob" class="com.sql.BinaryOperate" scope="page"></jsp:useBean>
      <%
      	try{
      		blob.addBlob("E:\\sun.mdl");
      		blob.readBlob("E:\\moon.mdl");
      		out.print("success");
      	}catch(Exception e){
      		out.print(e);
      		e.printStackTrace();
       }
       %>
  </body>
</html>
