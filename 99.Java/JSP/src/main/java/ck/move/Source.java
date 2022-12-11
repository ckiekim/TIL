package ck.move;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Source
 */
@WebServlet("/src")
public class Source extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
        request.setAttribute("addr", "용인시 수지구 성복동");
        
        HttpSession session = request.getSession();
        session.setAttribute("tech", "자바, 세션, 서블릿");
        
        Member member = new Member("홍길동", 30);
        // ServletContext appl = request.getServletContext();
        ServletContext appl = getServletContext();
        appl.setAttribute("member", member);

        RequestDispatcher rd = request.getRequestDispatcher("/dst1");
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
