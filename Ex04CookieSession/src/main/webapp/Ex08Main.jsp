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
		if(session.getAttribute("nick")==null){
			response.sendRedirect("Ex08Loginform.jsp");
		}else{
		// 로그인 성공 시 -> 쿠키몬스터님 환영합니다! 
		// 로그아웃 기능 만들어서 arlert창에 로그아웃 되었습니다! 띄우기 %>
			
			<%=session.getAttribute("nick")%>님 환영합니다!
			<form action="Ex08Logout.jsp">
				<input type="submit" value="LOGOUT">
			</form>						
			
		<% }%>
		
		
	
	
</body>
</html>