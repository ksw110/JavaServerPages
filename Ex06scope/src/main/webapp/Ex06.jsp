<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 입력받은숫자 2개와 그 합을 출력 -->
<% 
	//String num1 = request.getParameter("num1");
	//String num2 = request.getParameter("num2");
	
	// 합
	//int sum = (Integer)request.getAttribute("sum");
	
	// sendRedirect방식으로 받아오기
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	String sum = request.getParameter("sum");

%>
<h1> Ex06 </h1>
num1 : <%=num1 %> <br>
num2 : <%=num2 %> <br>
sum : <%=sum %> <br>
</body>
</html>