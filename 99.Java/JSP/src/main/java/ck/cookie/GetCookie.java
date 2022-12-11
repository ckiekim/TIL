package ck.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookie
 */
@WebServlet("/getCookie")
public class GetCookie extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    Cookie[] cookies = request.getCookies();
	    
	    response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        for (Cookie c: cookies) {
            if (c.getName().equals("CookieTest"))
                out.print("<h1>" + c.getName() + ": " + URLDecoder.decode(c.getValue(), "utf-8") + "</h1>");
            out.print("<h1>" + c.getName() + ": " + c.getValue() + "</h1>");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
