package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// URL Mapping Annotation
// : 외부에서 접속할 수 있는 URL을 문자열로 설정
// : 문자열과 자바파일이 연결
@WebServlet("/first")
public class Ex00FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex00FirstServlet() {
    	System.out.println("생성자 호출!");
    }
    
    // 초기화 : 서블릿을 초기화하는 로직을 처리하는 메소드
    @Override
    public void init() throws ServletException {
    	System.out.println("init() 호출!");
    }
    
    // 소멸 : 서블릿이 종료되거나 재시작할 때 동작하는 메소드
    @Override
    public void destroy() {
    	System.out.println("destroy() 호출!");
    }
    
    // HTTP 통신 신호가 들어왔을 때 동작하는 메소드
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service() 호출!");
//	}
	
	// HTTP 요청메소드 중 GET방식을 처리하는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출!");
	}
	
	// Post 방식을 처리하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출!");
	}

}
