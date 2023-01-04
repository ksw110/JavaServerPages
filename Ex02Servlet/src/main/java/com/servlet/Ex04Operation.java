package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex04Operation")
public class Ex04Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sum = 0;
		int data1 = Integer.parseInt(request.getParameter("data1"));
		int data3 = Integer.parseInt(request.getParameter("data3"));
		String data2 = request.getParameter("data2");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		System.out.println(data2);
		if(data2.equals("+") ) {
			sum = data1+data3;
		}else if(data2.equals("*")) {
			sum = data1 * data3;
		}else if(data2.equals("/")) {
			sum = data1 / data3;
		}else if(data2.equals("-")) {
			sum = data1 - data3;
		}else {
			out.print("잘못 입력 하셨습니다");
		}
		out.print(data1+" "+data2+" "+data3+" = "+sum);
	}

}
