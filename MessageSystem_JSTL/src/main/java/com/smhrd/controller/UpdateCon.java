package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.domain.MemberDAO;
import com.smhrd.domain.MemberVO;


public class UpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO)session.getAttribute("loginVO");
		String email = loginMember.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(email,pw,tel,address);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.updateMember(vo);
		
		if (cnt > 0) {
			System.out.println("회원정보수정 성공");
			session.setAttribute("loginVO", vo);
			response.sendRedirect("main.jsp");
		} else {
			System.out.println("회원정보수정 실패");
			response.sendRedirect("update.jsp");
		}
	}

}
