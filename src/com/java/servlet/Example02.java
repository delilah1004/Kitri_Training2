package com.java.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 김아름
 * @date   : 2020. 6. 5.
 * @description : 서버 페이지 작성. 넘겨주는 값이 있는 경우
 */

public class Example02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Example02() {
		super();
	}
	
//	// 디폴트로 제공해주기 때문에 작성하지 않아도 된다.
//	public void init() {
//
//	}
//
//	public void service(HttpServletRequest request, HttpServletResponse response) {
//		doGet(request, response);
//	}
//
//	public void destroy() {
//
//	}
	
	// init() → service() → doGet() → destroy() 
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		// 웹 브라우저에서 값을 던져준다. request 객체에 값(String 타입)이 저장되고 request 객체의 메소드를 이용해서 값을 출력해준다.
		String su=request.getParameter("su");	// 파라미터도 String, 반환형도 String
		System.out.println("su : "+su);
		
		// 문자열 → 정수
		int value=Integer.parseInt(su);
		// 정수 → 문자열
		String a=String.valueOf(value);
		
		Integer i=value;
		String b=i.toString();
		System.out.println(a+"\t"+b);		
	}
	
}
