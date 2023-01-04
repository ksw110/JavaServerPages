package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberVO;

public class UpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		// 누가 정보를 수정하는지 알 수 있을까? -> 로그인한 사람의 정보(세션안에 저장돼있음)
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
		String email = loginMember.getEmail();
		
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(email, pw, tel, address);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.updateMember(vo);
		
		if(cnt > 0) {
			System.out.println("회원정보수정 성공");
			session.setAttribute("loginMember", vo);
			response.sendRedirect("main.jsp");
		}else {
			System.out.println("회원정보수정 실패");
			response.sendRedirect("update.jsp");
		}
		
	
	}

}
