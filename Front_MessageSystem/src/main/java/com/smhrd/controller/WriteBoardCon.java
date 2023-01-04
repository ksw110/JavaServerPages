package com.smhrd.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.model.BoardDAO;
import com.smhrd.model.BoardVO;

public class WriteBoardCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post 방식 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// MultipartRequest에서 필요한 매개변수 설정
		// 1. 모둔 요청의 정보가 담겨있는 request 객체
		// 2. 업로드 된 파일(이미지)을 저장할 경로
		String path = request.getServletContext().getRealPath("./file");
		System.out.println(path);
		
		// 3. 파일의 max size
		int maxSize = 10*1024*1024;
		
		// 4. 인코딩 방식
		String encoding = "UTF-8";
		
		// 5. 중복제거 -> 파일명 뒤에 숫자 붙여주는 객체 중복되면 자동으로 1 or 2 ... 붙여줌
		DefaultFileRenamePolicy rename = new DefaultFileRenamePolicy();
		
		// 파일 업로드 -> MultipartRequest -> cos.jar
		MultipartRequest multi = new MultipartRequest(request, path, maxSize, encoding, rename);
		
		
		// DB에 저장하기 위해서 게시글 정보 가져오기
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		
		// 한글 이름은 인코딩해야 나중에 이미지 확인가능!
		// URLEncoder.encode(인코딩할 값, 인코딩 방식)
		// Integer.paresInt(형변환할 값) 같음
		String filename = URLEncoder.encode(multi.getFilesystemName("filename"), "UTF-8");
		String content = multi.getParameter("content");
		
		System.out.println("title : "+title);
		System.out.println("writer : "+writer);
		System.out.println("filename : "+filename);
		System.out.println("content : "+content);
		
		BoardVO vo = new BoardVO(title,writer,filename,content);
		
		
		int cnt = new BoardDAO().upload(vo);
		
		if(cnt > 0) {
			System.out.println("업로드 성공");
		}else {
			System.out.println("업로드 실패");
		}
		response.sendRedirect("boardMain.jsp");
		
		
		
		
		
	}

}
