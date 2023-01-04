package com.smhrd.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.Member;

@WebServlet("/LoginProgram")
public class LoginProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		// Connection(conn), PreparedStatement(psmt) ResultSet(rs)

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Member vo = null;

		try {
			// 1. 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";

			// 2. Connection 객체 생성 -> DataBase와 연동
			conn = DriverManager.getConnection(url, db_id, db_pw);

			// 3. sql 작성 및 전송
			String sql = "select * from webmember where id=? and pw=?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
				String get_id = rs.getString(1);
				String get_pw = rs.getString(2);
				String get_name = rs.getString(3);
				
				// dto : 필드, 생성자메소드, getter/setter메소드
				// VO : 필드, 생성자메소드, getter메소드 수정하는 set를 만들지않음
				vo = new Member(get_id, get_pw, get_name);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4. 객체 닫아주기
			try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (vo != null) { // 로그인 성공
			
			// 세션 생성
			HttpSession session = request.getSession();
			
			// setAttribute(name, value)
			session.setAttribute("member", vo);
			response.sendRedirect("LoginSuccess.jsp");
			

		} else { // 로그인 실패
			response.sendRedirect("LoginFail.html");
		}

	}

}
