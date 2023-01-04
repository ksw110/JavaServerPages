package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex04getpost")
public class Ex04getpost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식 인코딩
		// 데이터를 꺼내오기 전에 인코딩을 먼저 진행
		request.setCharacterEncoding("UTF-8");
		
		// get방식 인코딩
		// Servers 폴더 - Tomcat폴더 - server.xml 파일
		// 63번째 Connector태그에 URLEncoding="인코딩방식" 추가
		
		// 데이터를 보낸 방식 확인(get, post)
		String method = request.getMethod();
		System.out.println("method : "+method);
		
		// 데이터 받아오기
		String data = request.getParameter("data");
		System.out.println("data : "+data);
		
		
	}

}
