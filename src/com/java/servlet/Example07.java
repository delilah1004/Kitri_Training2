package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @이다은 2020. 6. 8.
 *
 * 아이디 비밀번호 입력받기
 */

public class Example07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example07() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 객체 
		// 문서 타입, 한글 : setContentType() 설정
		// 출력 : getWriter()
		// 쿠키 저장(설정) 기능, (파일업로드시)헤더 설정 기능
		// 페이지 이동 : sendRedirect
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		System.out.println(id + "\t" + pass);
		
		// 원래 DB를 직접 연동해야 하지만 임시로 테스트
		String dbId = "abc123";
		String dbPass = "abc123";
		
		// 같은 패키지내의 서블릿 간의 이동시 URL, URI 모두 사용 가능
		if(id.equals(dbId)&&pass.equals(dbPass)) {
			response.sendRedirect("/webTesting/com/java/servlet/Example07_Success");
		} else {
			response.sendRedirect("/webTesting/com/java/servlet/Example07_Fail");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
