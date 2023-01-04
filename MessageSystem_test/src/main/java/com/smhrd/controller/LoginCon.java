package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberVO;

public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		// System.out.println(email + ", " + pw);
		
		MemberVO vo = new MemberVO(email, pw);
		MemberDAO dao = new MemberDAO();
		MemberVO loginMember = dao.selectMember(vo);
		
		if(loginMember != null) { // 로그인 성공
			System.out.println("로그인 성공");
			
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			response.sendRedirect("main.jsp");
			
		}else { // 로그인 실패
			System.out.println("로그인 실패");
			response.sendRedirect("main.jsp");
		}
		
		
		
		
		
	}
	

}
