package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example09_CookieGet
 */
@WebServlet("/Example09_CookieGet")
public class Example09_CookieGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Example09_CookieGet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		Cookie[] cookies = request.getCookies();
		// System.out.println(cookies.length);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				out.println("<h5>" + cookies[i].getName() + "</h5>");
				out.println("<h3>" + cookies[i].getValue() + "</h3>");
			}
			
			String contextPath = request.getContextPath();

			for (int i = 0; i < cookies.length; i++) {
				String imgStr = contextPath + "/img/" + cookies[i].getValue() + ".png";

				out.print("<img src='" + imgStr + "' height='200'/>");
			}
		} else {
			out.println("<h3>장바구니 비워짐</h3>");
		}

		out.print("</body>");
		out.print("</html>");

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
