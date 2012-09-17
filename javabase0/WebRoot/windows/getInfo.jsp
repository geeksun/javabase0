
<%@ page language="java" import="java.util.*"%>
<%
//?????id??
  String imgID = request.getParameter("id");
  if (imgID==null||imgID.equals(""))//???null???
    imgID="one";//??????
  if ( imgID.equals("one"))//???one
  {
%>
<h3 style="border-bottom: 1px solid #C0C0C0; margin-bottom: -5px">This is text one</h3>
<br>
<img src="one.jpg" width="200px" height="150px" align="center"/>

<%}else{//??
%>
<h3 style="border-bottom: 1px solid #C0C0C0; margin-bottom: -5px">This is text two</h3>
<br>
<img src="two.jpg" width="200px" height="150px" align="center"/>
<%}%>
