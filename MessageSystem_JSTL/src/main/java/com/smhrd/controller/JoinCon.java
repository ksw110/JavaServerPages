package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.domain.MemberDAO;
import com.smhrd.domain.MemberVO;


public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("UTF-8");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(email, pw, tel, address);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.insertMember(vo);
		
		if (cnt > 0) {
			System.out.println("회원가입 성공");
			RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
			request.setAttribute("joinEmail", email);
			rd.forward(request, response);
		} else {
			System.out.println("회원가입 실패");
			response.sendRedirect("main.jsp");
		}
	}

}
