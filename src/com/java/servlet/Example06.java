package com.java.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example06
 */

/**
 * @author : 김아름
 * @date   : 2020. 6. 8.
 * @description : servlet 파일로 만들면 자동생성된다.
 */

public class Example06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example06() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 객체 역할 : 사용자 요청
		// 한글 Encoding 기능
		// 파라미터 읽기 기능
		// 서버와 관련된 정보 읽기 기능	******
		// 웹 브라우저 관련 정보 읽기 기능
		// 헤더 읽기 기능	******
		// 쿠키 읽기 기능	****
		// 속성 처리 기능	서블릿 간의 이동 기능
		

		// **한글 Encoding 기능
		request.setCharacterEncoding("utf-8");		
		
		// **파라미터 읽기 기능
		int su = Integer.parseInt(request.getParameter("su"));
		System.out.println(su);
		
		// **서버와 관련된 정보 읽기
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		
		// IP주소와 포트번호를 포함한 서블릿 파일까지의 경로
		StringBuffer URL = request.getRequestURL();
		// Uniform Resource Location, http://localhost:8181/webTesting/com/java/servlet/Example06
		
		// 해당 서블릿의 컨텍스트(프로젝트명)부터 서블릿 파일까지의 경로
		String URI = request.getRequestURI();
		// Uniform Resource Identifier, /webTesting/com/java/servlet/Example06
		
		// 해당 컨텍스트(프로젝트)명
		String contextPath = request.getContextPath();
		// /webTesting
		
		// 해당 서블릿의 패키지부터 서블릿 파일까지의 경로
		String servletPath = request.getServletPath();
		// /com/java/servlet/Example06
		
		System.out.println("서버이름 : " + serverName);
		System.out.println("서버포트 : " + serverPort);
		System.out.println("URL : " + URL);
		System.out.println("URI : " + URI);
		System.out.println("컨텍스트(프로젝트명) 경로 : " + contextPath);
		System.out.println("서블릿 경로 : " + servletPath);
		System.out.println("요청방식 : " + request.getMethod());
		
		
		// 클라이언트 정보 및 웹 브라우저 관련 정보 읽기 기능
		System.out.println("요청 프로토콜 : " + request.getProtocol());
		System.out.println("클라이언트 주소 : " + request.getRemoteAddr());
		System.out.println("클라이언트 포트 : " + request.getRemotePort());
		
		
		// 헤더 읽기 기능 ****중요*****
		Enumeration<String> header = request.getHeaderNames();
		while(header.hasMoreElements()) {
			String key = header.nextElement();
			String value = request.getHeader(key);
			System.out.println(key + "\t" + value);
		}
		
		// 쿠키 읽기 기능 - 쿠키 저장 Response 기능
		// 속성 처리 기능
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
