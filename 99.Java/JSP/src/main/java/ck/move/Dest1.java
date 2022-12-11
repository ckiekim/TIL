package ck.move;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Dest1
 */
@WebServlet("/dst1")
public class Dest1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String addr = (String)request.getAttribute("addr");
		
		HttpSession session = request.getSession();
		String tech = (String)session.getAttribute("tech");
		
		// ServletContext appl = request.getServletContext();
		ServletContext appl = getServletContext();
		Member member = (Member)appl.getAttribute("member");
		
		//response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>Request: " + addr + "</h1>");
		out.print("<h1>Session: " + tech + "</h1>");
		out.print("<h1>Servlet: " + member.toString() + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
