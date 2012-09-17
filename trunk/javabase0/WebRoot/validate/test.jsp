<%@ page language="java" import="java.util.*" pageEncoding="gbk" contentType="image/jpeg;charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>test</title>
	<script type="text/javascript">
		function reloadImage(url)
		{
			document.valid.pic.src = url;
		}
	</script>
  </head>
  
  <body>
	<form name="valid" action="">
		验证码：
		<img src="/vimage" name="pic"/>
		<a href="javascript:reloadImage('/vimage')">重新读取</a>
	</form>
  </body>
</html>
