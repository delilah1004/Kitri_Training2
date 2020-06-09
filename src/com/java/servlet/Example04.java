package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 김아름
 * @date   : 2020. 6. 8.
 * @description : 넘겨받은 값을 다시 뷰에 넘겨주어서 잘 출력되면 → DB에 저장하고, DB에서 확인한다.
 */

public class Example04 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Example04() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String addr=req.getParameter("addr");
		System.out.println(name+"\t"+phone+"\t"+addr);
		
		//PrintWriter(출력을 위한 보조스트림) - BufferedWriter(char) - OutputStreamWriter(char를 byte로 변환) - Socket.getOutputStream() (byte)
		
		resp.setContentType("text/html;charset=utf-8");	// 나가는 데이터의 타입과 인코딩 타입을 알려주어야 한다.
		PrintWriter pw=resp.getWriter();
		
		pw.print("<html>");
		pw.print("<head><title></title></head>");
		pw.print("<body>");
		pw.print("<h3>회원가입이 잘 되었습니다.</h3>");
		pw.print("</body>");
		pw.print("</html>");
		
		pw.close();		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 소스중복되지않고 다른 메소드를 호출한다.
		doGet(req,resp);
	}
}
