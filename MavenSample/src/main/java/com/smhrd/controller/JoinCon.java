package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.DAO;
import com.smhrd.model.VO;

public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
	// System.out.println(id+" ,"+pw+" ,"+name);
		
		VO vo = new VO(id, pw, name);
		
		DAO dao = new DAO();
		int cnt = dao.join(vo);
	// System.out.println(cnt);
		if(cnt > 0) { // 회원가입 성공
			System.out.println("회원가입 성공!");
			
			// Redirect , 쿼리스트링 방식
			// response.sendRedirect("main.jsp?result=success");
			
			// 포워딩방식
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			request.setAttribute("result", "success");
			rd.forward(request, response);
		}else { // 회원가입 실패
			System.out.println("회원가입 실패!");
			//response.sendRedirect("main.jsp?result=fail");
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			request.setAttribute("result", "fail");
			rd.forward(request, response);
		}
	}

}
