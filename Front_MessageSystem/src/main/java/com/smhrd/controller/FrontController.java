package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// URL : http://localhost:8081/Front_MessageSystem/Join.do 전체
		// URI : /Front_MessageSystem/Login.do 호스트 제외
		// ContextPath : /Front_MessageSystem
		System.out.println("Front로 진입 ...");
		
		String reqestURI = request.getRequestURI(); // URI 만 가져오는 함수
		String contextPath = request.getContextPath(); // contextpath 가져오는 함수
		String path = reqestURI.substring(contextPath.length()); // substring 인덱싱 개념 앞에서 몇번째까지 제외시킬수있음
		
		String url = null;
		MessageCommand command = null;
		
//		System.out.println(reqestURI);
//		System.out.println(contextPath);
//		System.out.println("유저의 요청 : " + path);
		
		if(path.equals("/Login.do")) {
			System.out.println("로그인 처리");
			
			command = new LoginCon();
			// url = command.execute(request, response);
			
		}else if(path.equals("/Join.do")) {
			System.out.println("회원가입 처리");
			
			command = new JoinCon();
			// url = command.execute(request, response);
		}
		url = command.execute(request, response);
		// 페이지 이동
		
		if(path.equals("/Join.do")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect(url);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
