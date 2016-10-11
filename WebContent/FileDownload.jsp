<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="WordCount.FileProccessing"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传及统计结果</title>
</head>

<body>
	<center>
		<h2>${message}</h2>
	</center>
	<% String juge = (String)request.getAttribute("message");
	if(!juge.startsWith("Error")) {%>
	统计结果:<br />
	<%FileReader filePrint = new FileReader("D:\\Project\\workspace\\CountWeb\\Result.txt");
	BufferedReader br = new BufferedReader(filePrint);
	for(int i = 0;i<14;i++){%>
		<%=br.readLine()%><br />
	<% }
	br.close();
	filePrint.close();
	%>
	<a href="D:\Project\workspace\CountWeb\Result.txt">下载Result文件</a>
	<%} %>
	<br />
</body>
</html>