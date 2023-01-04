<%@page import="com.smhrd.domain.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.smhrd.domain.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%-- 	<%
		MemberDAO dao = new MemberDAO();
		List<MemberVO> memberList = dao.selectAll();
	%> --%>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body style="text-align: center;">
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>회원관리페이지</h2></caption>
							<tr>
								<td>Email</td>
								<td>Tel</td>
								<td>Address</td>							
							</tr>
							<jsp:useBean id="MemberDAO" class="com.smhrd.domain.MemberDAO"/>
							<c:set var="MemberList" value="${MemberDAO.selectAll() }"/>
								<c:forEach items="${MemberList}" var="mlist">
									<tr>
										<td><c:out value="${mlist.email}" /></td>
										<td><c:out value="${mlist.tel}" /></td>
										<td><c:out value="${mlist.address}" /></td>
										<td><a href="DeleteCom?email=${mlist.email }">회원삭제</a></td>						
									</tr>
								</c:forEach>
							<!-- 2.모든 회원의 이메일(email),전화번호(tel),주소(address)를 출력하시오. -->
							<%-- <%for(MemberVO m : memberList){ %>
							<tr>
								<td><%=m.getEmail() %></td>
								<td><%=m.getTel() %></td>
								<td><%=m.getAddress() %></td>	
								<td><a href="DeleteCom?email=<%=m.getEmail() %>">회원삭제</a></td>						
							</tr>
							<%} %> --%>
						</table>
					</nav>		
					<a href="main.jsp" class="button next scrolly">되돌아가기</a>	
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>

