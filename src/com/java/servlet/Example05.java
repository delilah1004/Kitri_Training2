package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Example05 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int su=Integer.parseInt(req.getParameter("su"));
		String buho=req.getParameter("buho");
		//char ch=buho.charAt(0);		
		int value=Integer.parseInt(req.getParameter("value"));
		
		System.out.println(su+"\t"+buho+"\t"+value);
		
		String result="";
		if(buho.equals("+")) {
			/*Integer r=su+value;
			result=r.toString();*/
			result=String.valueOf(su+value);
		}else if(buho.equals("-")) {
			result=String.valueOf(su-value);
		}else if(buho.equals("*")) {
			result=String.valueOf(su*value);
		}else if(buho.equals("/")) {
			result=String.valueOf((float)su/value);
		}
		System.out.println(result);
		// 유효성 검사는 자바 스크립트에서 진행하는 것으로 하자.
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		out.println("<h3>결과 : "+result+"</h3>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
