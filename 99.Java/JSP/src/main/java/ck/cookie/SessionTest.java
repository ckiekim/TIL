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
@WebServlet("/sess")
public class SessionTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        out.print("<h1>세션 아이디: " + session.getId() + "</h1>");
        out.print("<h1>최초 세션 생성 시각: " + new Date(session.getCreationTime()) + "</h1>");
        out.print("<h1>최근 세션 접근 시각: " + new Date(session.getLastAccessedTime()) + "</h1>");
        out.print("<h1>세션 유효 시간: " + session.getMaxInactiveInterval() + "</h1>");
        if (session.isNew())
            out.print("<h1>새 세션이 만들어졌습니다.</h1>");
        
        session.invalidate();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
