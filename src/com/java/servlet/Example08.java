package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @이다은 2020. 6. 9.
 *
 * 
 */

public class Example08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example08() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String message = request.getParameter("message");
		System.out.println("Example08" + message);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		
		request.setAttribute("name", "홍길동");
		request.setAttribute("phone", "010-123-1234");
		
		RequestDispatcher rd = request.getRequestDispatcher("/com/java/servlet/Example08_Sub");
		rd.include(request, response);
		
		out.print("<hr color = 'red' width = '600px'/>");
		out.print("<h3>include는 다시 돌아온다. 제어권을 넘겨주지 않는다.</h3>");
		out.print("<h3>서블릿에서 데이터 생명주기 pageScope, requestScope, sessionScope, applicationScope</h3>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
