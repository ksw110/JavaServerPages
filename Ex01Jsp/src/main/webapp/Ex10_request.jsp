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
   // 1. post방식 인코딩
   request.setCharacterEncoding("utf-8");

   // 2. 데이터 받아오기
   String name = request.getParameter("name");
   
   // 점수데이터는 연산(평균)을 위해서 int형으로 변환
   int java = Integer.parseInt(request.getParameter("java"));
   int python = Integer.parseInt(request.getParameter("python"));
   int web = Integer.parseInt(request.getParameter("web"));
   int ml = Integer.parseInt(request.getParameter("ml"));
   
   // 3. 평균
   int avg = (java+python+web+ml)/4;
   
   // 4. 학점
   String score = null;
   if(avg==100){
      score="A+";
   }else if(avg >=90){
      score="A";
   }else if(avg >=80){
      score="B";
   }else if(avg >=70){
      score="C";
   }else{
      score="D";
   }
%>

<!-- 5. Web에 출력하기  -->
<fieldset>
      <legend> 학점 확인 프로그램 </legend>
         <table>
            <!-- 1행 -->
            <tr>
               <td>이름</td>
               <td> <%= name %></td>
            </tr>
            <!-- 2행 -->
            <tr>
               <td>Java점수</td>
               <td><%= java %></td>
            </tr>
            <!-- 3행 -->
            <tr>
               <td>Python점수</td>
               <td><%= python %></td>
            </tr>
            <!-- 4행 -->
            <tr>
               <td>Web점수</td>
               <td><%= web %></td>
            </tr>
            <!-- 5행 -->
            <tr>
               <td> ML점수</td>
               <td><%= ml %></td>
            </tr>
            <tr>
               <td> 평균 </td>
               <td><%= avg %></td>
            </tr>
            <tr>
               <td> 학점 </td>
               <td><%= score %></td>
            </tr>
         </table>
      
   </fieldset>

</body>
</html>