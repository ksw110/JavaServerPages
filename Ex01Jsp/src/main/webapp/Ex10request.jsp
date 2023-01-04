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
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int java = Integer.parseInt(request.getParameter("Java"));
		int python = Integer.parseInt(request.getParameter("Python"));
		int web = Integer.parseInt(request.getParameter("Web"));
		int mac = Integer.parseInt(request.getParameter("Machine"));
		int svg = (java+python+web+mac)/4;
	%>
<fieldset>
   <legend> 학점 확인 프로그램 </legend>
   	<table>
   		<tr>
   			<td>이름</td>
   			<td><%=name %></td>
   		</tr>
   		<tr>
   			<td>Java 점수</td>
   			<td><%=java %></td>
   		</tr>
   		<tr>
   			<td>Python 점수</td>
   			<td><%=python %></td>
   		</tr>
   		<tr>
   			<td>Web 점수</td>
   			<td><%=web %></td>
   		</tr>
   		<tr>
   			<td>Machine Learning 점수</td>
   			<td><%=mac %></td>
   		</tr>
   		<tr>
   			<td>평균</td>
   			<td><%=svg %></td>
   		</tr>
   		<tr>
   			<td>학점</td>
   			<td><%
   				if(svg == 100){
   					out.print("<h3>A+</h3>");
   				}else if(svg >= 90){
   					out.print("<h3>A</h3>");
   				}else if(svg >= 80){
   					out.print("<h3>B</h3>");
   				}else if(svg >= 70){
   					out.print("<h3>C</h3>");
   				}else{
   					out.print("<h3>D</h3>");
   				}
   				%></td>
   		</tr>
   	</table>
</fieldset>	
</body>
</html>