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
		// 1. 세션 값 설정 setAttribute(name(String),value(Object))
		
		session.setAttribute("id", "test");
		session.setAttribute("age",20);
		// 어차피 서버가 알아서 아이디를 부여해줄 것이기 때문에 응답할 필요없이 저장만
		
		
	%>
	<a href="Ex05GetSession.jsp">세션확인</a>
</body>
</html>