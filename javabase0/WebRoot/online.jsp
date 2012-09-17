<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.geek.listen.SessionCounter" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>在线人数统计</title>

  </head>
  
  <body>     
	在线：<%= SessionCounter.getActiveSessions() %> 人
  </body>
</html>
