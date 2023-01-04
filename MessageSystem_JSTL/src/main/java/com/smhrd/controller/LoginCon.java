package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.domain.MemberDAO;
import com.smhrd.domain.MemberVO;


public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberVO vo = new MemberVO(email,pw);
		
		MemberDAO dao = new MemberDAO();
		MemberVO loginVo = dao.selectMember(vo);
		
		if (loginVo!=null) {
			System.out.println("로그인성공");
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", loginVo);
			response.sendRedirect("main.jsp");
		} else {
			System.out.println("로그인실패");
			response.sendRedirect("main.jsp");
		}
	}

}
