<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	String URL = request.getParameter("URL");
	
	
	if(URL.equals("na")){
	response.sendRedirect("http://www.naver.com");
	}else if(URL.equals("go")){
	response.sendRedirect("http://www.google.com");
	}else{
	response.sendRedirect("https://www.youtube.com");
	}
	%>
</body>
</html>