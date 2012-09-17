<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
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
    <table>
    	<li>111</li>
    		<tt>
    		<td><strong>222</strong></td>
    		<td></td>
    	
    </table>
    [b]文字加粗[/b]
    <a href=mailto:geeksun@163.com>Email</a>
    
    <%
    	/*
    	String pp = request.getParameter("test");
    	*/
    
     %>
     <!-- pp -->
     <br>
      文本字段边框虚线效果，鼠标点击后恢复文字
     <input name="SearchtxtKeyWordOne" id="SearchtxtKeyWordOne" type="text" class="smallInput1_blue" 
     onFocus="javascript:if(this.value=='小区地址|名称') {this.value=''}" 
     onBlur="javascript:if(this.value==''){this.value='小区地址|名称'}" value="小区地址|名称"   
     style="border:1px  dashed;">
     <br>
     <strong>密码<span class="red">*</span>：</strong>
     <br>
     可以利用 div 的 innerhtml 属性操作内容：<br>
     <div class="note" id="password_condition">
				密码由5-20位英文字母或数字组成，区分大小写,
				建议为英文字母(a-z)和数字(0-9)结合，便于记忆，不易被猜出。<br/><font color="red">注意：不能与用户名相同。</font>
	 </div>
  </body>
</html>
