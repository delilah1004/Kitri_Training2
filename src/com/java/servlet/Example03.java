package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 김아름
 * @date   : 2020. 6. 8.
 * @description : post 방식으로 데이터값 전달하기. 주소창 확인해보면 전달된 파라미터 값이 표시되지 않는다. 한글은 깨져서 나온다.(디코딩 인코딩 필요하다.)
 */

public class Example03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Example03() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() 생략가능, 서버 메모리에 처음 올라갈 경우에만 실행.");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 생략가능, 스레드 처리되서 반복 실행 ");
		//doGet(req,resp);
		doPost(req,resp);
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg=req.getParameter("msg");
		System.out.println(msg);
	}	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String msg=req.getParameter("msg");
		System.out.println(msg);
		
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 생략가능, 서버 종료  및 업데이트 시 실행.");
	}
	
}
