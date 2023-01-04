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
	// pageContext객체영역 조회
	String getPage = (String)pageContext.getAttribute("pageContext");
	// pageContext = jsp 한 페이지에서만 값이 유요함
			
	// request 객체 영역 조회
	String getRequest = (String)request.getAttribute("request");
	
	// session 객체 영역 조회
	String getSession = (String)session.getAttribute("session");
	
	// application 객체 영역 조회
	String getApplication = (String)application.getAttribute("application");
%>


<h1> Ex02 Scope </h1>
pageContext : <%=getPage %> <br>
request : <%=getRequest %> <br>
session : <%=getSession %> <br>
application : <%=getApplication %>
</body>
</html>