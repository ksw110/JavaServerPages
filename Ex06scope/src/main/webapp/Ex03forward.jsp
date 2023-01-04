<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1> forward 방식</h1>
	<ul>
		<li> 서버 내에서 이동해야할 페이지로 알아서 이동 </li>
		<li> 요청은 1번, request 객체에 담긴 정보들이 유지 </li>
		<li> 요청이 1번이기때문에, 네트워크 트래픽이 발생X, 속도가 빠름 </li>
		<li> request 객체가 유지되기 때문에 모든 타입(Object)의 데이터를 담을 수 있음 </li>
		<li> 서버 내에서만 이동이 가능 </li>
		<li> 시스템에 변화가 생기지 않는 단순조회요청의 경우 사용 </li>
	</ul>
	
	<% // RequestDispatcher rd = request.getRequestDispatcher("http://www.naver.com");
	   // rd.forward(request,response);
	   
	%>
	<h1> sendRedirect방식</h1>
	<ul>
		<li> 이동해야할 페이지 주소를 응답해서, 해당 페이지를 요청할 수 있도록 함. </li>
		<li> 요청이 2번, 2번의 request 객체는 서로 다른 객체 </li>
		<li> 데이터를 쿼리스트링 방식으로만 전송이 가능해서, Text형태 데이터만 전송가능 </li>
		<li> 요청이 2번이기 때문에, 네트워크 트래픽 방생O, 속도가 느림 </li>
		<li> 새롭게 요청을 하는 것이라서, 다른 서버의 페이지로 이동 가능 </li>
		<li> 시스템에 변화가 생기는 회원가입, 글쓰기 요청일 때 사용 </li>
	</ul>
	
	<%
		response.sendRedirect("http://www.naver.com");
	%>
</body>
</html>