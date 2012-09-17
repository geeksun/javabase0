<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>if 的用法</title>
    
    <script type="text/javascript">
		var points = prompt("请输入学生成绩:",0);
        if(points>=90){
            alert("A");
        }else if(points>=75){
			alert("B");
		}else if(points>=60){
			alert("C");
		}else if(points<60){
			alert("D");
		}
	</script>
  </head>
  
  <body>
    
  </body>
</html>
