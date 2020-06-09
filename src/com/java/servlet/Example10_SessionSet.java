package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @이다은 2020. 6. 9.
 *
 * 웹브라우저에서 서버로 어떤 데이터를 요청하면, 서버측에서는 알맞은 로직을 수행한 후
 * 데이터를 웹브라우저에 응답한 후 서버는 웹브라우저와의 관계를 종료한다.
 * 연결이 끊겼을 때 어떤 정보를 지속적으로 유지하기 위한 수단으로 쿠키라는 방식을 사용한다.
 * 쿠키는 서버에서 생성하여 서버가 아닌 클라이언트측에 특정 정보를 저장한다. (4KB 용량제한)
 * 
 * 세션도 쿠키와 마찬가지로 서버와의 관계를 유지하기 위한 수단입니다.
 * 단, 쿠키와 달리 클라이언트의 특정 위치에 저장되는 것이 아니라, 서버상에 객체로 존재한다.
 * 
 * 따라서 세션은 서버에서만 접근이 가능하여 보안이 좋고, 데이터 용량 한계가 없다.
 */

public class Example10_SessionSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example10_SessionSet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		System.out.println(id + "\t" + pass);
		
		// 현재 session 존재하면 기존 session 리턴하고, 존재하지 않은 새로운 session 리턴
		HttpSession session = request.getSession();
		
		String msg = "";
		
		if(session.isNew()) {
			System.out.println("새로운 세션이 생성되었습니다.");
			msg = "새로운 세션이 생성되었습니다.";
			session.setAttribute("id", id);
			session.setAttribute("pass", pass);
		} else {
			System.out.println("기존 세션을 반환합니다.");
			msg = "기존 세션을 반환합니다.";
//			session.getAttribute(id);
//			session.getAttribute(pass);
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		
		out.print("<script type='text/javascript'>");
		out.print("alert('로그인 성공, "+ msg +"');");
		out.print("location.href='http://localhost:8181/webTesting/Servlet/10_Example.html';");
		out.print("</script>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
