<%@ page language="java" import="java.util.*,java.sql.*,java.io.*,jxl.*" pageEncoding="gbk"%>
<%@ page contentType="application/msexcel;charset=gbk" %>
<%
  response.reset();   
  response.setContentType("application/vnd.ms-excel");   
  File f=new File("d:\\kkk.xls");   
  jxl.write.WritableWorkbook  wb =  Workbook.createWorkbook(f);   
  jxl.write.WritableSheet  ws  =  wb.createSheet("TestSheet1", 0);   
 
 %>
<%--  ���������趨���͵�ǰ�������ʱ�ĵ���Ϊtest1.xls
      ���ǿ���һ�У���ǰ���������Ϊ���յ�һ��excel�ļ�
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>createExcel</title>
	
  </head>
  
  <body>
    																			
  </body>
</html>
