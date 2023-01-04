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
<legend>랜덤 당첨 작성</legend>
<form action="Ex13randomResult.jsp">
주제 : <input type="text" name="name"><br>

<%
 	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	for(int i =1 ; i <= num;i++){%>
		아이템<%=i %> : <input type="text" number<%=i %>><br>
	<% }%>


<input type="submit" value="생성하기">
</form>
</fieldset>
	
</body>
</html>