<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import ="com.sun.poolman.*,java.sql.*"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'poolman.jsp' starting page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <% 
    PoolmanBroker pool = new PoolmanBroker(); 
    Connection conn = pool.getConnection(); 
    out.println("aa"); 
    conn.close(); 
  %>
	
  </body>
</html>
