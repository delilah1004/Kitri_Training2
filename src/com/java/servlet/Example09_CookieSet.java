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

public class Example09_CookieSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example09_CookieSet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] image = request.getParameterValues("image");
		System.out.println(image.length);
		
		// sessionScope : context(webTesting) 안에 모든 page에서 공유
		// response : 쿠키 설정(저장), request : 쿠키 읽기
		
		if(image.length != 0) {
			for(int i=0;i<image.length;i++) {
				// key, value
				
				String key = "image" + (i+1);
				String value = image[i];
				System.out.println(key + ", " + value);
				
				Cookie cookie = new Cookie(key, value);	
				cookie.setMaxAge(60*60*24);	// 초*분*시*일 : (60*60*24*365)
				response.addCookie(cookie);	
			}
		}
				
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		
		out.print("<script type='text/javascript'>");
		out.print("alert('장바구니에 담겼습니다.');");
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
