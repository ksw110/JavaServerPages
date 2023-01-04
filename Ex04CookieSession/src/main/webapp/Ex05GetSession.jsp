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
		String id = (String)session.getAttribute("id");
		Integer age = (Integer)session.getAttribute("age");
	
	%>

	아이디 : <%=id %> <br>
	나이 : <%=age %>
	<a href="Ex06RemoveSession.jsp">세션삭제</a>
	<a href="Ex07InvalidateSession.jsp">세션모두삭제</a>











</body>
</html>