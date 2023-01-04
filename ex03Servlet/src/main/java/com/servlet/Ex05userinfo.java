package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex05userinfo")
public class Ex05userinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> arr = new ArrayList<>();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String method = request.getMethod();
		System.out.println("method : "+method);
		
		// 데이터 받아오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String rpw = request.getParameter("rpw");
		String gender = request.getParameter("gender");
		String abc = request.getParameter("abc");
		String data = request.getParameter("data");
		
		String hobby[] = request.getParameterValues("hobby");
		String color = request.getParameter("color");
		String talk = request.getParameter("talk");
		
		out.print("<h3>ID : "+ id +"\n <br>");
		out.print("pw : "+ pw+"\n <br>");
		out.print("rpw : "+ rpw+"\n <br>");
		out.print("성별 : "+ gender+"\n <br>");
		out.print("abc : "+ abc+"\n <br>");
		out.print("data : "+ data+"\n <br>");
		out.print("sport : ");
		for(int i = 0; i < hobby.length ; i++) {
		out.print(hobby[i]+" ");	
		}
		out.print("<br>");
		out.print("color : "+ color+"\n <br>");
		out.print("talk : "+ talk+"</h3>");
	}

}
