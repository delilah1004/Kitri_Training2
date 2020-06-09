package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @이다은 2020. 6. 9.
 *
 * 
 */

public class Example09_CookieDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example09_CookieDel() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				cookies[i].setMaxAge(0);	// 0넣으면 지워짐
				response.addCookie(cookies[i]);
			}
		}
				
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		
		out.print("<script type='text/javascript'>");
		out.print("alert('장바구니를 비웠습니다.');");
		out.print("location.href='http://localhost:8181/webTesting/Servlet/09_Example.html';");
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
