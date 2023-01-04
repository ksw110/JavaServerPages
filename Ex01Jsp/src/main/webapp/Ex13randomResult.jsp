<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>랜덤 당첨 결과</legend>
	<%
	request.setCharacterEncoding("UTF-8");
	System.out.print("넘오옴");
	Random rd = new Random();
	ArrayList<String> arr = new ArrayList<String>();
	String name = request.getParameter("name");
	System.out.print(name);
	int num = Integer.parseInt(request.getParameter("num"));
	System.out.print(num);
	//for(int i = 1; i<=num;i++){
	//arr.add(request.getParameter("number"+i));
	//}
	//out.print("주제 : "+name);
	//out.print("<br>결과 : "+arr.get(num-1));
	%>
</fieldset>
</body>
</html>