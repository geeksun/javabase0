<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jsp中使用js</title>
  </head>
  
  <body>
  	
   		<script type="text/javascript">
   			var temp = [];
   			<%
		  	String test = "1101,1102,1104,1106";
		  	if(test!=null){
		  		String[] ttt = test.split(",");
		  		//String[] ttt = {"0101","0102","0104","0106"};
		  		for(int i=0;i<ttt.length;i++){
		   %>
		   			temp.length = <%=ttt.length%>;
		   			temp[<%=i%>] = <%=ttt[i]%>;
		   		<%
		   }
		   }
		    %>
		    function testTemp(){
		    	for(var i=0;i<temp.length;i++){
		    		alert(temp[i]);
		    	}
		    }
   		</script>
   
  
      	<script language="javascript"> 
		var test = new Array(); 
		test[0] = '1101'; 
		test[1] = '1103'; 
		test[2] = '1104'; 
		test[3] = '1106'; 
		
		// values is instranceof Array 
		function check(values) { 
			for(var c=0; c<values.length; c++) { 
				isequals(values[c] + ''); 
			} 
		} // end check() 
		
		function isequals(v) {
			var chboxies = document.getElementById('sum').getElementsByTagName('INPUT'); 
			if(chboxies.length) { 
				for(var c=0; c<chboxies.length; c++) { 
					if(chboxies[c].name == 'fabu' && v == chboxies[c].value) { 
						chboxies[c].checked = 'checked'; 
					} 
				} 
			} 
		} // end isequals() 
		
		</script> 
		
		<form id='sum' name="sum"> 
		<INPUT type="checkbox" id="fabu" name="fabu" value="1101" >查看 
		<INPUT type="checkbox" id="fabu" name="fabu" value="1102" >增加 
		<INPUT type="checkbox" id="fabu" name="fabu" value="1103" >修改 
		<INPUT type="checkbox" id="fabu" name="fabu" value="1104" >审核 
		<INPUT type="checkbox" id="fabu" name="fabu" value="1105" >发布 
		<INPUT type="checkbox" id="fabu" name="fabu" value="1106" >撤销发布 
		<INPUT type="checkbox" id="fabu" name="fabu" value="1107" >删除 
		</form> 
		
		<a href="#" onclick="check(test);">bbb</a> 
		<a href="#" onclick="check(temp);">aaa</a> 
		<a href="#" onclick="testTemp();">test</a> 
		<script language="javascript"> 
			//check(test); 
			check(temp);
		</script> 
      
  </body>
</html>
