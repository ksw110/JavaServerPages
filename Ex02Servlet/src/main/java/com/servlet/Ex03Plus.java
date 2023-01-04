package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex03Plus")
public class Ex03Plus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("data");
		String data1 = request.getParameter("data1");
		
		response.setContentType("text/html; charset=UTF-8");
		int sum = Integer.parseInt(data)+Integer.parseInt(data1);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		out.print(data+" + "+data1+" = "+sum);
	}

}
