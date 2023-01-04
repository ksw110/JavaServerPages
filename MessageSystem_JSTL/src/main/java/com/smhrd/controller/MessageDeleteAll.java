package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.domain.MemberVO;
import com.smhrd.domain.MessageDAO;


public class MessageDeleteAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO)session.getAttribute("loginVO");
		String email = loginMember.getEmail();
		
		MessageDAO dao = new MessageDAO();
		int cnt = dao.deleteMessageAll(email);
		
		if (cnt > 0) {
			System.out.println("메세지 전체 삭제 성공");
			response.sendRedirect("main.jsp");
		} else {
			System.out.println("메세지 전체 삭제 실패");
			response.sendRedirect("main.jsp");
		}
	}

}
