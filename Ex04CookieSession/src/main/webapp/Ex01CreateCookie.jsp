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
		// 1. 쿠키 객체 생성
		// Cookie(name(String),value(String))
		Cookie cookie = new Cookie("test","cookie1");
	
		// 2. 유효기간 설정(초단위)
		cookie.setMaxAge(60*60*24*365);
		
		// 3. 클라이언트에 쿠키 전송(서버 -> 클라이언트 : response)
		response.addCookie(cookie);
		
		// 쿠키 생성과 동시에 전송
		response.addCookie(new Cookie("id","smart"));
	
	%>
	<a href="Ex02GetCookie.jsp">쿠키확인</a>

</body>
</html>