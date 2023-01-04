package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;

public class DeleteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		System.out.println(email);
		// DAO - deleteMember() 만들기
		// sql문 작성(MemberMapper.xml)
		// 삭제 성공시 -> 콘솔창에 "삭제성공"
		// -> select.jsp로 이동
		// 삭제 실패시 -> 콘솔창에 "삭제실패"
		// -? select.jsp로 이동
		MemberDAO dao = new MemberDAO();
		int cnt = dao.deleteMember(email);
		
		if(cnt > 0 ) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		response.sendRedirect("select.jsp");
	}

}
