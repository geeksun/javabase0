<%@ page language="java" import="java.util.*,java.sql.*,java.io.*,jxl.*" pageEncoding="gbk"%>
<%@ page contentType="application/msexcel;charset=gbk" %>
<%
  response.reset();   
  response.setContentType("application/vnd.ms-excel");   
  File f=new File("d:\\kkk.xls");   
  jxl.write.WritableWorkbook  wb =  Workbook.createWorkbook(f);   
  jxl.write.WritableSheet  ws  =  wb.createSheet("TestSheet1", 0);   
 
 %>
<%--  以上这行设定传送到前端浏览器时的档名为test1.xls
      就是靠这一行，让前端浏览器以为接收到一个excel文件
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>createExcel</title>
	
  </head>
  
  <body>
    																			
  </body>
</html>
