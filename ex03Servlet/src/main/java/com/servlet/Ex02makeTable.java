package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex02makeTable")
public class Ex02makeTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 지정한 방의 갯수를 받아와서 테이블 형태로 출력
		// 6개의 방을 테이블 사용해서 만들어서 출력
		// for문 사용해서 진행
		
		// 갯수 받아오기
		String data = request.getParameter("data");
		// 문자형이여서 정수형으로 형변환
		int num = Integer.parseInt(data);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.print("<table border = 1>");
		out.print("<tr>");
		
		for(int i =1; i<=num; i++) {
			out.print("<td>"+i+"</td>");
			
		}
		
		out.print("</tr>");
		out.print("</table>");
		

	}

}
