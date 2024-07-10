package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name = "문주영";
//		resp.setContentType("text/html"); // text/plain 하면 태그들 보여줌
//		resp.setCharacterEncoding("utf-8");
//		
//		resp.getWriter().println(""
//				+ "<html>"
//				+ "<head>"
//				+ "<title>hello</title>"
//				+ "</head>"
//				+ "<body>"
//				+ "<h1>Hello Servlet!!!</h1>"
//				+ "<h2>"+ name + "</h2>"
//				+ "</body>"
//				+ "</html>");
//
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name"); // parameter는 무조껀 문자열!
		String age = req.getParameter("age");
		
		System.out.println(name);
		System.out.println(age);
		
		// Servlet은 같은 서버 안에 있는 거라 RequestDispatcher를 통해 요청 및 응답
		// getter setter 느낌
		req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp); 
	}
	
}
