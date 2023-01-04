package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberVO;

public class JoinCon implements MessageCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		// 데이터베이스에 한번에 값 넣어주기
		MemberVO vo = new MemberVO(email, pw, tel, address);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.insertMember(vo);
		
		if(cnt > 0) {
			System.out.println("회원가입 성공");
			// 포워딩 방식 joinSuccess.jsp로 이동, email -> request 영역에 저장
			// RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
			request.setAttribute("joinEmail", email);
			// rd.forward(request, response);
			
			return "joinSuccess.jsp";
			
		}else {
			System.out.println("회원가입 실패");
			// response.sendRedirect("main.jsp");
			return "main.jsp";
		}
		
	}

}
