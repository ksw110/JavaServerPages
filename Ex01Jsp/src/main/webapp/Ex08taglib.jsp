<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!-- 5가지 종류가 있고, core와 function을 가장 많이 사용
    core : 조건문, 반복문이 존재
    function : String과 관련된 메소드
    태그가 기존 html코드와 겹칠 수 있기 때문에 접두사(prefix)를 붙여서사용
    접두사는 개인이 수정 가능! -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 스트립트릿 -->
 <% for(int i=1; i<=5;i++){ %>
	<p> <%=i %> </p>
 <%} %>	 
<!-- JTTL : Jsp Standard Tag Library : jsp에서 사용하는 태그 라이브러리
	why? 프로그래밍 언어를 몰라도 반복문, 조건문 등을 사용하기 위해서~! -->
	
	<!-- 변수선언 -->
	<c:set var="i"></c:set> 
	
	<%-- EL : 출력할 때 사용
		 1. var의 변수이름
		 2. 연산자(산술,관계,논리)
		 3. 속성이름 --%>
		 
	<!-- 반복문 -> c:forEach -->
	<c:forEach var="i" begin="1" end="5" step="1">
	
	<!-- 짝수일 때만 출력! -> 조건 c:if -->
	
	<c:if test="${i%2==0 }">
	
	<p> ${i} </p>
	
	</c:if>
</c:forEach>

</body>
</html>