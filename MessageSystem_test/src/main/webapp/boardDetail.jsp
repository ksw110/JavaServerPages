<%@page import="com.smhrd.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.smhrd.model.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <title>Forty by HTML5 UP</title>
      <meta charset="utf-8" />
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
      <link rel="stylesheet" href="assetsBoard/css/main.css" />
      <link rel="stylesheet" href="assetsBoard/css/board.css" />
      <!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
      <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
      
</head>
<body>      
         <!-- Q19. 게시글 세부내용 조회 기능 
         		: select * from web_board where num = 선택한 게시글의 num -->
         <%
         	int num = Integer.parseInt(request.getParameter("num"));
         	BoardVO vo = new BoardDAO().detailBoard(num);
         
         %>
         
         <div id="board">
            <table id = "list">
               <tr>
                  <td>제목</td>
                  <td><%=vo.getTitle() %></td>
               </tr>
               <tr>
                  <td>작성자</td>
                  <td><%=vo.getWriter() %></td>
               </tr>
               <tr>
                  <td>다운로드</td>
                  <td><a href="./file/<%=vo.getFilename()%>" download>다운로드</a></td>
               </tr>
               <tr>
                  <td colspan="2">내용</td>
                  
               </tr>
               <tr>
                  <td colspan="2">
                  <h3><%=vo.getContent() %></h3>
                  <img src="./file/<%=vo.getFilename()%>">
                  </td>
               </tr>
               <tr>
                  <td colspan="2"><a href="boardMain.jsp"><button>뒤로가기</button></a></td>
               </tr>
            </table>
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