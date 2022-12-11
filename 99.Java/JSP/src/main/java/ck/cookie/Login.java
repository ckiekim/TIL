package ck.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        
        String uid = request.getParameter("uid");
        String pwd = request.getParameter("pwd");
        HttpSession session = request.getSession();
        System.out.println((String)session.getAttribute("uid"));
        
        if (session.isNew()) {
            if (uid != null) {
                session.setAttribute("uid", uid);
                out.print("<a href=\"/login\">로그인 상태 확인</a>");
            } else {
                System.out.println("재로그인하세요.");
                out.print("<a href=\"/login.html\">다시 로그인 하세요.</a>");
                session.invalidate();
            }
        } else {
            uid = (String)session.getAttribute("uid");
            if (uid != null && uid.length() != 0)
                out.print("<h1>안녕 " + uid + "</h1>");
            else {
                System.out.println("다시 로그인하세요.");
                out.print("<a href=\"/login.html\">다시 로그인 하세요.</a>");
                session.invalidate();
            }
        }
        
	}

}
