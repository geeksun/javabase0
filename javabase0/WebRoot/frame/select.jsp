 <%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>caidan</title>
</head>

<body>
<center><h1>caidan</h1></center>
<div align="center"><form name="isc">
              <table border="0" cellspacing="0" cellpadding="0">
                <tr align="center">
                  <td nowrap height="11">
                    顶级类别
                    <select name="example" size="1" onChange="redirect(this.options.selectedIndex)">
                      <option selected>顶级类别1</option>
                      <option>顶级类别2</option>
                      <option>顶级类别3</option>
                      <option>顶级类别4</option>
                    </select>
                    下属类别 
                    <select name="stage2" size="1" onChange="redirect1(this.options.selectedIndex)">
                      <option value=" " selected>下属类别1</option>
                      <option value=" ">下属类别2</option>
                      <option value=" ">下属类别3</option>
                      <option value=" ">下属类别4</option>
                    </select>
                  
              </table>
            </form>
          </div>
          <script language="JavaScript">
<!--
var groups=document.isc.example.options.length
var group=new Array(groups)
for (i=0; i<groups; i++)
group[i]=new Array()

group[0][0]=new Option("下属类别1");
group[1][0]=new Option("下属类别2");

group[2][0]=new Option("下属类别3");
group[3][0]=new Option("下属类别4");

var temp=document.isc.stage2


function redirect(x){
for (m=temp.options.length-1;m>0;m--)
temp.options[m]=null
for (i=0;i<group[x].length;i++){
temp.options[i]=new Option(group[x][i].text,group[x][i].value)
}
temp.options[0].selected=true
redirect1(0)
}



var secondGroups=document.isc.stage2.options.length
var secondGroup=new Array(groups)
for (i=0; i<groups; i++)  {
secondGroup[i]=new Array(group[i].length)
for (j=0; j<group[i].length; j++)  {
secondGroup[i][j]=new Array()  }}

var temp1=document.isc.stage3
function redirect1(y){
for (m=temp1.options.length-1;m>0;m--)
temp1.options[m]=null
for (i=0;i<secondGroup[document.isc.example.options.selectedIndex][y].length;i++){
temp1.options[i]=new Option(secondGroup[document.isc.example.options.selectedIndex][y][i].text,secondGroup[document.isc.example.options.selectedIndex][y][i].value)
}
temp1.options[0].selected=true
}
</script>
</body>
</html>
