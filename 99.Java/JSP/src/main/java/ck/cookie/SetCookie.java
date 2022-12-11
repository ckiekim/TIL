package ck.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookie
 */
@WebServlet("/setCookie")
public class SetCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie c = new Cookie("CookieTest", URLEncoder.encode("JSP 프로그래밍", "utf-8"));
		c.setMaxAge(24*60*60);
		response.addCookie(c);
		
		LocalDateTime now = LocalDateTime.now();
		out.print("<h1>현재시간: " + now + "</h1>");
		out.print("<h1>현재시간을 Cookie로 저장합니다.</h1>");
		out.print("<h1>CookieTest: " + URLDecoder.decode(URLEncoder.encode("JSP 프로그래밍", "utf-8"), "utf-8") + "</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
