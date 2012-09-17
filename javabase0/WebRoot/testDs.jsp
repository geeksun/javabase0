<%@ page language="java" import="java.util.*,javax.sql.*,java.sql.*,javax.naming.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'index.jsp' starting page</title>
    
  </head>
  
  <body>
  <%     
   try{
	   		Context init=new InitialContext();
    		Context con = (Context)init.lookup("java:comp/env");
    		out.println("1");
    	    DataSource ds = (DataSource)con.lookup("jdbc/temp");
    	    out.println("2");
    	    Connection co = ds.getConnection();
    	    out.println("3");
	}catch(Exception e){
		out.println("error");
		e.printStackTrace();
	}
	%>
     
  </body>
</html>
