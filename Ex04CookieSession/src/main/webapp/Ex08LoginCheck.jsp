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
	// 요청 데이터 id, pw 값 가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	// id=test,pw=12345 -> 로그인 성공 if
	if(id.equals("test")&& pw.equals("12345")){
	// 로그인 성공시 -> Ex08Main.jsp 로 이동
	// 				닉네임 : 쿠키몬스터
		session.setAttribute("nick", "쿠키몬스터");
		response.sendRedirect("Ex08Main.jsp");
	}else{
	// 로그인 실패시 -> Ex07Loginform.jsp 로 이동
		response.sendRedirect("Ex08Loginform.jsp");
	}
	%>
	
	
</body>
</html>