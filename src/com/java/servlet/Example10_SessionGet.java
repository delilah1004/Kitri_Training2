package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Example09_CookieGet
 */
public class Example10_SessionGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Example10_SessionGet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		

		if (!session.isNew()) {
			String id = (String) session.getAttribute("id");
			String pass = (String) session.getAttribute("pass");
			
			System.out.println(id + "\t" + pass + "\t" + session.getId());
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();

			out.print("<html>");
			out.print("<head><title></title></head>");
			out.print("<body>");
			
			out.println("<h4>" + id + "&nbsp;&nbsp;" + pass + "&nbsp;&nbsp;" + session.getId() + "</h4>");
			
			out.print("</body>");
			out.print("</html>");

			out.close();
			
		}


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
