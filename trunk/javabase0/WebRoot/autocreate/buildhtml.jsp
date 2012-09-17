<%@ page contentType="text/html; charset=gb2312" import="java.util.*,java.io.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>build html source</title>

  </head>
  
  <body>
	<%
	try{
		String title="jsp生成静态html文档";
		String content="小样，还搞不定您？";
		String editer="webjxcom";
		String filePath = "";
		
		// filePath = request.getRealPath("/")+"template.html";
		filePath = "template.html";
		out.print(filePath);
		
		String templateContent="";
		FileInputStream fileinputstream = new FileInputStream(filePath);	//读取模块文档
		int lenght = fileinputstream.available();
		byte bytes[] = new byte[lenght];
		fileinputstream.read(bytes);
		fileinputstream.close();
		templateContent = new String(bytes);
		out.print(templateContent);
		
		templateContent=templateContent.replaceAll("###title###",title);
		templateContent=templateContent.replaceAll("###content###",content);
		templateContent=templateContent.replaceAll("###author###",editer);	//替换掉模块中相应的地方
		out.print(templateContent);
		
		// 根据时间得文档名
		Calendar calendar = Calendar.getInstance();
		String fileame = String.valueOf(calendar.getTimeInMillis()) +".html";
		fileame = request.getRealPath("/")+fileame;							//生成的html文档保存路径
		FileOutputStream fileoutputstream = new FileOutputStream(fileame);	//建立文档输出流
		out.print("文档输出路径:<br>");
		out.print(fileame);
		
		byte tag_bytes[] = templateContent.getBytes();
		fileoutputstream.write(tag_bytes);
		fileoutputstream.close();
	}
	catch(Exception e){
		out.print(e.toString());
	}
	%>

  </body>
