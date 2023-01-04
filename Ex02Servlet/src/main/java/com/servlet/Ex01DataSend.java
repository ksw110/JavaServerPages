package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex01DataSend")
public class Ex01DataSend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 유저에게 데이터를 전송해줄 때 : PrintWriter(통로)
		// 데이터를 전송할 수 있는 통로 생성 : response.Writer(식별자)
		// 데이터를 전송 : out.print()
		String data = request.getParameter("data");
		
		System.out.println("클라이언트 요청이 들어옴..!");
		System.out.println("클라이언트가 입력한 값 :" + data);
		
		// [한글데이터를 전송하는 방법]
		// 클라이언트에게 HTML 문서로 응답
		// 문자 인코딩 방식은 UTF-8
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(data);
		
	}

}
