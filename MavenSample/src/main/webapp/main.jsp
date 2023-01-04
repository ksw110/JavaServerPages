<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// getParameter -> url파라미터(get) / 패킷파라미터(post)
		// String result = request.getParameter("result");
		
		String result = (String)request.getAttribute("result");		
		
		// out.print(result);
	
	%>

	<a href="join.jsp"><button>회원가입</button></a>
	
	<%
		if(result != null){
			if(result.equals("success")){
				out.print("<h3>회원가입에 성공했습니다~</h3>");
			}else{
				out.print("<h3>회원가입에 실패했습니다~</h3>");
			}
		}
	%>
	
	<!-- JSTL -->
	<c:if test="${!empty result}">
		<!-- if~else문 -->
		<c:choose>
			<c:when test="${result eq 'success'}">
				<h3>회원가입에 성공했습니다!</h3>
			</c:when>
			<c:otherwise>
				<h3>회원가입에 실패했습니다!</h3>
			</c:otherwise>
		</c:choose>
	</c:if>
	
	<a href="login.jsp"><button>로그인</button></a>

	<%
		String name = (String)session.getAttribute("name");
	
		if(name == null){
			out.print("<p>로그인 해주세요</p>");
		}else{
			out.print("<p>"+name+"님 환영합니다</p>");
		}
	%>	

	<c:choose>
		<c:when test="${empty name }">
			<p>로그인 해주세요</p>
		</c:when>
		<c:otherwise>
			<p><%=name %>님 환영합니다</p>
		</c:otherwise>
	</c:choose>








</body>
</html>