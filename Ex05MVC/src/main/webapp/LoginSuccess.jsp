<%@page import="com.smhrd.model.Member"%>
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
		//주의할 점 세션의 value값은 Object 타입으로 업캐스팅 돼서 저장됨
		// 그래서 가지고 올 때도 Object 타입으로 가지고옴
		// Member 타입에 담기 위해서는 다운 캐스팅(강제형변환)이 필요함
		
 		Member vo = (Member)session.getAttribute("member");
	
		String name = vo.getName();
	%>
	
	<%=name %> 님 환영합니다!
</body>
</html>