<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 각 내장객체의 영역에 대해서 알아보자. 
			1. 객체 생성 : setAttribute(name,value)
			2. 객체 조회 : getAttrlbute(name)
			-->

<%
	// pageContext 영역
	pageContext.setAttribute("pageContext" , "jsp페이지" );
	String getPage = (String)pageContext.getAttribute("pageContext");
	
	// request 영역
	request.setAttribute("request","요청");
	String getRequest = (String)request.getAttribute("request");
	
	// session 영역
	session.setAttribute("session", "브라우저");
	String getSession = (String)session.getAttribute("session");
	
	// application 영역
	application.setAttribute("application", "웹 어플리케이션");
	String getApplication = (String)application.getAttribute("application");
	
	// request 객체 넘기기
	 RequestDispatcher rd = request.getRequestDispatcher("Ex02Scope.jsp");
	 rd.forward(request,response);
	
	// sendRedirect방식
	//response.sendRedirect("Ex02Scope.jsp");
%>

<h1> Ex01 Scope </h1>
pageContext : <%=getPage %> <br>
request : <%=getRequest %> <br>
session : <%=getSession %> <br>
application : <%=getApplication %>


</body>
</html>