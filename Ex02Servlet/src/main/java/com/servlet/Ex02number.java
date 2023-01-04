package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex02number")
public class Ex02number extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("data");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		System.out.println("클라이언트 요청이 들어옴..!");
		System.out.println("클라이언트가 입력한 값 :" + data);
		
		response.setContentType("text/html; charset=UTF-8");
		out.print("<string>입력한 숫자는 <b>"+data+"</b>입니다.</string>");
	
	}

}
