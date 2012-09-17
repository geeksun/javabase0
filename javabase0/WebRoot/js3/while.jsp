<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<html>
  <head>
    <title>while 的用法</title>
    
  <script type="text/javascript">
  		var n = prompt("请输入月份:",1);
		var sum = 0;
		var seed = 1;
   		while(seed<=n){            //  求 1 到 n 的和
			sum+=seed;
			seed++;
		}
		alert(sum);
  </script>

  </head>
  
  <body>
  </body>
</html>
