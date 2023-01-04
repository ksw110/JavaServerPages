package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.domain.MemberDAO;
import com.smhrd.domain.MemberVO;
import com.smhrd.domain.MessageDAO;
import com.smhrd.domain.MessageVO;


public class MessageSend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("UTF-8");
		
		String sendName = request.getParameter("sendName");
		String receiveEmail = request.getParameter("receiveEmail");
		String message = request.getParameter("message");

		MessageVO vo = new MessageVO(sendName,receiveEmail,message);
		
		MessageDAO dao = new MessageDAO();
		int cnt = dao.insertMessage(vo);
		
		if (cnt > 0) {
			System.out.println("메세지 전송 성공");
			response.sendRedirect("main.jsp");
		} else {
			System.out.println("메세지 전송 실패");
			response.sendRedirect("main.jsp");
		}
	}

}
