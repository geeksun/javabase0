<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'optionMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
    <table align="center" cellpadding="0" cellspacing="0"> 
<form name="form1" method="post" action="" onSubmit="return false"> 
<tr> 
<td width="90" height="20"> 
<select style="width:90" name="province" size="1" id="province" onchange="changecity(document.form1.province.options[document.form1.province.selectedIndex].value)"> 
<option value="��ѡ��ʡ��" selected>��ѡ��ʡ��</option> 
<%allprovince="����,����,����,����,�㶫,����,����,����,�ӱ�,����,������,����,����,����,����,����,����,���ɹ�,����,�ຣ,ɽ��,ɽ��,����,�Ϻ�,�Ĵ�,���,����,�½�,����,�㽭,����,���,����,̨��";
String[] everyprovince=split(allprovince,","); 
	for(i=0;i<everyprovince.length;i++){
	%> 
<option value="<%=everyprovince(i)%>"><%=everyprovince(i)%></option> 
<%
	}
%> 
</select> 
</td> 
<td width="101"><select name="city" style="width:90px" size="1" id="city"> 
<option selected>��ѡ�����</option> 
</select> 
</td> 
</tr> 
</form> 
</table> 
<script language="javascript"> 
/*ʡ����ʾ*/ 
var eachcity=new Array(); 
var tcnum=new Array(); 
<%allpc="����|����^����^����^����^����^��̨^ʯ��ɽ^����^��ͷ��^��ɽ^ͨ��^˳��^��ƽ^����^ƽ��^����^����^����*�Ϻ�|����^¬��^���^����^����^����^բ��^���^����^����^��ɽ^�ζ�^�ֶ�^��ɽ^�ɽ�^����^�ϻ�^����^����*���|��ƽ^����^�Ӷ�^����^����^����^�Ͽ�^����^�ӱ�^����^����^����^����^���^����^����^����^����*����|����^����^����^��ɿ�^����^ɳƺ��^������^�ϰ�^����^��ʢ^˫��^�山^����^ǭ��^����^�뽭^����^ͭ��^����^�ٲ�^��ɽ^��ƽ^�ǿ�^�ᶼ^�潭^��¡^����^����^����^���^��ɽ^��Ϫ^ʯ��^��ɽ^����^��ˮ^����^�ϴ�^����^�ϴ�*�ӱ�|ʯ��ׯ^����^��̨^����^�żҿ�^�е�^�ȷ�^��ɽ^�ػʵ�^����^��ˮ*ɽ��|̫ԭ^��ͬ^��Ȫ^����^����^˷��^����^����^����^�ٷ�^�˳�*���ɹ�|���ͺ���^��ͷ^�ں�^���^���ױ�����^��������^����ľ��^�˰���^�����첼��^���ֹ�����^�����׶���^��������*����|����^����^��ɽ^��˳^��Ϫ^����^����^Ӫ��^����^����^�̽�^����^����^��«��*����|����^����^��ƽ^��Դ^ͨ��^��ɽ^��ԭ^�׳�^�ӱ�*������|������^�������^ĵ����^��ľ˹^����^�绯^�׸�^����^�ں�^˫Ѽɽ^����^��̨��^���˰���*����|�Ͼ�^��^����^��ͨ^����^�γ�^����^���Ƹ�^����^����^��Ǩ^̩��^����*�㽭|����^����^����^����^����^����^��^����^��ɽ^̨��^��ˮ*����|�Ϸ�^�ߺ�^����^��ɽ^����^ͭ��^����^��ɽ^����^����^����^����^����^����^����^����^����*����|����^����^����^����^Ȫ��^����^��ƽ^����^����*����|�ϲ���^������^�Ž�^ӥ̶^Ƽ��^����^����^����^�˴�^����^����*ɽ��|����^�ൺ^�Ͳ�^��ׯ^��Ӫ^��̨^Ϋ��^����^̩��^����^����^����^����^����^�ĳ�^����^����*����|֣��^����^����^ƽ��ɽ^����^�ױ�^����^����^���^���^���^����Ͽ^����^����^����^�ܿ�^פ���^��Դ*����|�人^�˲�^����^�差^��ʯ^����^�Ƹ�^ʮ��^��ʩ^Ǳ��^����^����^����^����^Т��^����*����|��ɳ^����^����^��̶^����^����^����^����^¦��^����^����^����^����^�żҽ�*�㶫|����^����^�麣^��ͷ^��ݸ^��ɽ^��ɽ^�ع�^����^տ��^ï��^����^����^÷��^��β^��Դ^����^��Զ^����^����^�Ƹ�*����|����^����^����^����^����^���Ǹ�^����^���^����^��������^���ݵ���^����^��ɫ^�ӳ�*����|����^����*�Ĵ�|�ɶ�^����^����^�Թ�^��֦��^��Ԫ^�ڽ�^��ɽ^�ϳ�^�˱�^�㰲^�ﴨ^�Ű�^üɽ^����^��ɽ^����*����|����^����ˮ^����^��˳^ͭ��^ǭ����^�Ͻ�^ǭ����^ǭ��*����|����^����^����^��Ϫ^��ͨ^����^���^��ɽ^˼é^��˫����^��ɽ^�º�^����^ŭ��^����^�ٲ�*����|����^�տ���^ɽ��^��֥^����^����^����*����|����^����^����^ͭ��^μ��^�Ӱ�^����^����^����^����*����|����^������^���^����^��ˮ^��Ȫ^��Ҵ^����^����^¤��^ƽ��^����^����^����*����|����^ʯ��ɽ^����^��ԭ*�ຣ|����^����^����^����^����^����^����^����*�½�|��³ľ��^ʯ����^��������^����^��������^����^�������տ¶�����^��������^��³��^����^��ʲ^����^������*���|*����|*̨��|̨��^����^̨��^̨��^����^��Ͷ^����^����^�û�^����^����^����^��԰^����^��¡^̨��^����^����^���"; 
  String[] allp=split(allpc,"*");
for(i=0;i<allp.length;i++){ 
  String[] pc=split(allp(i),"|");
    String[] eachcity=split(pc(1),"^");
    %> 
eachcity[<%=i%>]=new Array(); 
<%for(j=0;j<eachcity.length;j++){%> 
eachcity[<%=i%>][<%=j%>]=new Array("<%=eachcity(j)%>","<%=pc(0)%>"); 
<%}%> 
tcnum[<%=i%>]=<%=ubound(eachcity)%>; 
<%} 
tpnum=ubound(allp)

%> 

function changecity(provincevalue){ 
/*��ѡ������б��ֵ��Ϊ��ʱ�������С�������б��������Ŀ����ȻС���б��е���Ŀ����ӵġ�ͬʱҲ�ǳ�ʼ�� options ��ֵΪ0 */ 
document.form1.city.length = 0; 
//ѭ��д������Ĵ�������Ӧ��С�ࡣ 
for (i=0;i<=<%=tpnum%>; i++){ 
for (j=0;j<=tcnum[i];j++){ 
if (provincevalue==eachcity[i][j][1]){ 
document.form1.city.options[document.form1.city.length] = new Option(eachcity[i][j][0],eachcity[i][j][0],"",""); 
/*�����µ�Option���󲢸�ֵ��options������ֵ��0��ʼ��new Option������4�����ԣ���Ӧ�ֱ��ǣ��ı�����value��defaultSelect��selected��������ֻ���˵�һ���͵ڶ�����*/ 
} 
} 
} 
} 
</script> 
  </body>
</html>
