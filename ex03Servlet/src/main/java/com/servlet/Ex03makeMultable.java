package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex03makeMultable")
public class Ex03makeMultable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String color = request.getParameter("color");
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		// out.print("<style> table{background-color : "+color+"}</style>");

		out.print("<table border = 1 style='background-color : "+color+"'>");
		
		for(int i = num1 ; i <= num2 ; i++) {
			out.print("<tr>");
			for(int k = 1 ; k <= 9 ; k++) {
				out.print("<td>"+num1+"*"+k+"="+num1*k+"</td>");
				
			}
			num1++;
			out.print("</tr>");
		}
		
		out.print("</table>");

	}

}
