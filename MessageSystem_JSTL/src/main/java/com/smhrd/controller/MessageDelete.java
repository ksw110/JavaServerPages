package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.domain.MessageDAO;


public class MessageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		MessageDAO dao = new MessageDAO();
		int cnt = dao.deleteMessage(num);
		
		if (cnt > 0) {
			System.out.println("메세지 삭제 성공");
			response.sendRedirect("main.jsp");
		} else {
			System.out.println("메세지 삭제 실패");
			response.sendRedirect("main.jsp");
		}
	}

}
