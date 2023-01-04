package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01changeBg
 */

// url mapping : servlet클래스를 대신하는 문자열
// 사용이요 1. 클래스 경로가 노출되기 때문에 보안상의 문제
// 사용이유 2. 클래스 경로가 길면 불편
// 다른 servlet의 url mapping값과 중복 불가**
@WebServlet("/helloweb")
public class Ex01changeBg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 색깔 데이터 받아와서 해당 페이지 배경색 바꾸기!
		// 변경 버튼을 누르는것! -> 요청을 하는 행위
		// 따라서 데이터는 요청 객체, 즉 request객체에서 가져와야 한다.
		
		String color = request.getParameter("color");
		System.out.println(color);
		
		// 해당 페이지 색 변경
		response.setContentType("text/html; charset=utf-8");
		
		// 응답할 출력 스트림
		PrintWriter out = response.getWriter();
//		out.print("<body bgcolor="+color+">");
		out.print("<body style='background-color : "+color+"'>");
//		out.print("<style> body{background-color : "+color+"} </style>");
	}

}
