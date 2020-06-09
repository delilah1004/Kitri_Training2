package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 김아름
 * @date   : 2020. 6. 5.
 * @description : 서버 페이지 작성. 넘겨주는 값이 없는 경우.
 */

public class Example01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 서버 메모리 : Content 단위로 올라간다. 각각의 Content 안에 Context(webTesting프로젝트)가 있다.
	public Example01() {
		super();
	}
	
	// 생명주기
	// 초기화
	public void init() {
		System.out.println("서블릿 파일 초기화 (처음 요청 시 단 한번)");
	}
	
	// 서비스 - get, post 함수 호출.
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("★☆ 서블릿 내용 doGet 함수입니다.");
	}
	
	// 소멸
	public void destroy() {
		System.out.println("서블릿 파일 소멸");
	}
}
